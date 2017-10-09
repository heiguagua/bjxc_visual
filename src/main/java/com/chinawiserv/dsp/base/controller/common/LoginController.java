package com.chinawiserv.dsp.base.controller.common;

import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import com.chinawiserv.dsp.base.service.system.ISysMenuService;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.google.code.kaptcha.servlet.KaptchaExtend;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * 登录控制器
 *
 * @author Gaojun.Zhou
 * @date 2016年12月14日 下午2:54:01
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    /**
     * 用户服务
     */
    @Autowired
    private ISysUserService sysUserService;
    /**
     * 日志服务
     */
    @Autowired
    private ISysLogService sysLogService;
    @Autowired
    private ISysSettingService sysSettingService;
    @Autowired
    private ISysMenuService sysMenuService;


    /**
     * 登录页面
     *
     * @throws java.io.UnsupportedEncodingException
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String login(String return_url, Model model) throws UnsupportedEncodingException {
        String index = "/system/menu";//返回采集作业配置界面
        model.addAttribute("return_url", StringUtils.isNotBlank(return_url) ? URLDecoder.decode(return_url, "UTF-8") : index);
        return "login";
    }

    /**
     * 执行登录
     */
    @Log("用户登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam Map<String, Object> paramMap, Model model) {
        String userName = MapUtils.getString(paramMap, "userName");
        String password = MapUtils.getString(paramMap, "password");
        String captcha = MapUtils.getString(paramMap, "captcha");
        String return_url = MapUtils.getString(paramMap, "return_url");

		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) /*||  StringUtils.isBlank(captcha)*/){
			model.addAttribute("error", "用户名/密码/验证码不能为空.");
			return "login";
		}

		String sessionCaptcha = new KaptchaExtend().getGeneratedKey(request);
		if(StringUtils.isBlank(sessionCaptcha)){
			model.addAttribute("error", "验证码已过期,请重新输入.");
			return "login";
		}
		if(!captcha.toLowerCase().equals(sessionCaptcha.toLowerCase())){
			model.addAttribute("error", "验证码错误.");
			return "login";
		}

        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
//			password = new Sha256Hash(password).toHex();
            password = CommonUtil.string2MD5(password);
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);

            loginSuccess(paramMap);

            if (StringUtils.isNotBlank(return_url)) {
                return redirectTo(return_url);
            }

        } catch (UnknownAccountException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
            return "login";
        } catch (LockedAccountException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "账户验证失败");
            e.printStackTrace();
            return "login";
        }

        return redirectTo("/system/menu");
    }

    /**
     * @param paramMap
     */
    private void loginSuccess(Map<String, Object> paramMap) {
        SysUserVo currentLoginUser = ShiroUtils.getLoginUser();
        try {
            /**
             * 加载全局非登录访问常量
             */

            //todo remove
            List<SysSetting> list = sysSettingService.selectList(null);
            for (SysSetting setting : list) {
                ShiroUtils.setSessionAttribute(setting.getSettingCode(), setting.getSettingValue());
            }

            /**
             * 保存登录信息
             */
            currentLoginUser.setPassword("");
            ShiroUtils.setSessionAttribute(SystemConst.ME, currentLoginUser);
            /**
             * 资源和当前选中菜单
             */

            String res = MapUtils.getString(paramMap, "res");
            if (StringUtils.isNotBlank(res)) {
                ShiroUtils.setSessionAttribute(SystemConst.RES, res);
            }
            String cur = MapUtils.getString(paramMap, "cur");
            if (StringUtils.isNotBlank(cur)) {
                ShiroUtils.setSessionAttribute(SystemConst.CUR, cur);
            }
            /**
             * 获取当前用户的菜单
             */
            List<TreeMenu> treeMenus = sysMenuService.selectTreeMenuByUserId(currentLoginUser.getId());
            ShiroUtils.setSessionAttribute(SystemConst.TREE_MENUS, treeMenus);

            /**
             * 获取当前用户的权限列表,用于控制页面功能按钮是否显示
             */
            List<String> list2;
            list2 = sysMenuService.selectMenuIdsByuserId(currentLoginUser.getId());
            String[] permissions = list2.toArray(new String[list2.size()]);
            ShiroUtils.setSessionAttribute(SystemConst.PERMISSIONS, permissions);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 退出系统
     *
     * @return
     * @throws java.io.IOException
     */
    @Log("用户注销登录")
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysUser sysUser = ShiroUtils.getLoginUser();
        ShiroUtils.logout();

        if (sysUser != null) {
            sysLogService.insertLog("用户退出系统", sysUser, request.getRequestURI(), sysUser.getId());
        }
        return  redirectTo("/login");
    }

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KaptchaExtend kaptchaExtend = new KaptchaExtend();
        kaptchaExtend.captcha(request, response);
    }
}
