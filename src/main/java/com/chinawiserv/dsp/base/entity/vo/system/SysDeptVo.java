package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.entity.po.system.SysDept;

import java.util.List;

/**
 * Created by lenovo on 2017/5/15.
 */
public class SysDeptVo extends SysDept {

    private Boolean isLeaf;

    private List<SysDeptVo> childs;

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public List<SysDeptVo> getChilds() {
        return childs;
    }

    public void setChilds(List<SysDeptVo> childs) {
        this.childs = childs;
    }
}
