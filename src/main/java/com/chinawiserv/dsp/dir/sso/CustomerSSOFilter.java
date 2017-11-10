package com.chinawiserv.dsp.dir.sso;

import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.util.ApplicationContextUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.base.mapper.system.SysProductIntegrateMapper;
import com.chinawiserv.dsp.base.service.system.ISysMenuService;
import com.chinawiserv.dsp.base.service.system.ISysProductIntegrateService;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.free.oss.filter.SSOFilter;
import com.free.oss.utils.Props;
import com.free.oss.utils.RegExp;
import com.free.oss.utils.Tokens;
import com.google.common.base.Strings;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerSSOFilter extends SSOFilter {

    private static final String profile = "sso-config.properties";
    private static final Long TIME_OUT = 3600000L;

    @Autowired
    private ISysProductIntegrateService sysProductIntegrateService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = ApplicationContextUtil.getContext();
        sysProductIntegrateService =context.getBean(ISysProductIntegrateService.class);
    }

    public CustomerSSOFilter() {
    }

    /**
     * 获取当前系统登录的账号
     */

    @Override
    public String curAcc(HttpSession session) {
        SysUser currentLoginUser = ShiroUtils.getLoginUser();
        if (null != currentLoginUser) {
            return currentLoginUser.getUserName();
        }
        return "";
    }

    /**
     * 设置当前系统登录的账号
     */
    @Override
    public void setAcc(HttpSession session, String account) {
        try {
            ISysUserService iSysUserService = ContextLoader.getCurrentWebApplicationContext().getBean(ISysUserService.class);
            Map<String, Object> paramMap = new HashMap<>();
            SysUserVo sysUserVo = iSysUserService.selectVoByUserName(account);
            if (null != sysUserVo) {
                Subject subject = ShiroUtils.getSubject();
                //sha256加密
                paramMap.put("userName", account);
                paramMap.put("password", sysUserVo.getPassword());
                UsernamePasswordToken token = new UsernamePasswordToken(account, sysUserVo.getPassword());
                subject.login(token);
                loginSuccess(paramMap);
            }else{

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登出
     */
    @Override
    public void logOut(HttpSession session) {
        ShiroUtils.logout();
    }

    public void loginSuccess(Map<String, Object> paramMap) {
        ISysSettingService sysSettingService = ContextLoader.getCurrentWebApplicationContext().getBean(ISysSettingService.class);
        ISysMenuService sysMenuService = ContextLoader.getCurrentWebApplicationContext().getBean(ISysMenuService.class);
        SysUser currentLoginUser = ShiroUtils.getLoginUser();
        try {
            /**
             * 加载全局非登录访问常量
             */
            List<SysSetting> list = sysSettingService.selectList(null);
            for (SysSetting setting : list) {
                ShiroUtils.setSessionAttribute(setting.getSettingCode(), setting.getSettingValue());
            }

            /**
             * 保存登录信息
             */
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
            List<String> list2 = null;
            list2 = sysMenuService.selectMenuIdsByuserId(currentLoginUser.getId());
            String[] permissions = list2.toArray(new String[list2.size()]);
            ShiroUtils.setSessionAttribute(SystemConst.PERMISSIONS, permissions);
            //获取当前用户的区域编码
            ShiroUtils.setSessionAttribute(SystemConst.REGION, currentLoginUser.getRegionCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //数据库代替配置文件
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        /**
         * 不使用浏览器缓存，预防多次访问读取不到参数
         */
        resp.setDateHeader("Expires", -1);              //告诉浏览器数据可以缓存多长时间，-1或0表示不缓存
        resp.setHeader("Cache_Control", "no-cache");    //支持HTTP 1.1，告诉浏览器要不要缓存数据，如“no-cache”
        resp.setHeader("Pragma", "no-cache");           //支持HTTP 1.0，告诉浏览器要不要缓存数据，如“no-cache”

        Props pros = Props.of(profile);
        String requestURL = req.getRequestURL().toString();
        String requestURI = req.getQueryString();
        String url = requestURL + "?" + requestURI;

        String scode = pros.get("secret_code").stringValue();
        long timeOut = pros.get("time_out").longValue(TIME_OUT);

        HttpSession session = req.getSession(true);

        Map<String, String> params = urlParams(URLDecoder.decode(Strings.nullToEmpty(requestURI), "UTF-8"));

        String s_t = params.get("s_t");
        if(!Strings.isNullOrEmpty(s_t)){//带有token 参数，进行解析
            System.out.println("【带有参数】:"+ s_t);
            Tokens tk = Tokens.of(s_t);
            System.out.println("【带有参数】:timeOut:"+ tk.timeout(timeOut)+ "   legal: "+tk.legal(scode));
            if(!tk.legal(scode) || tk.timeout(timeOut)){
                System.out.println("【带有参数】----登出");
                this.logOut(session);
            }else{//合法
                if(tk.getAccount() != null){
                    if(!tk.getAccount().equals(this.curAcc(session))){//当前登录账号不相等
                        this.logOut(session);
                        this.setAcc(session, tk.getAccount());
                    }else{//登录账号相等  ignore
                    }
                }else{//登录账号为空
                    this.logOut(session);
                }
            }

            boolean showToken = pros.get("show_url_token").boolValue();
            if(!showToken){
                String rto = requestURL+"?";
                for (String itm : params.keySet()) {
                    if(!"s_t".equals(itm)){
                        rto += itm+"=" + URLEncoder.encode(Strings.nullToEmpty(params.get(itm)), "UTF-8")+"&";
                    }
                }
                if(rto.endsWith("&")){
                    rto = rto.substring(0, rto.length()-1);
                }
                if(rto.endsWith("?")){
                    rto = rto.substring(0, rto.length() -1);
                }
                resp.sendRedirect(rto);
                return;
            }
        }

        if(RegExp.match(".{0,}(jp:){1}.{1,}", url)){//跳转到其他系统
            String arr[] = requestURL.split("jp:");
            String uri = arr.length > 1?arr[1]:"";
            uri = RegExp.match("^/.{0,}", uri)?uri.substring(1):uri;

            String[] hes = uri.split("/");
            String toHost_key = hes.length>0?hes[0]:"";
//            String host = !Strings.isNullOrEmpty(toHost_key) && RegExp.match("^(hk_).{0,}", toHost_key) ?pros.get("jump_"+toHost_key.replace("hk_", "")).stringValue():pros.get("jump_host").stringValue();
            String host =null;
            if(!Strings.isNullOrEmpty(toHost_key) && RegExp.match("^(hk_).{0,}", toHost_key)){
                String id = toHost_key.replace("hk_", "");
                try {
                    SysProductIntegrateVo vo = sysProductIntegrateService.selectVoById(id);
                    host=vo.getSsoPath();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                return;
            }
            uri = uri.replace(toHost_key, "");

            //检查是否登录
            String curAcc = this.curAcc(session);
            String jurl = host
                    +(Strings.isNullOrEmpty(uri)?"":(RegExp.match("^/.{0,}$", uri)?uri:("/"+uri) ))
                    +(Strings.isNullOrEmpty(requestURI)?("?"+"timestamp="+System.currentTimeMillis()):("?"+requestURI+"&timestamp="+System.currentTimeMillis()))
                    ;
            if(!Strings.isNullOrEmpty(curAcc)){//不等于空，封装参数
                String token = Tokens.toToken(curAcc, pros.get("secret_code").stringValue());
                token = URLEncoder.encode(token, "UTF-8");
                jurl += ("&s_t="+token);
            }
            resp.sendRedirect(jurl);
            return;
        }else{
            chain.doFilter(request, response);
        }

    }
}
