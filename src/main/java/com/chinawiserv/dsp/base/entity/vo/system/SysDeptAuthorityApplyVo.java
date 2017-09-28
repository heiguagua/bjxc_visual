package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;

/**
 * <p>
 * 数据权限申请表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public class SysDeptAuthorityApplyVo extends SysDeptAuthorityApply{

    private String regionCode;

    private String treeCode;

    private String toDeptIds;

    public String getToDeptIds() {
        return toDeptIds;
    }

    public void setToDeptIds(String toDeptIds) {
        this.toDeptIds = toDeptIds;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }
}
