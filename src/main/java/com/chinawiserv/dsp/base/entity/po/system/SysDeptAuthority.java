package com.chinawiserv.dsp.base.entity.po.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门数据权限分配表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@TableName("sys_dept_authority")
public class SysDeptAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 权限对象类型
     */
	@TableField("auth_obj_type")
	private String authObjType;
    /**
     * 权限对象ID
     */
	@TableField("auth_obj_id")
	private String authObjId;
    /**
     * 被分配权限部门ID
     */
	@TableField("dept_id")
	private String deptId;
    /**
     * 读权限
     */
	@TableField("read_auth")
	private Integer readAuth;
    /**
     * 写权限
     */
	@TableField("write_auth")
	private Integer writeAuth;
    /**
     * 分配操作人
     */
	@TableField("distributor_id")
	private String distributorId;
    /**
     * 分配意见
     */
	@TableField("distribute_opinion")
	private String distributeOpinion;
    /**
     * 分配操作时间
     */
	@TableField("distribute_date")
	private Date distributeDate;
    /**
     * 是否来自于审核
     */
	@TableField("is_from_audit")
	private String isFromAudit;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthObjType() {
		return authObjType;
	}

	public void setAuthObjType(String authObjType) {
		this.authObjType = authObjType;
	}

	public String getAuthObjId() {
		return authObjId;
	}

	public void setAuthObjId(String authObjId) {
		this.authObjId = authObjId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getReadAuth() {
		return readAuth;
	}

	public void setReadAuth(Integer readAuth) {
		this.readAuth = readAuth;
	}

	public Integer getWriteAuth() {
		return writeAuth;
	}

	public void setWriteAuth(Integer writeAuth) {
		this.writeAuth = writeAuth;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributeOpinion() {
		return distributeOpinion;
	}

	public void setDistributeOpinion(String distributeOpinion) {
		this.distributeOpinion = distributeOpinion;
	}

	public Date getDistributeDate() {
		return distributeDate;
	}

	public void setDistributeDate(Date distributeDate) {
		this.distributeDate = distributeDate;
	}

	public String getIsFromAudit() {
		return isFromAudit;
	}

	public void setIsFromAudit(String isFromAudit) {
		this.isFromAudit = isFromAudit;
	}

}
