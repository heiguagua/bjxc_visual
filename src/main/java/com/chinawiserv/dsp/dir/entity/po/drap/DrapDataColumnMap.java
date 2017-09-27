package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据项与表字段关系梳理表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_data_column_map")
public class DrapDataColumnMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 信息资源ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 信息资源表数据项ID
     */
	@TableField("business_item_id")
	private String businessItemId;
    /**
     * 数据库表字段ID
     */
	@TableField("system_column_id")
	private String systemColumnId;
    /**
     * 信息系统ID
     */
	@TableField("info_system_id")
	private String infoSystemId;
    /**
     * 数据库ID
     */
	@TableField("db_id")
	private String dbId;
    /**
     * 数据表ID
     */
	@TableField("table_id")
	private String tableId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(String businessItemId) {
		this.businessItemId = businessItemId;
	}

	public String getSystemColumnId() {
		return systemColumnId;
	}

	public void setSystemColumnId(String systemColumnId) {
		this.systemColumnId = systemColumnId;
	}

	public String getInfoSystemId() {
		return infoSystemId;
	}

	public void setInfoSystemId(String infoSystemId) {
		this.infoSystemId = infoSystemId;
	}

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

}
