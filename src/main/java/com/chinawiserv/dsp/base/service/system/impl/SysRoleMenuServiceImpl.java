package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chinawiserv.dsp.base.entity.po.system.SysRoleMenu;
import com.chinawiserv.dsp.base.mapper.system.SysRoleMenuMapper;
import com.chinawiserv.dsp.base.service.system.ISysRoleMenuService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

	@Override
	public void addAuth(String roleId, String[] menuIds) {
		/**
		 * 删除原有权限
		 */
		this.delete(new EntityWrapper<SysRoleMenu>().eq("role_id",roleId));
		/**
		 * 重新授权
		 */
		if(ArrayUtils.isNotEmpty(menuIds)){
			for(String menuId : menuIds){
				SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
				sysRoleMenu2.setRoleId(roleId);
				sysRoleMenu2.setMenuId(menuId);
				this.insert(sysRoleMenu2);
			}
		}
	}

	@Override
	public List<SysRoleMenu> selectByRole(String roleId) {
		EntityWrapper<SysRoleMenu> ew = new EntityWrapper<SysRoleMenu>();
		ew.addFilter("role_id = {0}", roleId);
		return this.selectList(ew);
		
	}


}
