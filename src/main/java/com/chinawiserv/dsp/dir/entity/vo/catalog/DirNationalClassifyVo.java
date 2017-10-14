package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirNationalClassify;

/**
 * <p>
 * 目录分类表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirNationalClassifyVo extends DirNationalClassify{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hasLeaf;
	
    
    public String getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(String hasLeaf) {
        this.hasLeaf = hasLeaf;
    }


}
