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
	private String DeptName;
    private String iconName;
    
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

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}


}
