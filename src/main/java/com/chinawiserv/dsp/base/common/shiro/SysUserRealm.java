package com.chinawiserv.dsp.base.common.shiro;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.entity.po.system.SysMenu;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysMenuService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;

/**
 * 认证
 */
public class SysUserRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysMenuService sysMenuService;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        SysUserVo user = (SysUserVo)principals.getPrimaryPrincipal();
		String userId = user.getId();

		List<String> permsList;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//系统管理员，拥有最高权限
		//todo xxx
        try {
            if("1".equals(userId)){
                List<SysMenu> menuList = sysMenuService.selectList(new EntityWrapper<SysMenu>());
                permsList = new ArrayList<>(menuList.size());
                for(SysMenu menu : menuList){
                    permsList.add(menu.getResourceName());
                }
            } else{
                permsList = sysMenuService.selectMenuIdsByuserId(userId);
            }
            //用户权限列表
            Set<String> permsSet = new HashSet<String>();
            for(String perms : permsList){
                if(StringUtils.isBlank(perms)){
                    continue;
                }
                permsSet.addAll(Arrays.asList(perms.trim().split(",")));
            }

            info.setStringPermissions(permsSet);
        }catch (Exception e){
            e.printStackTrace();
        }
		return info;
	}

    @Override
    protected boolean isPermitted(Permission permission, AuthorizationInfo info) {
        Collection<Permission> perms = getPermissions(info);
        if (perms != null && !perms.isEmpty()) {
            for (Permission perm : perms) {
                if (perm.equals(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询用户信息
        SysUserVo user =  sysUserService.selectVoByUserName(userName);
//		SysUser user =  sysUserService.selectOne(new EntityWrapper<SysUser>().eq("user_name", userName));
//		SysUser user = sysUserService.queryByUserName(username);
        
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        
        //账号禁用
        if(user.getStatus() == 0){
        	throw new LockedAccountException("账号已被禁用,请联系管理员");
        }
        //非超级管理员或区域管理员角色的用户，如果没有分配部门，不让登录
        int minRole = user.getMinRoleLevel();
        if(minRole > 0){
            String deptId = user.getDeptId();
            if(StringUtils.isEmpty(deptId)){
                throw new IncorrectCredentialsException("当前登录用户未被分配部门，请联系管理员！");
            }
        }
        //TODO
        if(StringUtils.isBlank(user.getRegionCode())){
            throw new IncorrectCredentialsException("当前登录用户未被分配区域，请联系管理员！");
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
	}

}
