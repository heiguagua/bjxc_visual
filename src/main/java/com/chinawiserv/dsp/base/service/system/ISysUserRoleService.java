package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.service.IService;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */

public interface ISysUserRoleService extends IService<SysUserRole> {

    void deleteBatchByUserId(List<String> ids);
	
}
