package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 信息资源（数据集） Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
@TableName("drap_dataset")
public class DrapDataset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 所属行政区划
     */
	@TableField("region_code")
	private String regionCode;
    /**
     * 【国】信息资源提供方类型
     */
	@TableField("belong_dept_type")
	private String belongDeptType;
    /**
     * 【国】信息资源提供方ID
     */
	@TableField("belong_dept_id")
	private String belongDeptId;
    /**
     * 添加类型
     */
	@TableField("source_type")
	private String sourceType;
    /**
     * 业务产生材料id
     */
	@TableField("doc_id")
	private String docId;
    /**
     * 所属业务
     */
	@TableField("belong_activity_id")
	private String belongActivityId;
    /**
     * 所属系统
     */
	@TableField("belong_system_id")
	private String belongSystemId;
    /**
     * 数据集编号
     */
	@TableField("dataset_code")
	private String datasetCode;
    /**
     * 【国】信息资源名称
     */
	@TableField("dataset_name")
	private String datasetName;
    /**
     * 业务数据类型
     */
	private String category;
    /**
     * 敏感标识
     */
	@TableField("sensitive_remark")
	private String sensitiveRemark;
    /**
     * 【国】信息资源更新周期
     */
	@TableField("update_frequency")
	private String updateFrequency;
    /**
     * 【国】信息资源摘要
     */
	@TableField("dataset_desc")
	private String datasetDesc;
    /**
     * 【国】信息资源共享类型
     */
	@TableField("share_type")
	private String shareType;
    /**
     * 【国】信息资源共享条件
     */
	@TableField("share_condition_desc")
	private String shareConditionDesc;
    /**
     * 【国】信息资源共享方式分类
     */
	@TableField("share_method_category")
	private String shareMethodCategory;
    /**
     * 【国】信息资源共享方式类型
     */
	@TableField("share_method")
	private String shareMethod;
    /**
     * 共享方式说明
     */
	@TableField("share_method_desc")
	private String shareMethodDesc;
    /**
     * 共享范围
     */
	@TableField("share_range")
	private String shareRange;
    /**
     * 不予共享依据
     */
	@TableField("no_share_reason")
	private String noShareReason;
    /**
     * 【国】信息资源是否社会开放
     */
	@TableField("is_open")
	private String isOpen;
    /**
     * 【国】信息资源开放条件
     */
	@TableField("open_condition")
	private String openCondition;
    /**
     * 【国】信息资源关联资源分类
     */
	@TableField("rel_dataset_code")
	private String relDatasetCode;
    /**
     * 【川】信息资源最小分级单元
     */
	@TableField("data_level")
	private String dataLevel;
    /**
     * 【川】信息资源指标体系
     */
	@TableField("data_index_system")
	private String dataIndexSystem;
    /**
     * 【川】信息资源涉密性
     */
	@TableField("is_secret")
	private String isSecret;
    /**
     * 基础目录
     */
	@TableField("basic_classify")
	private String basicClassify;
    /**
     * 主题目录
     */
	@TableField("subject_classify")
	private String subjectClassify;
    /**
     * 存储介质
     */
	@TableField("store_media")
	private String storeMedia;
    /**
     * 物理存储位置
     */
	@TableField("physics_store_location")
	private String physicsStoreLocation;
    /**
     * 扩展编码
     */
	@TableField("extend_code")
	private String extendCode;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;
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

	 /**
     * 审核人
     */
	@TableField("audito")
	private String audito;
	
	 /**
     * 审核时间
     */
	@TableField("audit_time")
	private Date auditTime;
	
	 /**
     * 审核意见
     */
	@TableField("audit_opinion")
	private String auditOpinion;


	public String getAudito() {
		return audito;
	}

	public void setAudito(String audito) {
		this.audito = audito;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
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

	public String getBelongDeptType() {
		return belongDeptType;
	}

	public void setBelongDeptType(String belongDeptType) {
		this.belongDeptType = belongDeptType;
	}

	public String getBelongDeptId() {
		return belongDeptId;
	}

	public void setBelongDeptId(String belongDeptId) {
		this.belongDeptId = belongDeptId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getBelongActivityId() {
		return belongActivityId;
	}

	public void setBelongActivityId(String belongActivityId) {
		this.belongActivityId = belongActivityId;
	}

	public String getBelongSystemId() {
		return belongSystemId;
	}

	public void setBelongSystemId(String belongSystemId) {
		this.belongSystemId = belongSystemId;
	}

	public String getDatasetCode() {
		return datasetCode;
	}

	public void setDatasetCode(String datasetCode) {
		this.datasetCode = datasetCode;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSensitiveRemark() {
		return sensitiveRemark;
	}

	public void setSensitiveRemark(String sensitiveRemark) {
		this.sensitiveRemark = sensitiveRemark;
	}

	public String getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public String getDatasetDesc() {
		return datasetDesc;
	}

	public void setDatasetDesc(String datasetDesc) {
		this.datasetDesc = datasetDesc;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getShareConditionDesc() {
		return shareConditionDesc;
	}

	public void setShareConditionDesc(String shareConditionDesc) {
		this.shareConditionDesc = shareConditionDesc;
	}

	public String getShareMethodCategory() {
		return shareMethodCategory;
	}

	public void setShareMethodCategory(String shareMethodCategory) {
		this.shareMethodCategory = shareMethodCategory;
	}

	public String getShareMethod() {
		return shareMethod;
	}

	public void setShareMethod(String shareMethod) {
		this.shareMethod = shareMethod;
	}

	public String getShareMethodDesc() {
		return shareMethodDesc;
	}

	public void setShareMethodDesc(String shareMethodDesc) {
		this.shareMethodDesc = shareMethodDesc;
	}

	public String getShareRange() {
		return shareRange;
	}

	public void setShareRange(String shareRange) {
		this.shareRange = shareRange;
	}

	public String getNoShareReason() {
		return noShareReason;
	}

	public void setNoShareReason(String noShareReason) {
		this.noShareReason = noShareReason;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getOpenCondition() {
		return openCondition;
	}

	public void setOpenCondition(String openCondition) {
		this.openCondition = openCondition;
	}

	public String getRelDatasetCode() {
		return relDatasetCode;
	}

	public void setRelDatasetCode(String relDatasetCode) {
		this.relDatasetCode = relDatasetCode;
	}

	public String getDataLevel() {
		return dataLevel;
	}

	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}

	public String getDataIndexSystem() {
		return dataIndexSystem;
	}

	public void setDataIndexSystem(String dataIndexSystem) {
		this.dataIndexSystem = dataIndexSystem;
	}

	public String getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(String isSecret) {
		this.isSecret = isSecret;
	}

	public String getBasicClassify() {
		return basicClassify;
	}

	public void setBasicClassify(String basicClassify) {
		this.basicClassify = basicClassify;
	}

	public String getSubjectClassify() {
		return subjectClassify;
	}

	public void setSubjectClassify(String subjectClassify) {
		this.subjectClassify = subjectClassify;
	}

	public String getStoreMedia() {
		return storeMedia;
	}

	public void setStoreMedia(String storeMedia) {
		this.storeMedia = storeMedia;
	}

	public String getPhysicsStoreLocation() {
		return physicsStoreLocation;
	}

	public void setPhysicsStoreLocation(String physicsStoreLocation) {
		this.physicsStoreLocation = physicsStoreLocation;
	}

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
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
