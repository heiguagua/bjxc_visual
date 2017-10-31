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
/**
 * @author admin
 *
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
    private String classifyTypeName;
    private String nationalClassifyName;
    private String isLocal;
    private String authorityNode;
    private String leadDeptName;
    
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

	public String getClassifyTypeName() {
		return classifyTypeName;
	}

	public void setClassifyTypeName(String classifyTypeName) {
		this.classifyTypeName = classifyTypeName;
	}

	public String getNationalClassifyName() {
		return nationalClassifyName;
	}

	public void setNationalClassifyName(String nationalClassifyName) {
		this.nationalClassifyName = nationalClassifyName;
	}

	public String getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}

    public String getAuthorityNode() {
        return authorityNode;
    }

    public void setAuthorityNode(String authorityNode) {
        this.authorityNode = authorityNode;
    }

	public String getLeadDeptName() {
		return leadDeptName;
	}

	public void setLeadDeptName(String leadDeptName) {
		this.leadDeptName = leadDeptName;
	}
    
    

//	public static void main(String[] args) {
//		
//		DirClassifyVo vo = new DirClassifyVo();
//		System.out.println(vo);
//	}

}
