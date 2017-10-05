package com.chinawiserv.dsp.dir.entity.po.apply;

import java.io.Serializable;
import java.util.Date;

public class DirDataApply implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String dcmId;

    private String applicantId;

    private String applyInfo;

    private Date applyDate;

    private Integer limitVisitCnt;

    private String limitVisitDatePeriod;

    private String auditorId;

    private String status;

    private Integer auditVisitCnt;

    private String auditVisitDatePeriod;

    private String auditOpinion;

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

    public Integer getLimitVisitCnt() {
        return limitVisitCnt;
    }

    public void setLimitVisitCnt(Integer limitVisitCnt) {
        this.limitVisitCnt = limitVisitCnt;
    }

    public String getLimitVisitDatePeriod() {
        return limitVisitDatePeriod;
    }

    public void setLimitVisitDatePeriod(String limitVisitDatePeriod) {
        this.limitVisitDatePeriod = limitVisitDatePeriod;
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

    public Integer getAuditVisitCnt() {
        return auditVisitCnt;
    }

    public void setAuditVisitCnt(Integer auditVisitCnt) {
        this.auditVisitCnt = auditVisitCnt;
    }

    public String getAuditVisitDatePeriod() {
        return auditVisitDatePeriod;
    }

    public void setAuditVisitDatePeriod(String auditVisitDatePeriod) {
        this.auditVisitDatePeriod = auditVisitDatePeriod;
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
