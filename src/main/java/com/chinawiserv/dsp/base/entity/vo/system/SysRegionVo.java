package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysRegion;

/**
 * <p>
 * 行政区域表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
public class SysRegionVo extends SysRegion{

    private Integer regionLevel;

    private String hasLeaf;

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }


    public String getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(String hasLeaf) {
        this.hasLeaf = hasLeaf;
    }
}
