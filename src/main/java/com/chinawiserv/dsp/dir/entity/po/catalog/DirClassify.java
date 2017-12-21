package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * <p>
 * 目录分类表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_classify")
public class DirClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;

    @TableField("region_code")
    private String regionCode;
    /**
     * 【国】分类编号
     */
	@TableField("classify_code")
	private String classifyCode;
    /**
     * 【国】分类名称
     */	
	@TableField("classify_name")
	private String classifyName;
	
	@TableField("tree_code")
	private String treeCode;
    /**
     * 分类描述
     */
	@TableField("classify_desc")
	private String classifyDesc;
    /**
     * 上级分类编号
     */
	@TableField("fid")
	private String fid;
    /**
     * 上级分类名称
     */
	@TableField("fname")
	private String fname;
    /**
     * 级别
     */
	@TableField("classify_level")
	private Integer classifyLevel;
    /**
     * 目录类别索引
     */
	@TableField("classify_index")
	private Integer classifyIndex;
    /**
     * 信息资源索引
     */
	@TableField("dcm_index")
	private Integer dcmIndex;
    /**
     * 显示顺序
     */
	@TableField("order_number")
	private Integer orderNumber;
    /**
     * 状态
     */
	@TableField("status")
	private String status;
    /**
     * 创建人
     */
	@TableField("create_user_id")
	private String createUserId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_user_id")
	private String updateUserId;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 逻辑删除标识
     */
	@TableField("delete_flag")
	private Integer deleteFlag;

	@TableField("classify_structure_code")
	private String classifyStructureCode;

	@TableField("classify_structure_name")
	private String classifyStructureName;


	@TableField("icon")
	private String icon;
	
	@TableField("classify_type")
	private String classifyType;
	
	@TableField("national_code")
	private String nationalCode;
	
	@TableField("lead_dept_id")
	private String leadDeptId;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getClassifyDesc() {
		return classifyDesc;
	}

	public void setClassifyDesc(String classifyDesc) {
		this.classifyDesc = classifyDesc;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Integer getClassifyLevel() {
		return classifyLevel;
	}

	public void setClassifyLevel(Integer classifyLevel) {
		this.classifyLevel = classifyLevel;
	}

	public Integer getClassifyIndex() {
		return classifyIndex;
	}

	public void setClassifyIndex(Integer classifyIndex) {
		this.classifyIndex = classifyIndex;
	}

	public Integer getDcmIndex() {
		return dcmIndex;
	}

	public void setDcmIndex(Integer dcmIndex) {
		this.dcmIndex = dcmIndex;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getClassifyStructureCode() {
		return classifyStructureCode;
	}

	public void setClassifyStructureCode(String classifyStructureCode) {
		this.classifyStructureCode = classifyStructureCode;
	}

	public String getClassifyStructureName() {
		return classifyStructureName;
	}

	public void setClassifyStructureName(String classifyStructureName) {
		this.classifyStructureName = classifyStructureName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getClassifyType() {
		return classifyType;
	}

	public void setClassifyType(String classifyType) {
		this.classifyType = classifyType;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public String getLeadDeptId() {
		return leadDeptId;
	}

	public void setLeadDeptId(String leadDeptId) {
		this.leadDeptId = leadDeptId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DirClassify that = (DirClassify) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(regionCode, that.regionCode)
				.append(classifyCode, that.classifyCode)
				.append(classifyName, that.classifyName)
				.append(treeCode, that.treeCode)
				.append(classifyDesc, that.classifyDesc)
				.append(fid, that.fid)
				.append(fname, that.fname)
				.append(classifyLevel, that.classifyLevel)
				.append(classifyIndex, that.classifyIndex)
				.append(dcmIndex, that.dcmIndex)
				.append(orderNumber, that.orderNumber)
				.append(status, that.status)
				.append(createUserId, that.createUserId)
				.append(createTime, that.createTime)
				.append(updateUserId, that.updateUserId)
				.append(updateTime, that.updateTime)
				.append(deleteFlag, that.deleteFlag)
				.append(classifyStructureCode, that.classifyStructureCode)
				.append(classifyStructureName, that.classifyStructureName)
				.append(icon, that.icon)
				.append(classifyType, that.classifyType)
				.append(nationalCode, that.nationalCode)
				.append(leadDeptId, that.leadDeptId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(regionCode)
				.append(classifyCode)
				.append(classifyName)
				.append(treeCode)
				.append(classifyDesc)
				.append(fid)
				.append(fname)
				.append(classifyLevel)
				.append(classifyIndex)
				.append(dcmIndex)
				.append(orderNumber)
				.append(status)
				.append(createUserId)
				.append(createTime)
				.append(updateUserId)
				.append(updateTime)
				.append(deleteFlag)
				.append(classifyStructureCode)
				.append(classifyStructureName)
				.append(icon)
				.append(classifyType)
				.append(nationalCode)
				.append(leadDeptId)
				.toHashCode();
	}
}
