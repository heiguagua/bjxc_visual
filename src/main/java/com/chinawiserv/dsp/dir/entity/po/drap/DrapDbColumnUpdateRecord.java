package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据库字段更新记录 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_db_column_update_record")
public class DrapDbColumnUpdateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 监控记录表ID
     */
	@TableField("monitor_history_id")
	private String monitorHistoryId;
    /**
     * 本次更新表名
     */
	@TableField("table_name")
	private String tableName;
    /**
     * 更新前字段信息
     */
	@TableField("info_before")
	private String infoBefore;
    /**
     * 更新后字段信息
     */
	@TableField("info_after")
	private String infoAfter;
    /**
     * 字段更新信息说明
     */
	@TableField("info_update")
	private String infoUpdate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonitorHistoryId() {
		return monitorHistoryId;
	}

	public void setMonitorHistoryId(String monitorHistoryId) {
		this.monitorHistoryId = monitorHistoryId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getInfoBefore() {
		return infoBefore;
	}

	public void setInfoBefore(String infoBefore) {
		this.infoBefore = infoBefore;
	}

	public String getInfoAfter() {
		return infoAfter;
	}

	public void setInfoAfter(String infoAfter) {
		this.infoAfter = infoAfter;
	}

	public String getInfoUpdate() {
		return infoUpdate;
	}

	public void setInfoUpdate(String infoUpdate) {
		this.infoUpdate = infoUpdate;
	}

}
