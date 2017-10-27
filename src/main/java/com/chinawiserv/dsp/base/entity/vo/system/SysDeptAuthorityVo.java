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

    private String fid;

    private String deptName;

    private String deptIds;

    private String[] deptIdArray;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public String[] getDeptIdArray() {
        return deptIdArray;
    }

    public void setDeptIdArray(String[] deptIdArray) {
        this.deptIdArray = deptIdArray;
    }
}
