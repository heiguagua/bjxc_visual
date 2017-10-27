package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.base.entity.po.system.SysRoleMenu;

import java.util.List;

/**
 * <p>
  * 角色菜单关联表 Mapper 接口1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 根据用户Id获取用户所在角色的权限
	 */
	public List<SysRoleMenu> selectRoleMenuByUserId(String uid);
	
}