package com.chinawiserv.dsp.dir.controller.apply;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.*;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.chinawiserv.dsp.dir.entity.po.apply.DirRegistUser;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirRegistUserVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.RegistUserStatus;
import com.chinawiserv.dsp.dir.service.apply.IDirRegistUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户注册表 前端控制器
 * </p>
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirRegistUser")
public class DirRegistUserController extends BaseController {
    @Autowired
    ISysUserService sysUserService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IDirRegistUserService service;
    @Value("${mail.switch}")
    private String mailSwitch;
    /**
     * 执行编辑
     */

    @RequiresPermissions("apply:registUser:list")
    @RequestMapping("")
    public String init(@RequestParam Map<String, Object> paramMap) {
        setCurrentMenuInfo(paramMap);
        return "apply/registUser/dirRegistUserList";
    }

    /**
     * 新增用户注册表
     */
//    @RequiresPermissions("xx:xx:add")
   /* @RequestMapping("/add")
    public  String add(){
		return "apply/registUser/dirRegistUserAdd";
    }*/

    /**
     * 执行新增
     */
//    @RequiresPermissions("xx:xx:add")
   /* @Log("创建用户注册表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirRegistUserVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建用户注册表成功");
		} catch (Exception e) {
		    handleResult.error("创建用户注册表失败");
		    logger.error("创建用户注册表失败", e);
		}
		return handleResult;
    }*/

    /**
     * 分页查询用户注册表
     */
//    @RequiresPermissions("apply:registUser:list")
    @RequestMapping(value = "/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String, Object> paramMap) {
        PageResult pageResult = new PageResult();
        SysUserVo user = ShiroUtils.getLoginUser();
        paramMap.put("deptId", user.getDeptId());
        paramMap.put("userId", user.getId());
//        paramMap.put("regionCode",user.getRegionCode());
        try {
            Page<DirRegistUserVo> page = service.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询用户注册表出错");
            logger.error("分页查询用户注册表出错", e);
        }
        return pageResult;
    }

    /**
     * 删除用户注册表
     */
    @RequiresPermissions("apply:registUser:delete")
    @Log("删除用户注册表")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public HandleResult delete(@RequestParam String id) {
        service.deleteById(id);
        return new HandleResult().success("删除用户注册表成功");
    }

    /**
     * 编辑用户注册表
     */
    @RequiresPermissions("apply:registUser:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        return "/apply/registUser/dirRegistUserList";
    }

    @RequiresPermissions("apply:registUser:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public HandleResult editLoad(@RequestParam String id) {
        HandleResult handleResult = new HandleResult();
        try {
            DirRegistUserVo vo = service.selectVoById(id);
            handleResult.put("vo", vo);
        } catch (Exception e) {
            handleResult.error("获取用户注册表信息失败");
            logger.error("获取用户注册表信息失败", e);
        }
        return handleResult;
    }

    @RequiresPermissions("apply:registUser:edit")
    @Log("审核用户注册表")
    @RequestMapping(value = "/doEdit", method = RequestMethod.PUT)
    @ResponseBody
    public HandleResult doEdit(@RequestBody DirRegistUserVo dirRegistUserVo) {
        HandleResult handleResult = new HandleResult();
        DirRegistUser dru = service.selectById(dirRegistUserVo.getId());
        try {
            if (dirRegistUserVo.getOpration()) {
                dirRegistUserVo.setStatus("1");
            } else {
                dirRegistUserVo.setStatus("2");
            }
            dirRegistUserVo.setStateName(RegistUserStatus.valueOf(EnumTools.getName(dirRegistUserVo.getStatus())).getChValue());
            service.updateVO(dirRegistUserVo);
            handleResult.success("审核用户注册表成功");
            return handleResult;
        } catch (Exception e) {
            handleResult.error("审核用户注册表失败");
            logger.error("审核用户注册表失败", e);
        } finally {

            /**
             * 发送邮件的处理，需要时放开代码
             * */
            if (!"on".equalsIgnoreCase(mailSwitch)) return handleResult;
            String status = dirRegistUserVo.getStatus();
            switch (status) {
                case "1": {
                    List<SysUser> userList = this.sysUserService.selectList(new EntityWrapper<SysUser>().addFilter("user_name = {0}", dru.getLoginName()));
                    if (CollectionUtils.isEmpty(userList)) {
                        SysUser su = new SysUser();
                        /**
                         * 初始化用户
                         * */
                        String password = RandomPasswordUtil.getRandomPassword(8);
                        su.setRegionCode(dru.getRegionCode());
                        su.setToken(DesUtil.encrypt(dru.getLoginName()));
                        su.setPassword(CommonUtil.string2MD5(password));
                        su.setUserName(dru.getLoginName());
                        su.setUserType(1);
                        su.setUserDesc("门户注册用户");
                        su.setDeptId(dru.getBelongDep());
                        su.setCellPhoneNumber(dru.getPhone());
                        su.setEmail(dru.getEmail());
                        su.setCreateTime(new Date());
                        su.setStatus(1);
                        su.setRealName(dru.getRealName());
                        su.setCreateUserId(ShiroUtils.getLoginUserId());
                        this.sysUserService.insert(su);
                        //发送邮件
                        MailSenderUtil.sendMail(
                                dru.getEmail(),
                                dru.getRealName(),
                                "账号申请结果",
                                dru.getRealName() + "先生（女士）:恭喜您，您的账号申请已通过。" + "<br>" + "账号是：" + dru.getLoginName() + "<br>密码是：" + password + "<br>" + "请及时登录更改密码。"
                        );
                    } else {
                        //发送邮件
                        MailSenderUtil.sendMail(
                                dru.getEmail(),
                                dru.getRealName(),
                                "账号申请结果",
                                dru.getRealName() + "先生（女士）:抱歉，您注册的用户名：" + dru.getLoginName() + "已存在，请重新注册。"
                        );
                    }
                }
                break;
                case "2":
                    MailSenderUtil.sendMail(
                            dru.getEmail(),
                            dru.getRealName(),
                            "账号申请结果",
                            dru.getRealName() + "先生（女士）:抱歉，您的账号申请未通过。"
                    );
                    break;
            }

        }
        return handleResult;
    }
}
