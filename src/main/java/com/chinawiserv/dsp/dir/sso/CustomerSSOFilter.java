package com.chinawiserv.dsp.dir.sso;

import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.entity.vo.system.TreeMenu;
import com.chinawiserv.dsp.base.service.system.ISysMenuService;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.free.oss.filter.SSOFilter;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerSSOFilter extends SSOFilter {

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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
