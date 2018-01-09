package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 审核实体类
 * </p>
 *
 * @author Mibing
 * @since 2017-09-06
 */
public class AuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String ids;
	
	 /**
     * ID
     */
	private List<String> idArray;
	 /**
     *状态
     */
	private Integer status;
	/**
     * 审核人
     */
	private String auditor;
    /**
     * 审核意见
     */
	private String auditOpinion;
    /**
     * 审核时间
     */
	private Date auditTime;
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAuditOpinion() {
		return auditOpinion;
	}
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public List<String> getIdArray() {
		return idArray;
	}
	public void setIdArray(List<String> idArray) {
		this.idArray = idArray;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	
	

}
