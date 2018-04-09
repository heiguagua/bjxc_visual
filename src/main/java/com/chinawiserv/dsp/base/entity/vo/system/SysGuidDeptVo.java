package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysGuidDept;

/**
 * <p>
 * 业务指导部门记录表 Vo对象
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
public class SysGuidDeptVo extends SysGuidDept{

    private String deptIds;

    private String[] deptIdArray;

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
