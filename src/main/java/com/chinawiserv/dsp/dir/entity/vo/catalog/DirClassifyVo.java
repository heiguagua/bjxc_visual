package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;

/**
 * <p>
 * 目录分类表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirClassifyVo extends DirClassify{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hasLeaf;
	private String DeptId;
    
    
    
    public String getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(String hasLeaf) {
        this.hasLeaf = hasLeaf;
    }

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}


}
