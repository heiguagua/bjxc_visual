package com.chinawiserv.dsp.dir.entity.po.feedback;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据纠错记录 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_data_correction")
public class DirDataCorrection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据集目录类别关系ID
     */
	@TableField("dcm_id")
	private String dcmId;
    /**
     * 纠错人ID
     */
	@TableField("corrector_id")
	private String correctorId;
    /**
     * 纠错内容
     */
	@TableField("correct_content")
	private String correctContent;
    /**
     * 纠错时间
     */
	@TableField("correct_date")
	private Date correctDate;
    /**
     * 审核人ID
     */
	@TableField("auditor_id")
	private String auditorId;
    /**
     * 审核时间
     */
	@TableField("audit_date")
	private Date auditDate;
    /**
     * 审核状态
     */
	@TableField("audit_status")
	private String auditStatus;
    /**
     * 审核意见
     */
	@TableField("audit_opinion")
	private String auditOpinion;


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

	public String getCorrectorId() {
		return correctorId;
	}

	public void setCorrectorId(String correctorId) {
		this.correctorId = correctorId;
	}

	public String getCorrectContent() {
		return correctContent;
	}

	public void setCorrectContent(String correctContent) {
		this.correctContent = correctContent;
	}

	public Date getCorrectDate() {
		return correctDate;
	}

	public void setCorrectDate(Date correctDate) {
		this.correctDate = correctDate;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

}
