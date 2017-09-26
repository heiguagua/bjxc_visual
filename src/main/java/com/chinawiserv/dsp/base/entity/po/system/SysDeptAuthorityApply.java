package com.chinawiserv.dsp.base.entity.po.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据权限申请表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@TableName("sys_dept_authority_apply")
public class SysDeptAuthorityApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 申请人ID
     */
	private String applicant;
    /**
     * 申请理由
     */
	@TableField("apply_reason")
	private String applyReason;
    /**
     * 申请时间
     */
	@TableField("apply_time")
	private Date applyTime;
    /**
     * 申请权限对应部门
     */
	@TableField("to_dept_id")
	private String toDeptId;
    /**
     * 申请权限类型
     */
	@TableField("authority_type")
	private String authorityType;
    /**
     * 审核人
     */
	private String auditor;
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
    /**
     * 审核状态
     */
	@TableField("audit_status")
	private String auditStatus;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getToDeptId() {
		return toDeptId;
	}

	public void setToDeptId(String toDeptId) {
		this.toDeptId = toDeptId;
	}

	public String getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
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

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

}
