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
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
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

    /**
     * 初始化用户列表
     */
    @RequiresPermissions("system:user:list")
    @RequestMapping("")
    public String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
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

}