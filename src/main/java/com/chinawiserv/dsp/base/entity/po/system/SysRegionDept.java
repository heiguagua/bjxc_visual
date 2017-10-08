package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政部门表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
@TableName("sys_region_dept")
public class SysRegionDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private String id;
    /**
     * 行政部门编号
     */
	@TableField("region_dept_code")
	private String regionDeptCode;
    /**
     * 行政部门名称
     */
	@TableField("region_dept_name")
	private String regionDeptName;
    /**
     * 上级行政部门编号
     */
	private String fcode;
    /**
     * 上级行政部门名称
     */
	private String fname;
    /**
     * 行政部门级别
     */
	@TableField("region_dept_level")
	private Integer regionDeptLevel;
    /**
     * 显示树编码
     */
	@TableField("structure_code")
	private String structureCode;
    /**
     * 显示树名称
     */
	@TableField("structure_name")
	private String structureName;
    /**
     * 状态
     */
	private String status;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegionDeptCode() {
		return regionDeptCode;
	}

	public void setRegionDeptCode(String regionDeptCode) {
		this.regionDeptCode = regionDeptCode;
	}

	public String getRegionDeptName() {
		return regionDeptName;
	}

	public void setRegionDeptName(String regionDeptName) {
		this.regionDeptName = regionDeptName;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Integer getRegionDeptLevel() {
		return regionDeptLevel;
	}

	public void setRegionDeptLevel(Integer regionDeptLevel) {
		this.regionDeptLevel = regionDeptLevel;
	}

	public String getStructureCode() {
		return structureCode;
	}

	public void setStructureCode(String structureCode) {
		this.structureCode = structureCode;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
