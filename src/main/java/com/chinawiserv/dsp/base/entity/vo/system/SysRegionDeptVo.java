package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysRegionDept;

/**
 * <p>
 * 行政部门表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
public class SysRegionDeptVo extends SysRegionDept{

    private String hasLeaf;

    public String getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(String hasLeaf) {
        this.hasLeaf = hasLeaf;
    }
}
