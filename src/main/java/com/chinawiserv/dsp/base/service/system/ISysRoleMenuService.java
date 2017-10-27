package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.base.entity.po.system.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务类1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
	
	/**
	 * 角色授权
	 */
	void addAuth(String roleId, String[] menuIds);
	
	/**
	 * 获取指定角色的权限
	 */
	List<SysRoleMenu> selectByRole(String roleId);


}
