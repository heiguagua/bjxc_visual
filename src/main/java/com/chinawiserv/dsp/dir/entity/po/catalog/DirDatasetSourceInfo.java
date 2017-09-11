package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 信息资源来源信息 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_dataset_source_info")
public class DirDatasetSourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 数据集ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 来源模块
     */
	@TableField("source_mode")
	private String sourceMode;
    /**
     * 来源对象类型
     */
	@TableField("source_obj_type")
	private String sourceObjType;
    /**
     * 来源对象ID
     */
	@TableField("source_obj_id")
	private String sourceObjId;


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

	public String getSourceMode() {
		return sourceMode;
	}

	public void setSourceMode(String sourceMode) {
		this.sourceMode = sourceMode;
	}

	public String getSourceObjType() {
		return sourceObjType;
	}

	public void setSourceObjType(String sourceObjType) {
		this.sourceObjType = sourceObjType;
	}

	public String getSourceObjId() {
		return sourceObjId;
	}

	public void setSourceObjId(String sourceObjId) {
		this.sourceObjId = sourceObjId;
	}

}
