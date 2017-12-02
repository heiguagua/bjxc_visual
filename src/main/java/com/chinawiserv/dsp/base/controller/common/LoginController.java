package com.chinawiserv.dsp.base.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.base.service.system.*;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
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
        /**自留代码
         * String index = "/catalog/catalogue";
        model.addAttribute("return_url", StringUtils.isNotBlank(return_url) ? URLDecoder.decode(return_url, "UTF-8") : index);
        return "login";
        **/
    	 String index = "/index";
         if(ShiroUtils.isLogin()){ // already login
             return redirectTo(index);
         }
         model.addAttribute("return_url", StringUtils.isNotBlank(return_url) ? URLDecoder.decode(return_url, "UTF-8") : index);
//         EntityWrapper<SysSetting> wrapper = new EntityWrapper<>();
//         wrapper.setEntity(new SysSetting());
        // wrapper.where("setting_code={0} or setting_code={1} or setting_code={2}", "systemName", "systemShortName", "systemSubName","projectPortalName");
//         List<SysSetting> sysSettingList = sysSettingService.selectList(wrapper);
//         Map<String, String> sysNameMap = new HashMap<>();
//         for(SysSetting sysSetting : sysSettingList){
//             sysNameMap.put(sysSetting.getSettingCode(), sysSetting.getSettingValue());
//         }
         //组装系统名称
//         String loginViewName = sysNameMap.get("systemName");
//         String indexLogoName = sysNameMap.get("systemName");
//         if(StringUtils.isEmpty(sysNameMap.get("systemName"))){
//             loginViewName = sysNameMap.get("systemSubName");
//             indexLogoName = sysNameMap.get("systemSubName");
//         }else if(!StringUtils.isEmpty(sysNameMap.get("systemName")) && !StringUtils.isEmpty(sysNameMap.get("systemSubName"))){
//             indexLogoName = sysNameMap.get("systemName") + "-" + sysNameMap.get("systemSubName");
//         }
//         model.addAttribute("systemShortName", sysNameMap.get("systemShortName"));
//         model.addAttribute("loginViewName", sysNameMap.get("projectPortalName"));
//         model.addAttribute("indexLogoName", sysNameMap.get("systemName") + "-" + sysNameMap.get("systemSubName"));
        String code="systemShowName";
        ShiroUtils.setSessionAttribute(code, sysSettingService.findValueByCode(code));
//        model.addAttribute("systemShowName", sysNameMap.get("systemShowName"));


//        model.addAttribute("systemName", sysNameMap.get("systemName"));
//        model.addAttribute("systemSubName", sysNameMap.get("systemSubName"));
//        model.addAttribute("systemShortName", sysNameMap.get("systemShortName"));

        return "login";
    }

    /**
     * 执行登录
     */
//    @Log("用户登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam Map<String, Object> paramMap, Model model, RedirectAttributes redirectAttributes) {
        String userName = MapUtils.getString(paramMap, "userName");
        String password = MapUtils.getString(paramMap, "password");
        String captcha = MapUtils.getString(paramMap, "captcha");
        String return_url = MapUtils.getString(paramMap, "return_url");
        
        String index = "/index";
        if (StringUtils.isBlank(return_url)) {
            return_url = index;
        }
        model.addAttribute("return_url", StringUtils.isNotBlank(return_url) ? return_url : index);//登录失败再次登录时跳转到index修复
        model.addAttribute("userName", userName);
        redirectAttributes.addFlashAttribute("return_url", StringUtils.isNotBlank(return_url) ? return_url : index);//重定向参数。
        redirectAttributes.addFlashAttribute("userName", userName);
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
//            password = CommonUtil.string2MD5(password);
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);

            loginSuccess(paramMap);
            
          //验证码失效
            request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY,null);
            
            /**
             * 记录登录日志
             */
            sysLogService.insertLog("用户登录成功", ShiroUtils.getLoginUser(), request.getRequestURI(), "******");
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

//        return redirectTo("/catalog/catalogue");
        return redirectTo("/index");
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
            List<SysSettingVo> list = sysSettingService.listCodeAndValueByType("1");
            for (SysSettingVo setting : list) {
                ShiroUtils.setSessionAttribute(setting.getSettingCode(), setting.getSettingValue());
            }
//            String systemName = ShiroUtils.getSessionAttribute("systemName") == null ? "" : ShiroUtils.getSessionAttribute("systemName").toString();
//            String systemSubName = ShiroUtils.getSessionAttribute("systemSubName") == null ? "" : ShiroUtils.getSessionAttribute("systemSubName").toString();
//            String systemShortName = ShiroUtils.getSessionAttribute("systemShortName") == null ? "" : ShiroUtils.getSessionAttribute("systemShortName").toString();
//            String projectPortalName = ShiroUtils.getSessionAttribute("projectPortalName") == null ? "" : ShiroUtils.getSessionAttribute("projectPortalName").toString();
//
////            String loginViewName = systemName;
////            String indexLogoName = systemName;
////            if(StringUtils.isEmpty(systemName)){
////                loginViewName = systemSubName;
////                indexLogoName = systemSubName;
////            }else if(!StringUtils.isEmpty(systemName) && !StringUtils.isEmpty(systemSubName)){
////                indexLogoName = systemName + "-" + systemSubName;
////            }
////            ShiroUtils.setSessionAttribute("loginViewName", loginViewName);
////            ShiroUtils.setSessionAttribute("indexLogoName", indexLogoName);
//
//            ShiroUtils.setSessionAttribute("projectPortalName", projectPortalName);
//            ShiroUtils.setSessionAttribute("systemName", systemName);
//            ShiroUtils.setSessionAttribute("systemShortName", systemShortName);
//            ShiroUtils.setSessionAttribute("systemSubName", systemSubName);


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
            //获取当前用户的区域编码
            ShiroUtils.setSessionAttribute(SystemConst.REGION, currentLoginUser.getRegionCode());
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
//    @Log("用户注销登录")
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysUser sysUser = ShiroUtils.getLoginUser();
        ShiroUtils.logout();

//        if (sysUser != null) {
            sysLogService.insertLog("用户退出系统", sysUser, request.getRequestURI(), "******");
//        }
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
    
    /**
     * 验证码是否正确
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/isCaptcha")
    @ResponseBody
    public JSONObject isCaptchaRight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();

        String captcha = request.getParameter("captcha");
        String sessionCaptcha = new KaptchaExtend().getGeneratedKey(request);
        if (StringUtils.isBlank(sessionCaptcha)) {
//            model.addAttribute("error", "验证码已过期,请重新输入.");
//            return "login";
            jsonObject.put("error","验证码已过期, 请刷新后重新输入.");
        } else if (!captcha.toLowerCase().equals(sessionCaptcha.toLowerCase())) {
            jsonObject.put("error","验证码错误, 请重新输入或刷新验证码.");
        } else {
            jsonObject.put("ok","验证码正确.");
        }
        return jsonObject;
    }

    /**
     * 是否登录
     *
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public JSONObject isLogin() {
        JSONObject object = new JSONObject();
        object.put("isLogin", ShiroUtils.isLogin());
        return object;
    }
}
