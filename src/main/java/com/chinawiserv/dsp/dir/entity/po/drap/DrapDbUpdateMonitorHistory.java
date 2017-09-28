package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据库更新状态监控记录表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_db_update_monitor_history")
public class DrapDbUpdateMonitorHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据库ID
     */
	@TableField("db_id")
	private String dbId;
    /**
     * 监控类型
     */
	@TableField("monitor_type")
	private String monitorType;
    /**
     * 监控操作者
     */
	private String operator;
    /**
     * 监控时间
     */
	@TableField("monitor_time")
	private Date monitorTime;
    /**
     * 更新记录状态
     */
	@TableField("cur_status")
	private String curStatus;
    /**
     * 操作确认人
     */
	@TableField("confirm_user")
	private String confirmUser;
    /**
     * 操作确认时间
     */
	@TableField("confirm_time")
	private Date confirmTime;
    /**
     * 操作确认状态
     */
	@TableField("confirm_status")
	private String confirmStatus;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getMonitorTime() {
		return monitorTime;
	}

	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}

	public String getCurStatus() {
		return curStatus;
	}

	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

}
