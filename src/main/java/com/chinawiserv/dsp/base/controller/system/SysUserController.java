package com.chinawiserv.dsp.base.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.DesUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysRoleMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import com.chinawiserv.dsp.base.service.system.ISysUserRoleService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
     * 日志服务
     */
    @Autowired
    private ISysLogService sysLogService;
    
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleMapper sysRoleMapper;



    /**
     * 初始化用户列表
     */
    @RequiresPermissions("system:user:list")
    @RequestMapping("")
    public String init(@RequestParam Map<String , Object> paramMap,Model model){
        setCurrentMenuInfo(paramMap);
        model.addAttribute("master",isMaster());
        return "system/user/userList";
    }
    /**
     * 分页查询用户
     */
      @RequiresPermissions("system:user:list")
      @RequestMapping("/list")
      @ResponseBody
      public PageResult list(@RequestParam Map<String , Object> paramMap){
          PageResult pageResult = new PageResult();
          try {
              Page<SysUserVo> pageData = sysUserService.selectVoPage(paramMap);
              pageResult.setPage(pageData);
          } catch (Exception e) {
              e.printStackTrace();
              pageResult.error("查询用户列表出错");
          }
          return pageResult;
      }
    /**
     * 新增用户
     */
      @RequiresPermissions("system:user:add")
      @RequestMapping("/add")
      public  String add(){
        return "system/user/userAdd";
    }

    /**
     * 执行新增
     */
    @Log("创建用户")
    @RequiresPermissions("system:user:add")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysUserVo user, HttpServletRequest request){
        HandleResult result = new HandleResult();
        if(checkRoleAndDept(user,result)){
            return result;
        }
        try {
            user.setToken(DesUtil.encrypt(user.getUserName()));
            sysUserService.insertVO(user);
              /**
             * 记录登录日志
             */
//            sysLogService.insertLog("创建用户成功", ShiroUtils.getLoginUser(), request.getRequestURI(), user.toString().replaceAll("password='(.*?)'","password='******'"));
        } catch (Exception e) {
            e.printStackTrace();
//            sysLogService.insertLog("创建用户失败", ShiroUtils.getLoginUser(), request.getRequestURI(), e.toString());
            return result.error("创建用户失败");
        }
        return result.success("创建用户成功");
    }

    private boolean checkRoleAndDept(SysUserVo user,HandleResult result){
        String[] roleIds = user.getRoleIds();
        String deptId = user.getDeptId();
        if(roleIds.length>0){
            SysRoleVo sysRoleVo = sysRoleMapper.selectVoById(roleIds[0]);
            if(sysRoleVo.getRoleLevel().equals(0)&&StringUtils.isNotBlank(deptId)){
                 result.error("区域管理员不能设置部门");
                 return true;
            }
            if(!sysRoleVo.getRoleLevel().equals(0)&&StringUtils.isBlank(deptId)){
                 result.error("普通角色必须设置部门");
                 return true;
            }
        }else{
             result.error("没有选择角色");
             return true;
        }
        return false;
    }

    /**
     * 删除用户
     */
    @Log("删除用户")
    @RequiresPermissions("system:user:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(String id){
       	String loginUserId = ShiroUtils.getLoginUserId();
        //不能删除系统管理员，不能删除自己
        if (!"549d321508db446e9bcaa477835fe5f1".equals(id) && !id.equals(loginUserId)) {
            try {
				sysUserService.delete(id);
			} catch (ErrorInfoException e) {
				e.printStackTrace();
				 return new HandleResult().error("删除用户失败：" + e.getMessage());
			}
            return new HandleResult().success("删除用户成功");
        } else {
            return new HandleResult().error("删除失败，用户不能删除自己！");
        }
    }

     /*
    * 批量删除用户
    * */

    @RequiresPermissions("system:user:deleteBatch")
    @Log("批量删除用户")
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public HandleResult deleteBatch(@RequestParam("idArr[]") List<String> ids){
        HandleResult handleResult = new HandleResult();
        String loginUserId = ShiroUtils.getLoginUserId();
        try {
            String userStr = "";
            for(String id : ids){
                //不能删除系统管理员，不能删除自己
                if (!"549d321508db446e9bcaa477835fe5f1".equals(id) && !id.equals(loginUserId)) {
                    //检查该用户是否可删
                    if(!userMapper.checkCanBeDeletedById(id)){
                        userStr = userStr + id +",";
                    }
                } else {
                    return new HandleResult().error("删除失败，用户不能删除自己！");
                }
            }
            if("".equals(userStr)){
                userMapper.deleteBatchUserByIds(ids);
                sysUserRoleService.deleteBatchByUserId(ids);

                handleResult.success("批量删除用户成功！");
            }else{
                handleResult.error("批量删除用户失败，批量选择的用户有系统内置的管理员用户或者在尝试删除自己！");
            }
        } catch (Exception e) {
            handleResult.error("批量删除用户失败");
            logger.error("批量删除用户失败", e);
        }
        return handleResult;
    }

    /**
     * 编辑用户
     */
    @RequiresPermissions("system:user:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        return "system/user/userEdit";
    }
    /**
     * 加载编辑用户数据
     */
    @RequiresPermissions("system:user:edit")
    @RequestMapping("/loadEditData")
    @ResponseBody
    public HandleResult loadEditData(@RequestParam String id){
        HandleResult result = new HandleResult();
        SysUserVo userVo;
        try {
            userVo = sysUserService.selectVoById(id);
            String token = userVo.getToken();
            if(StringUtils.isNotBlank(token)){
                /**
                 * 再次加密
                 * */
                userVo.setToken(DesUtil.encrypt(userVo.getToken()));
            }
            result.put("user", userVo);
        } catch (Exception e) {
            result.error("加载用户信息出错");
            e.printStackTrace();
        }

        return result;
    }
    /**
     * 执行编辑
     */
    @RequiresPermissions("system:user:edit")
    @Log("编辑用户")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysUserVo user,Model model){
       HandleResult result = new HandleResult();
        if(checkRoleAndDept(user,result)){
            return result;
        }
        try {            
            String loginUserId = ShiroUtils.getLoginUserId();
            if (loginUserId.equals(user.getId()) && user.getStatus() != 1) {
                result.error("编辑用户失败，不能禁用自己！");
            } else {
                user.setToken(DesUtil.encrypt(user.getUserName()));
                sysUserService.updateVO(user);
                result.success("编辑用户成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.error("编辑用户失败");
        }
        return result;
    }

    /**
     * 生成TOKEN
     * */
    @RequestMapping("/createToken")
    @ResponseBody
    public HandleResult createToken(@RequestParam Map<String,String> paramMap){
        HandleResult result = new HandleResult();
        String token = DesUtil.encrypt(paramMap.get("userName"));
        paramMap.put("token",token);
        if(sysUserService.createToken(paramMap)){
            String showToken = DesUtil.encrypt(token);
            result.setState(true);
            result.put("token",showToken);
        }else{
            result.setState(false);
        }
        return result;
    }
    /**
     * 验证注册用户名是否已存在
     */
    @RequestMapping("/insertCheckName")
    @ResponseBody
    public JSONObject insertCheckName(String userName){
        JSONObject resultJson = new JSONObject();
        List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0} and delete_flag=0", userName));
        if(list.size() > 0){
            resultJson.put("error" , userName+" 用户名已存在,请换一个尝试。" );
        } else {
            resultJson.put("ok" , "用户名很棒。");
        }
        return resultJson;
    }
    /**
     * 验证编辑用户名是否已存在
     */
    @RequestMapping("/editCheckName")
    @ResponseBody
    public JSONObject editCheckName(String userName,HttpServletRequest request) {
	    JSONObject resultJson = new JSONObject();

        String id = request.getParameter("userId");
        if (StringUtils.isNotBlank(id)) {
            SysUser user = sysUserService.selectById(id);
            String originalName = user.getUserName();
            if (StringUtils.equals(originalName, userName)) {
	            resultJson.put("ok" , "");
            } else {
                List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0}", userName));
                if (list.size() > 0) {
	                resultJson.put("error" , userName+" 用户名已存在,请换一个尝试。" );
                }
	            resultJson.put("ok" , "新用户名很棒。");
            }

        }
        else {
	        resultJson.put("error" , "验证失败" );
        }

        return resultJson ;
    }

    /**
     * 同步主系统用户信息
     */
//    @RequiresPermissions("system:user:add")
    @Log("获取主系统用户数据")
    @RequestMapping("/getMasterData")
    @ResponseBody
    public  HandleResult getMasterData(){
        HandleResult handleResult = new HandleResult();

        try {
            String result = getDataFromMaster(ISysUserService.synUrl);
            HandleResult jsb = JSONObject.parseObject(result, HandleResult.class);
            HashMap<String, Object> map = jsb.getContent();
            List<SysUser> list = JSONObject.parseArray(map.get("list").toString(), SysUser.class);
            if (sysUserService.insertOrUpdate(list)) {
                handleResult.success("更新成功");
            } else {
                handleResult.error("更新失败");
            }
        }catch (ErrorInfoException e){
            handleResult.error(e.getMessage());
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            handleResult.error("获取数据失败");
            logger.error("获取sys_user表数据失败", e);
        }



        return handleResult;
    }


    @Log("提供主数据")
    @RequestMapping("/provideData")
    @ResponseBody
    public  HandleResult provideData(@RequestParam String systemId){
        HandleResult handleResult = new HandleResult();
        try {
            List<SysUser> result = sysUserService.listBySystemId(systemId);
            handleResult.put("list", result);
        } catch (Exception e) {
            handleResult.error("获取sys_user表数据失败");
            logger.error("获取sys_user表数据失败", e);
        }
        return handleResult;
    }

}