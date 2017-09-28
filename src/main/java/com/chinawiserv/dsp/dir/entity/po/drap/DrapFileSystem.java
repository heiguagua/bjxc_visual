package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文件系统表(NO) Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_file_system")
public class DrapFileSystem implements Serializable {

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
     * 文件编码
     */
	@TableField("file_code")
	private String fileCode;
    /**
     * 文件名称
     */
	@TableField("file_name")
	private String fileName;
    /**
     * 文件描述
     */
	@TableField("file_desc")
	private String fileDesc;
    /**
     * 文件状态
     */
	private String status;
    /**
     * 启用时间
     */
	@TableField("enable_time")
	private Date enableTime;
    /**
     * 停用时间
     */
	@TableField("disable_time")
	private Date disableTime;
    /**
     * 文件提供部门
     */
	@TableField("provide_dept")
	private String provideDept;
    /**
     * 文件提供时间
     */
	@TableField("provide_date")
	private Date provideDate;
    /**
     * 文件提供人
     */
	private String provider;
    /**
     * 文件提供人电话
     */
	@TableField("provider_phone")
	private String providerPhone;
    /**
     * 文件提供人邮箱
     */
	@TableField("provider_email")
	private String providerEmail;
    /**
     * 文件其他联系方式
     */
	@TableField("other_contacts")
	private String otherContacts;
    /**
     * 文件更新频率
     */
	@TableField("update_frequence")
	private String updateFrequence;
    /**
     * 排序号
     */
	@TableField("order_by")
	private BigDecimal orderBy;
    /**
     * 是否显示
     */
	@TableField("is_show")
	private Integer isShow;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;


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

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEnableTime() {
		return enableTime;
	}

	public void setEnableTime(Date enableTime) {
		this.enableTime = enableTime;
	}

	public Date getDisableTime() {
		return disableTime;
	}

	public void setDisableTime(Date disableTime) {
		this.disableTime = disableTime;
	}

	public String getProvideDept() {
		return provideDept;
	}

	public void setProvideDept(String provideDept) {
		this.provideDept = provideDept;
	}

	public Date getProvideDate() {
		return provideDate;
	}

	public void setProvideDate(Date provideDate) {
		this.provideDate = provideDate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderPhone() {
		return providerPhone;
	}

	public void setProviderPhone(String providerPhone) {
		this.providerPhone = providerPhone;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getOtherContacts() {
		return otherContacts;
	}

	public void setOtherContacts(String otherContacts) {
		this.otherContacts = otherContacts;
	}

	public String getUpdateFrequence() {
		return updateFrequence;
	}

	public void setUpdateFrequence(String updateFrequence) {
		this.updateFrequence = updateFrequence;
	}

	public BigDecimal getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(BigDecimal orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

}
