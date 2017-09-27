package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 信息系统表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_info_system")
public class DrapInfoSystem implements Serializable {

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
     * 添加类型
     */
	@TableField("source_type")
	private String sourceType;
    /**
     * 业务系统编码
     */
	@TableField("system_code")
	private String systemCode;
    /**
     * 业务系统名称
     */
	@TableField("system_name")
	private String systemName;
    /**
     * 系统阶段
     */
	@TableField("system_phase")
	private String systemPhase;
    /**
     * 系统阶段补充说明
     */
	@TableField("system_phase_desc")
	private String systemPhaseDesc;
    /**
     * 主要功能
     */
	@TableField("main_feature")
	private String mainFeature;
    /**
     * 主要数据
     */
	@TableField("main_data")
	private String mainData;
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
     * 系统归属级别(建设性质)
     */
	@TableField("system_level")
	private String systemLevel;
    /**
     * 系统所属网络
     */
	@TableField("belong_network")
	private String belongNetwork;
    /**
     * 系统物理位置
     */
	@TableField("phisical_location")
	private String phisicalLocation;
    /**
     * 录入单位
     */
	@TableField("create_dept")
	private String createDept;
    /**
     * 是否本地部门建设
     */
	@TableField("self_build_flag")
	private String selfBuildFlag;
    /**
     * 系统建设单位
     */
	@TableField("build_dept")
	private String buildDept;
    /**
     * 系统架构
     */
	@TableField("system_structure")
	private String systemStructure;
    /**
     * 系统登录方式
     */
	@TableField("login_type")
	private String loginType;
    /**
     * 系统应用情况
     */
	@TableField("system_usage_info")
	private String systemUsageInfo;
    /**
     * 系统应用情况说明
     */
	@TableField("system_usage_desc")
	private String systemUsageDesc;
    /**
     * 系统开发商
     */
	@TableField("support_company")
	private String supportCompany;
    /**
     * 系统开发商联系人
     */
	@TableField("support_contacts")
	private String supportContacts;
    /**
     * 系统开发商联系人电话
     */
	@TableField("support_contacts_phone")
	private String supportContactsPhone;
    /**
     * 系统开发商联系人邮箱
     */
	@TableField("support_contacts_email")
	private String supportContactsEmail;
    /**
     * 系统开发商其他联系方式
     */
	@TableField("support_other_contacts")
	private String supportOtherContacts;
    /**
     * 运维单位
     */
	@TableField("maintain_dept")
	private String maintainDept;
    /**
     * 运维单位联系人
     */
	@TableField("maintain_contacts")
	private String maintainContacts;
    /**
     * 运维单位联系人电话
     */
	@TableField("maintain_contacts_phone")
	private String maintainContactsPhone;
    /**
     * 运维单位联系人邮箱
     */
	@TableField("maintain_contacts_email")
	private String maintainContactsEmail;
    /**
     * 运维单位其他联系方式
     */
	@TableField("maintain_other_contacts")
	private String maintainOtherContacts;
    /**
     * 系统售后支持情况
     */
	@TableField("customer_service_info")
	private String customerServiceInfo;
    /**
     * 数据跨度起
     */
	@TableField("data_range_begin")
	private String dataRangeBegin;
    /**
     * 数据跨度止
     */
	@TableField("data_range_end")
	private String dataRangeEnd;
    /**
     * 存储量统计截止时间
     */
	@TableField("calculate_date")
	private Date calculateDate;
    /**
     * 数据存储量
     */
	@TableField("data_storage")
	private BigDecimal dataStorage;
    /**
     * 数据年增长量
     */
	@TableField("year_increment")
	private BigDecimal yearIncrement;
    /**
     * 通用访问地址
     */
	@TableField("visit_url")
	private String visitUrl;
    /**
     * 通用访问账号
     */
	@TableField("visit_username")
	private String visitUsername;
    /**
     * 通用访问密码
     */
	@TableField("visit_password")
	private String visitPassword;
    /**
     * 是否提供服务接口
     */
	@TableField("has_interface")
	private String hasInterface;
    /**
     * 是否有在线对外业务
     */
	@TableField("is_online_external")
	private String isOnlineExternal;
    /**
     * 是否提供服务调用
     */
	@TableField("is_service_called")
	private String isServiceCalled;
    /**
     * 是否提供服务调用规范说明
     */
	@TableField("is_service_standard")
	private String isServiceStandard;
    /**
     * 是否有导出功能
     */
	@TableField("is_export")
	private String isExport;
    /**
     * 是否有旧系统
     */
	@TableField("has_old_system")
	private String hasOldSystem;
    /**
     * 旧系统名称
     */
	@TableField("old_system_name")
	private String oldSystemName;
    /**
     * 旧系统补充说明
     */
	@TableField("old_system_desc")
	private String oldSystemDesc;
    /**
     * 系统功能描述
     */
	@TableField("system_desc")
	private String systemDesc;
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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemPhase() {
		return systemPhase;
	}

	public void setSystemPhase(String systemPhase) {
		this.systemPhase = systemPhase;
	}

	public String getSystemPhaseDesc() {
		return systemPhaseDesc;
	}

	public void setSystemPhaseDesc(String systemPhaseDesc) {
		this.systemPhaseDesc = systemPhaseDesc;
	}

	public String getMainFeature() {
		return mainFeature;
	}

	public void setMainFeature(String mainFeature) {
		this.mainFeature = mainFeature;
	}

	public String getMainData() {
		return mainData;
	}

	public void setMainData(String mainData) {
		this.mainData = mainData;
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

	public String getSystemLevel() {
		return systemLevel;
	}

	public void setSystemLevel(String systemLevel) {
		this.systemLevel = systemLevel;
	}

	public String getBelongNetwork() {
		return belongNetwork;
	}

	public void setBelongNetwork(String belongNetwork) {
		this.belongNetwork = belongNetwork;
	}

	public String getPhisicalLocation() {
		return phisicalLocation;
	}

	public void setPhisicalLocation(String phisicalLocation) {
		this.phisicalLocation = phisicalLocation;
	}

	public String getCreateDept() {
		return createDept;
	}

	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}

	public String getSelfBuildFlag() {
		return selfBuildFlag;
	}

	public void setSelfBuildFlag(String selfBuildFlag) {
		this.selfBuildFlag = selfBuildFlag;
	}

	public String getBuildDept() {
		return buildDept;
	}

	public void setBuildDept(String buildDept) {
		this.buildDept = buildDept;
	}

	public String getSystemStructure() {
		return systemStructure;
	}

	public void setSystemStructure(String systemStructure) {
		this.systemStructure = systemStructure;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getSystemUsageInfo() {
		return systemUsageInfo;
	}

	public void setSystemUsageInfo(String systemUsageInfo) {
		this.systemUsageInfo = systemUsageInfo;
	}

	public String getSystemUsageDesc() {
		return systemUsageDesc;
	}

	public void setSystemUsageDesc(String systemUsageDesc) {
		this.systemUsageDesc = systemUsageDesc;
	}

	public String getSupportCompany() {
		return supportCompany;
	}

	public void setSupportCompany(String supportCompany) {
		this.supportCompany = supportCompany;
	}

	public String getSupportContacts() {
		return supportContacts;
	}

	public void setSupportContacts(String supportContacts) {
		this.supportContacts = supportContacts;
	}

	public String getSupportContactsPhone() {
		return supportContactsPhone;
	}

	public void setSupportContactsPhone(String supportContactsPhone) {
		this.supportContactsPhone = supportContactsPhone;
	}

	public String getSupportContactsEmail() {
		return supportContactsEmail;
	}

	public void setSupportContactsEmail(String supportContactsEmail) {
		this.supportContactsEmail = supportContactsEmail;
	}

	public String getSupportOtherContacts() {
		return supportOtherContacts;
	}

	public void setSupportOtherContacts(String supportOtherContacts) {
		this.supportOtherContacts = supportOtherContacts;
	}

	public String getMaintainDept() {
		return maintainDept;
	}

	public void setMaintainDept(String maintainDept) {
		this.maintainDept = maintainDept;
	}

	public String getMaintainContacts() {
		return maintainContacts;
	}

	public void setMaintainContacts(String maintainContacts) {
		this.maintainContacts = maintainContacts;
	}

	public String getMaintainContactsPhone() {
		return maintainContactsPhone;
	}

	public void setMaintainContactsPhone(String maintainContactsPhone) {
		this.maintainContactsPhone = maintainContactsPhone;
	}

	public String getMaintainContactsEmail() {
		return maintainContactsEmail;
	}

	public void setMaintainContactsEmail(String maintainContactsEmail) {
		this.maintainContactsEmail = maintainContactsEmail;
	}

	public String getMaintainOtherContacts() {
		return maintainOtherContacts;
	}

	public void setMaintainOtherContacts(String maintainOtherContacts) {
		this.maintainOtherContacts = maintainOtherContacts;
	}

	public String getCustomerServiceInfo() {
		return customerServiceInfo;
	}

	public void setCustomerServiceInfo(String customerServiceInfo) {
		this.customerServiceInfo = customerServiceInfo;
	}

	public String getDataRangeBegin() {
		return dataRangeBegin;
	}

	public void setDataRangeBegin(String dataRangeBegin) {
		this.dataRangeBegin = dataRangeBegin;
	}

	public String getDataRangeEnd() {
		return dataRangeEnd;
	}

	public void setDataRangeEnd(String dataRangeEnd) {
		this.dataRangeEnd = dataRangeEnd;
	}

	public Date getCalculateDate() {
		return calculateDate;
	}

	public void setCalculateDate(Date calculateDate) {
		this.calculateDate = calculateDate;
	}

	public BigDecimal getDataStorage() {
		return dataStorage;
	}

	public void setDataStorage(BigDecimal dataStorage) {
		this.dataStorage = dataStorage;
	}

	public BigDecimal getYearIncrement() {
		return yearIncrement;
	}

	public void setYearIncrement(BigDecimal yearIncrement) {
		this.yearIncrement = yearIncrement;
	}

	public String getVisitUrl() {
		return visitUrl;
	}

	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}

	public String getVisitUsername() {
		return visitUsername;
	}

	public void setVisitUsername(String visitUsername) {
		this.visitUsername = visitUsername;
	}

	public String getVisitPassword() {
		return visitPassword;
	}

	public void setVisitPassword(String visitPassword) {
		this.visitPassword = visitPassword;
	}

	public String getHasInterface() {
		return hasInterface;
	}

	public void setHasInterface(String hasInterface) {
		this.hasInterface = hasInterface;
	}

	public String getIsOnlineExternal() {
		return isOnlineExternal;
	}

	public void setIsOnlineExternal(String isOnlineExternal) {
		this.isOnlineExternal = isOnlineExternal;
	}

	public String getIsServiceCalled() {
		return isServiceCalled;
	}

	public void setIsServiceCalled(String isServiceCalled) {
		this.isServiceCalled = isServiceCalled;
	}

	public String getIsServiceStandard() {
		return isServiceStandard;
	}

	public void setIsServiceStandard(String isServiceStandard) {
		this.isServiceStandard = isServiceStandard;
	}

	public String getIsExport() {
		return isExport;
	}

	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	public String getHasOldSystem() {
		return hasOldSystem;
	}

	public void setHasOldSystem(String hasOldSystem) {
		this.hasOldSystem = hasOldSystem;
	}

	public String getOldSystemName() {
		return oldSystemName;
	}

	public void setOldSystemName(String oldSystemName) {
		this.oldSystemName = oldSystemName;
	}

	public String getOldSystemDesc() {
		return oldSystemDesc;
	}

	public void setOldSystemDesc(String oldSystemDesc) {
		this.oldSystemDesc = oldSystemDesc;
	}

	public String getSystemDesc() {
		return systemDesc;
	}

	public void setSystemDesc(String systemDesc) {
		this.systemDesc = systemDesc;
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
