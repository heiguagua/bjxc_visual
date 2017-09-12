package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;

import java.util.List;

/**
 * <p>
  * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	List<String> selectPermissionByUid(String uid);

	String[] selectRoleIdsByUserId(String userId);

}