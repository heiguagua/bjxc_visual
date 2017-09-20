package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集对应数据项表【国】 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-20
 */
@TableName("dir_dataitem")
public class DirDataitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 数据集ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 数据项编号
     */
	@TableField("item_code")
	private String itemCode;
    /**
     * 【国】数据项名称
     */
	@TableField("item_name")
	private String itemName;
    /**
     * 数据项描述
     */
	@TableField("item_desc")
	private String itemDesc;
    /**
     * 【国】数据项类型
     */
	@TableField("item_type")
	private String itemType;
    /**
     * 【国】数据长度
     */
	@TableField("item_length")
	private Integer itemLength;
    /**
     * 责任部门
     */
	@TableField("belong_dept_id")
	private String belongDeptId;
    /**
     * 共享类型
     */
	@TableField("share_type")
	private String shareType;
    /**
     * 共享方式
     */
	@TableField("share_method")
	private String shareMethod;
    /**
     * 共享条件
     */
	@TableField("share_condition")
	private String shareCondition;
    /**
     * 不予共享说明
     */
	@TableField("no_share_explain")
	private String noShareExplain;
    /**
     * 是否开放
     */
	@TableField("is_open")
	private String isOpen;
    /**
     * 开放条件
     */
	@TableField("open_condition")
	private String openCondition;
    /**
     * 更新周期
     */
	@TableField("update_frequency")
	private String updateFrequency;
    /**
     * 存储介质
     */
	@TableField("storage_medium")
	private String storageMedium;
    /**
     * 存储位置
     */
	@TableField("storage_location")
	private String storageLocation;
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

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getItemLength() {
		return itemLength;
	}

	public void setItemLength(Integer itemLength) {
		this.itemLength = itemLength;
	}

	public String getBelongDeptId() {
		return belongDeptId;
	}

	public void setBelongDeptId(String belongDeptId) {
		this.belongDeptId = belongDeptId;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getShareMethod() {
		return shareMethod;
	}

	public void setShareMethod(String shareMethod) {
		this.shareMethod = shareMethod;
	}

	public String getShareCondition() {
		return shareCondition;
	}

	public void setShareCondition(String shareCondition) {
		this.shareCondition = shareCondition;
	}

	public String getNoShareExplain() {
		return noShareExplain;
	}

	public void setNoShareExplain(String noShareExplain) {
		this.noShareExplain = noShareExplain;
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
