package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 业务活动表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_business_activity")
public class DrapBusinessActivity implements Serializable {

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
     * 所属组织
     */
	@TableField("belong_dept")
	private String belongDept;
    /**
     * 业务类型
     */
	private String category;
    /**
     * 业务编码
     */
	@TableField("activity_code")
	private String activityCode;
    /**
     * 办理依据
     */
	@TableField("handle_basis")
	private String handleBasis;
    /**
     * 业务描述
     */
	@TableField("activity_desc")
	private String activityDesc;
    /**
     * 业务名称
     */
	@TableField("activity_name")
	private String activityName;
    /**
     * 扩展编码
     */
	@TableField("extend_code")
	private String extendCode;
    /**
     * 业务简称
     */
	@TableField("short_name")
	private String shortName;
    /**
     * 上级业务节点编码
     */
	@TableField("fid")
	private String fid;
    /**
     * 上级组织指导业务
     */
	@TableField("parent_guid_activity")
	private String parentGuidActivity;
    /**
     * 对应职能关键字
     */
	@TableField("function_keywords")
	private String functionKeywords;
    /**
     * 是否为具体执行业务
     */
	@TableField("is_run")
	private String isRun;
    /**
     * 服务对象
     */
	@TableField("service_target")
	private String serviceTarget;
    /**
     * 法定实施单位
     */
	@TableField("legal_deploy_dept")
	private String legalDeployDept;
    /**
     * 具体实施单位
     */
	@TableField("actual_deploy_dept")
	private String actualDeployDept;
    /**
     * 是否跨部门联办业务
     */
	@TableField("is_cooperate_business")
	private String isCooperateBusiness;
    /**
     * 办理条件
     */
	@TableField("handle_condition")
	private String handleCondition;
    /**
     * 办理结果
     */
	@TableField("handle_result")
	private String handleResult;
    /**
     * 结果有效期开始
     */
	@TableField("validity_from")
	private Date validityFrom;
    /**
     * 结果有效期结束
     */
	@TableField("validity_end")
	private Date validityEnd;
    /**
     * 是否进驻政务中心
     */
	@TableField("is_in_gc")
	private String isInGc;
    /**
     * 办理方式
     */
	@TableField("handle_method")
	private String handleMethod;
    /**
     * 是否公开
     */
	@TableField("is_open")
	private String isOpen;
    /**
     * 收费标准和依据
     */
	@TableField("charge_standard")
	private String chargeStandard;
    /**
     * 办理地点
     */
	@TableField("handle_address")
	private String handleAddress;
    /**
     * 法定时限
     */
	@TableField("legal_time_limit")
	private String legalTimeLimit;
    /**
     * 承诺时限
     */
	@TableField("promise_time_limit")
	private String promiseTimeLimit;
    /**
     * 办理联系人
     */
	private String handler;
    /**
     * 办理联系人电话
     */
	@TableField("handler_phone")
	private String handlerPhone;
    /**
     * 监督电话
     */
	@TableField("supervise_phone")
	private String supervisePhone;
    /**
     * 是否可网上办理
     */
	@TableField("handle_online")
	private String handleOnline;
    /**
     * 网上办理网址
     */
	@TableField("online_address")
	private String onlineAddress;
    /**
     * 网上办理说明
     */
	@TableField("handle_online_desc")
	private String handleOnlineDesc;
    /**
     * 办理程序
     */
	@TableField("handle_program")
	private String handleProgram;
    /**
     * 办理程序流程图
     */
	@TableField("handle_flowsheet")
	private String handleFlowsheet;
    /**
     * 年业务量估计
     */
	@TableField("year_business_volume")
	private String yearBusinessVolume;
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
     * 业务编码序号
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
    /**
     * 树索引
     */
	@TableField("tree_index")
	private Integer treeIndex;
    /**
     * 树编码
     */
	@TableField("tree_code")
	private String treeCode;

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

	public String getBelongDept() {
		return belongDept;
	}

	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getHandleBasis() {
		return handleBasis;
	}

	public void setHandleBasis(String handleBasis) {
		this.handleBasis = handleBasis;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getParentGuidActivity() {
		return parentGuidActivity;
	}

	public void setParentGuidActivity(String parentGuidActivity) {
		this.parentGuidActivity = parentGuidActivity;
	}

	public String getFunctionKeywords() {
		return functionKeywords;
	}

	public void setFunctionKeywords(String functionKeywords) {
		this.functionKeywords = functionKeywords;
	}

	public String getIsRun() {
		return isRun;
	}

	public void setIsRun(String isRun) {
		this.isRun = isRun;
	}

	public String getServiceTarget() {
		return serviceTarget;
	}

	public void setServiceTarget(String serviceTarget) {
		this.serviceTarget = serviceTarget;
	}

	public String getLegalDeployDept() {
		return legalDeployDept;
	}

	public void setLegalDeployDept(String legalDeployDept) {
		this.legalDeployDept = legalDeployDept;
	}

	public String getActualDeployDept() {
		return actualDeployDept;
	}

	public void setActualDeployDept(String actualDeployDept) {
		this.actualDeployDept = actualDeployDept;
	}

	public String getIsCooperateBusiness() {
		return isCooperateBusiness;
	}

	public void setIsCooperateBusiness(String isCooperateBusiness) {
		this.isCooperateBusiness = isCooperateBusiness;
	}

	public String getHandleCondition() {
		return handleCondition;
	}

	public void setHandleCondition(String handleCondition) {
		this.handleCondition = handleCondition;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public Date getValidityFrom() {
		return validityFrom;
	}

	public void setValidityFrom(Date validityFrom) {
		this.validityFrom = validityFrom;
	}

	public Date getValidityEnd() {
		return validityEnd;
	}

	public void setValidityEnd(Date validityEnd) {
		this.validityEnd = validityEnd;
	}

	public String getIsInGc() {
		return isInGc;
	}

	public void setIsInGc(String isInGc) {
		this.isInGc = isInGc;
	}

	public String getHandleMethod() {
		return handleMethod;
	}

	public void setHandleMethod(String handleMethod) {
		this.handleMethod = handleMethod;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getChargeStandard() {
		return chargeStandard;
	}

	public void setChargeStandard(String chargeStandard) {
		this.chargeStandard = chargeStandard;
	}

	public String getHandleAddress() {
		return handleAddress;
	}

	public void setHandleAddress(String handleAddress) {
		this.handleAddress = handleAddress;
	}

	public String getLegalTimeLimit() {
		return legalTimeLimit;
	}

	public void setLegalTimeLimit(String legalTimeLimit) {
		this.legalTimeLimit = legalTimeLimit;
	}

	public String getPromiseTimeLimit() {
		return promiseTimeLimit;
	}

	public void setPromiseTimeLimit(String promiseTimeLimit) {
		this.promiseTimeLimit = promiseTimeLimit;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getHandlerPhone() {
		return handlerPhone;
	}

	public void setHandlerPhone(String handlerPhone) {
		this.handlerPhone = handlerPhone;
	}

	public String getSupervisePhone() {
		return supervisePhone;
	}

	public void setSupervisePhone(String supervisePhone) {
		this.supervisePhone = supervisePhone;
	}

	public String getHandleOnline() {
		return handleOnline;
	}

	public void setHandleOnline(String handleOnline) {
		this.handleOnline = handleOnline;
	}

	public String getOnlineAddress() {
		return onlineAddress;
	}

	public void setOnlineAddress(String onlineAddress) {
		this.onlineAddress = onlineAddress;
	}

	public String getHandleOnlineDesc() {
		return handleOnlineDesc;
	}

	public void setHandleOnlineDesc(String handleOnlineDesc) {
		this.handleOnlineDesc = handleOnlineDesc;
	}

	public String getHandleProgram() {
		return handleProgram;
	}

	public void setHandleProgram(String handleProgram) {
		this.handleProgram = handleProgram;
	}

	public String getHandleFlowsheet() {
		return handleFlowsheet;
	}

	public void setHandleFlowsheet(String handleFlowsheet) {
		this.handleFlowsheet = handleFlowsheet;
	}

	public String getYearBusinessVolume() {
		return yearBusinessVolume;
	}

	public void setYearBusinessVolume(String yearBusinessVolume) {
		this.yearBusinessVolume = yearBusinessVolume;
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

}
