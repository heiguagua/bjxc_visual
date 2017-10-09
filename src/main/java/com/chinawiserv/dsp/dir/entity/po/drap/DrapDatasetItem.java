package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业务数据项【国】 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_dataset_item")
public class DrapDatasetItem implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String id;
	/**
	 * 数据项编码
	 */
	@TableField("item_code")
	private String itemCode;
	/**
	 * 【国】数据项名称
	 */
	@TableField("item_name")
	private String itemName;
	/**
	 * 【国】数据项类型
	 */
	@TableField("item_type")
	private String itemType;
	/**
	 * 【国】数据项长度
	 */
	@TableField("item_length")
	private Integer itemLength;
	/**
	 * 数据项描述
	 */
	@TableField("item_desc")
	private String itemDesc;
	/**
	 * 所属组织
	 */
	@TableField("belong_dept")
	private String belongDept;
	/**
	 * 敏感标识
	 */
	@TableField("sensitive_remark")
	private String sensitiveRemark;
	/**
	 * 【国】更新频率
	 */
	@TableField("update_frequency")
	private String updateFrequency;
	/**
	 * 【国】共享类型
	 */
	@TableField("share_type")
	private String shareType;
	/**
	 * 【国】共享条件
	 */
	@TableField("share_condition_desc")
	private String shareConditionDesc;
	/**
	 * 不予共享依据
	 */
	@TableField("no_share_reason")
	private String noShareReason;
	/**
	 * 共享范围
	 */
	@TableField("share_range")
	private String shareRange;
	/**
	 * 【国】共享方式分类
	 */
	@TableField("share_method_category")
	private String shareMethodCategory;
	/**
	 * 【国】共享方式类型
	 */
	@TableField("share_method")
	private String shareMethod;
	/**
	 * 共享方式说明
	 */
	@TableField("share_method_desc")
	private String shareMethodDesc;
	/**
	 * 【国】是否开放
	 */
	@TableField("is_open")
	private String isOpen;
	/**
	 * 【国】开放条件
	 */
	@TableField("open_condition")
	private String openCondition;
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
	 * 资源格式分类
	 */
	@TableField("format_category")
	private String formatCategory;
	/**
	 * 资源格式类型
	 */
	@TableField("format_type")
	private String formatType;
	/**
	 * 资源格式说明
	 */
	@TableField("format_info")
	private String formatInfo;
	/**
	 * 编码序号
	 */
	@TableField("code_index")
	private Integer codeIndex;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getBelongDept() {
		return belongDept;
	}

	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
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

	public String getNoShareReason() {
		return noShareReason;
	}

	public void setNoShareReason(String noShareReason) {
		this.noShareReason = noShareReason;
	}

	public String getShareRange() {
		return shareRange;
	}

	public void setShareRange(String shareRange) {
		this.shareRange = shareRange;
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

	public String getFormatCategory() {
		return formatCategory;
	}

	public void setFormatCategory(String formatCategory) {
		this.formatCategory = formatCategory;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getFormatInfo() {
		return formatInfo;
	}

	public void setFormatInfo(String formatInfo) {
		this.formatInfo = formatInfo;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
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
