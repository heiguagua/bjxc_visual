package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据库监控任务表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_db_monitor_task")
public class DrapDbMonitorTask implements Serializable {

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
     * 监控周期
     */
	@TableField("monitor_period")
	private Integer monitorPeriod;
    /**
     * 监控周期单位
     */
	@TableField("monitor_period_unit")
	private String monitorPeriodUnit;
    /**
     * 监控时间范围起
     */
	@TableField("monitor_start")
	private Date monitorStart;
    /**
     * 监控时间范围止
     */
	@TableField("monitor_end")
	private Date monitorEnd;
    /**
     * 下次任务开始时间
     */
	@TableField("next_start_time")
	private Date nextStartTime;
    /**
     * 是否自动更新（0:否，1：是）
     */
	@TableField("auto_update_flag")
	private Integer autoUpdateFlag;
    /**
     * 当前任务启停状态
     */
	@TableField("cur_status")
	private String curStatus;


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

	public Integer getMonitorPeriod() {
		return monitorPeriod;
	}

	public void setMonitorPeriod(Integer monitorPeriod) {
		this.monitorPeriod = monitorPeriod;
	}

	public String getMonitorPeriodUnit() {
		return monitorPeriodUnit;
	}

	public void setMonitorPeriodUnit(String monitorPeriodUnit) {
		this.monitorPeriodUnit = monitorPeriodUnit;
	}

	public Date getMonitorStart() {
		return monitorStart;
	}

	public void setMonitorStart(Date monitorStart) {
		this.monitorStart = monitorStart;
	}

	public Date getMonitorEnd() {
		return monitorEnd;
	}

	public void setMonitorEnd(Date monitorEnd) {
		this.monitorEnd = monitorEnd;
	}

	public Date getNextStartTime() {
		return nextStartTime;
	}

	public void setNextStartTime(Date nextStartTime) {
		this.nextStartTime = nextStartTime;
	}

	public Integer getAutoUpdateFlag() {
		return autoUpdateFlag;
	}

	public void setAutoUpdateFlag(Integer autoUpdateFlag) {
		this.autoUpdateFlag = autoUpdateFlag;
	}

	public String getCurStatus() {
		return curStatus;
	}

	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
	}

}
