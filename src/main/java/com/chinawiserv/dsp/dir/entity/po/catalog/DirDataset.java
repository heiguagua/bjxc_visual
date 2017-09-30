package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集（信息资源） Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-29
 */
@TableName("dir_dataset")
public class DirDataset implements Serializable {

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
     * 数据集编码
     */
	@TableField("dataset_code")
	private String datasetCode;
    /**
     * 【国】信息资源名称
     */
	@TableField("dataset_name")
	private String datasetName;
    /**
     * 别名
     */
	private String alias;
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
	@TableField("share_condition")
	private String shareCondition;
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
     * 信息资源共享方式说明
     */
	@TableField("share_method_desc")
	private String shareMethodDesc;
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
     * 【国】信息资源更新周期
     */
	@TableField("update_frequency")
	private String updateFrequency;
    /**
     * 【国】信息资源关联资源代码
     */
	@TableField("rel_dataset_code")
	private String relDatasetCode;
    /**
     * 存储介质
     */
	@TableField("storage_medium")
	private String storageMedium;
    /**
     * 物理存储位置
     */
	@TableField("storage_location")
	private String storageLocation;
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
	@TableField("secret_flag")
	private String secretFlag;
    /**
     * 添加来源
     */
	@TableField("source_type")
	private String sourceType;
    /**
     * 状态
     */
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getShareCondition() {
		return shareCondition;
	}

	public void setShareCondition(String shareCondition) {
		this.shareCondition = shareCondition;
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

	public String getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public String getRelDatasetCode() {
		return relDatasetCode;
	}

	public void setRelDatasetCode(String relDatasetCode) {
		this.relDatasetCode = relDatasetCode;
	}

	public String getStorageMedium() {
		return storageMedium;
	}

	public void setStorageMedium(String storageMedium) {
		this.storageMedium = storageMedium;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
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

    public String getSecretFlag() {
        return secretFlag;
    }

    public void setSecretFlag(String secretFlag) {
        this.secretFlag = secretFlag;
    }

    public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
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

}
