package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据库表更新记录表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_db_table_update_record")
public class DrapDbTableUpdateRecord implements Serializable {

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
     * 更新前表信息
     */
	@TableField("info_before")
	private String infoBefore;
    /**
     * 更新后表信息
     */
	@TableField("info_after")
	private String infoAfter;
    /**
     * 表更新信息说明
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
