package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 需求资源信息表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_requirement_resources")
public class DrapRequirementResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 需求ID
     */
	@TableField("require_id")
	private String requireId;
    /**
     * 需求梳理数据来源(1业务需求梳理2应用需求梳理3门户需求梳理)
     */
	@TableField("require_combing_type")
	private Integer requireCombingType;
    /**
     * 业务产生材料id
     */
	@TableField("doc_id")
	private String docId;
    /**
     * 需求编号
     */
	@TableField("require_code")
	private String requireCode;
    /**
     * 需求资源名称
     */
	@TableField("require_name")
	private String requireName;
    /**
     * 需求资源描述
     */
	@TableField("requirement_desc")
	private String requirementDesc;
    /**
     * 支撑业务ID
     */
	@TableField("brace_activity_id")
	private String braceActivityId;
    /**
     * 是否已获取
     */
	@TableField("is_get")
	private String isGet;
    /**
     * 期望获取方式
     */
	@TableField("expect_get_type")
	private String expectGetType;
    /**
     * 需求来源方式（选择、填写）
     */
	@TableField("source_type")
	private String sourceType;
    /**
     * 需求类型(1.手动添加2.从信息资源添加3.从应用系统添加)
     */
	@TableField("require_type")
	private String requireType;
    /**
     * 需求资源备注
     */
	@TableField("require_remark")
	private String requireRemark;
    /**
     * 其他信息
     */
	@TableField("other_info")
	private String otherInfo;
    /**
     * 期望更新频率
     */
	@TableField("expect_update_frequence")
	private String expectUpdateFrequence;
    /**
     * 支撑应用
     */
	@TableField("brace_app")
	private String braceApp;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 创建人
     */
	@TableField("create_user")
	private String createUser;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_user")
	private String updateUser;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequireId() {
		return requireId;
	}

	public void setRequireId(String requireId) {
		this.requireId = requireId;
	}

	public Integer getRequireCombingType() {
		return requireCombingType;
	}

	public void setRequireCombingType(Integer requireCombingType) {
		this.requireCombingType = requireCombingType;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getRequireCode() {
		return requireCode;
	}

	public void setRequireCode(String requireCode) {
		this.requireCode = requireCode;
	}

	public String getRequireName() {
		return requireName;
	}

	public void setRequireName(String requireName) {
		this.requireName = requireName;
	}

	public String getRequirementDesc() {
		return requirementDesc;
	}

	public void setRequirementDesc(String requirementDesc) {
		this.requirementDesc = requirementDesc;
	}

	public String getBraceActivityId() {
		return braceActivityId;
	}

	public void setBraceActivityId(String braceActivityId) {
		this.braceActivityId = braceActivityId;
	}

	public String getIsGet() {
		return isGet;
	}

	public void setIsGet(String isGet) {
		this.isGet = isGet;
	}

	public String getExpectGetType() {
		return expectGetType;
	}

	public void setExpectGetType(String expectGetType) {
		this.expectGetType = expectGetType;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getRequireType() {
		return requireType;
	}

	public void setRequireType(String requireType) {
		this.requireType = requireType;
	}

	public String getRequireRemark() {
		return requireRemark;
	}

	public void setRequireRemark(String requireRemark) {
		this.requireRemark = requireRemark;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getExpectUpdateFrequence() {
		return expectUpdateFrequence;
	}

	public void setExpectUpdateFrequence(String expectUpdateFrequence) {
		this.expectUpdateFrequence = expectUpdateFrequence;
	}

	public String getBraceApp() {
		return braceApp;
	}

	public void setBraceApp(String braceApp) {
		this.braceApp = braceApp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

}
