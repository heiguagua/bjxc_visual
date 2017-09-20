package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.entity.po.system.SysDept;

/**
 * Created by lenovo on 2017/5/15.
 */
public class SysDeptVo extends SysDept {

    private Boolean isLeaf;

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
