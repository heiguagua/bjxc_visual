package com.chinawiserv.dsp.base.entity.po.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * <p>
 * 系统字典表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@TableName("sys_dict")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 行政区划编号
     */
	@TableField("region_code")
	private String regionCode;
    /**
     * 类型
     */
	@TableField("category")
	private String category;
    /**
     * 字典编码
     */
	@TableField("dict_code")
	private String dictCode;
    /**
     * 字典名称
     */
	@TableField("dict_name")
	private String dictName;
    /**
     * 字典描述
     */
	@TableField("dict_desc")
	private String dictDesc;
    /**
     * 上级字典编码
     */
	@TableField("parent_code")
	private String parentCode;
    /**
     * 显示顺序
     */
	@TableField("order_number")
	private Integer orderNumber;
	/**
	 * 图标
	 */
	@TableField("icon")
	private String icon;
	/**
	 * 字典级别
	 */
	@TableField("dict_level")
	private Integer dictLevel;
    /**
     * 状态
     */
	@TableField("status")
	private Integer status;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictDesc() {
		return dictDesc;
	}

	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getDictLevel() {
		return dictLevel;
	}

	public void setDictLevel(Integer dictLevel) {
		this.dictLevel = dictLevel;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		SysDict sysDict = (SysDict) o;

		return new EqualsBuilder()
				.append(id, sysDict.id)
				.append(regionCode, sysDict.regionCode)
				.append(category, sysDict.category)
				.append(dictCode, sysDict.dictCode)
				.append(dictName, sysDict.dictName)
				.append(dictDesc, sysDict.dictDesc)
				.append(parentCode, sysDict.parentCode)
				.append(orderNumber, sysDict.orderNumber)
				.append(icon, sysDict.icon)
				.append(dictLevel, sysDict.dictLevel)
				.append(status, sysDict.status)
				.append(createUserId, sysDict.createUserId)
				.append(createTime, sysDict.createTime)
				.append(updateUserId, sysDict.updateUserId)
				.append(updateTime, sysDict.updateTime)
				.append(deleteFlag, sysDict.deleteFlag)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(regionCode)
				.append(category)
				.append(dictCode)
				.append(dictName)
				.append(dictDesc)
				.append(parentCode)
				.append(orderNumber)
				.append(icon)
				.append(dictLevel)
				.append(status)
				.append(createUserId)
				.append(createTime)
				.append(updateUserId)
				.append(updateTime)
				.append(deleteFlag)
				.toHashCode();
	}
}
