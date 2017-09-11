package com.chinawiserv.dsp.dir.entity.po.apply;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据项权限申请表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_dataitem_apply")
public class DirDataitemApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 申请信息资源ID
     */
	@TableField("dcm_id")
	private String dcmId;
    /**
     * 申请数据项ID
     */
	@TableField("item_id")
	private String itemId;
    /**
     * 申请人ID
     */
	@TableField("applicant_id")
	private String applicantId;
    /**
     * 申请详情
     */
	@TableField("apply_info")
	private String applyInfo;
    /**
     * 申请时间
     */
	@TableField("apply_date")
	private Date applyDate;
    /**
     * 审核人
     */
	@TableField("auditor_id")
	private String auditorId;
    /**
     * 审核状态
     */
	private String status;
    /**
     * 审核意见
     */
	@TableField("audit_opinion")
	private String auditOpinion;
    /**
     * 审核时间
     */
	@TableField("audit_date")
	private Date auditDate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDcmId() {
		return dcmId;
	}

	public void setDcmId(String dcmId) {
		this.dcmId = dcmId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(String applyInfo) {
		this.applyInfo = applyInfo;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

}
