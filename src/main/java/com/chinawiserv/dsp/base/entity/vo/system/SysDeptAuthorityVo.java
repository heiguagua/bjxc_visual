package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;

/**
 * <p>
 * 部门数据权限分配表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public class SysDeptAuthorityVo extends SysDeptAuthority{

    private String deptIds;

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }
}
