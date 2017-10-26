package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统组织机构表
 * </p>
 *
 * @author zhanf
 * @since 2017-05-09
 */
@TableName("sys_dept")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;

	private String regionCode;

	private String deptType;

	private String deptCode;

	private String deptName;

	private String deptShortName;

	private String deptAlias;

	private String deptListingName;

	private String deptDesc;

	private String functionKeyword;

	private String deptFunction;

	private String fid;

	private String fname;

	private Integer deptLevel;

	private String deptResponseMan;

	private String deptResponsePhone;

	private String deptResponseEmail;

	private String deptContactMan;

	private String deptContactDept;

	private String deptContactPost;

	private String deptContactPhone;

	private String deptContactFixedPhone;

	private String deptContactEmail;

	private String deptAddress;

	private String orgLongitude;

	private String orgLatitude;

	private String icon;

	private Integer orderNumber;

	private Date validateFrom;

	private Date validateTo;

	private Integer status;

	private String createUserId;

	private Date createTime;

	private String updateUserId;

	private Date updateTime;

	private Integer deleteFlag;

	private Integer treeIndex;

	private String treeCode;

	private String deptStructureName;

	public String getDeptStructureName() {
		return deptStructureName;
	}

	public void setDeptStructureName(String deptStructureName) {
		this.deptStructureName = deptStructureName;
	}

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

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptShortName() {
		return deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}

	public String getDeptAlias() {
		return deptAlias;
	}

	public void setDeptAlias(String deptAlias) {
		this.deptAlias = deptAlias;
	}

	public String getDeptListingName() {
		return deptListingName;
	}

	public void setDeptListingName(String deptListingName) {
		this.deptListingName = deptListingName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getFunctionKeyword() {
		return functionKeyword;
	}

	public void setFunctionKeyword(String functionKeyword) {
		this.functionKeyword = functionKeyword;
	}

	public String getDeptFunction() {
		return deptFunction;
	}

	public void setDeptFunction(String deptFunction) {
		this.deptFunction = deptFunction;
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

	public String getDeptResponseMan() {
		return deptResponseMan;
	}

	public void setDeptResponseMan(String deptResponseMan) {
		this.deptResponseMan = deptResponseMan;
	}

	public String getDeptResponsePhone() {
		return deptResponsePhone;
	}

	public void setDeptResponsePhone(String deptResponsePhone) {
		this.deptResponsePhone = deptResponsePhone;
	}

	public String getDeptResponseEmail() {
		return deptResponseEmail;
	}

	public void setDeptResponseEmail(String deptResponseEmail) {
		this.deptResponseEmail = deptResponseEmail;
	}

	public String getDeptContactMan() {
		return deptContactMan;
	}

	public void setDeptContactMan(String deptContactMan) {
		this.deptContactMan = deptContactMan;
	}

	public String getDeptContactDept() {
		return deptContactDept;
	}

	public void setDeptContactDept(String deptContactDept) {
		this.deptContactDept = deptContactDept;
	}

	public String getDeptContactPost() {
		return deptContactPost;
	}

	public void setDeptContactPost(String deptContactPost) {
		this.deptContactPost = deptContactPost;
	}

	public String getDeptContactPhone() {
		return deptContactPhone;
	}

	public void setDeptContactPhone(String deptContactPhone) {
		this.deptContactPhone = deptContactPhone;
	}

	public String getDeptContactFixedPhone() {
		return deptContactFixedPhone;
	}

	public void setDeptContactFixedPhone(String deptContactFixedPhone) {
		this.deptContactFixedPhone = deptContactFixedPhone;
	}

	public String getDeptContactEmail() {
		return deptContactEmail;
	}

	public void setDeptContactEmail(String deptContactEmail) {
		this.deptContactEmail = deptContactEmail;
	}

	public String getDeptAddress() {
		return deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public String getOrgLongitude() {
		return orgLongitude;
	}

	public void setOrgLongitude(String orgLongitude) {
		this.orgLongitude = orgLongitude;
	}

	public String getOrgLatitude() {
		return orgLatitude;
	}

	public void setOrgLatitude(String orgLatitude) {
		this.orgLatitude = orgLatitude;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getValidateFrom() {
		return validateFrom;
	}

	public void setValidateFrom(Date validateFrom) {
		this.validateFrom = validateFrom;
	}

	public Date getValidateTo() {
		return validateTo;
	}

	public void setValidateTo(Date validateTo) {
		this.validateTo = validateTo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getTreeIndex() {
		return treeIndex;
	}

	public void setTreeIndex(Integer treeIndex) {
		this.treeIndex = treeIndex;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public Integer getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}
}
