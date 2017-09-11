package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 信息资源来源关系表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_dataset_source_relation")
public class DirDatasetSourceRelation implements Serializable {

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
     * 关联源表ID
     */
	@TableField("source_table_id")
	private String sourceTableId;
    /**
     * 关联源表字段ID
     */
	@TableField("source_column_id")
	private String sourceColumnId;
    /**
     * 关联目标表ID
     */
	@TableField("target_table_id")
	private String targetTableId;
    /**
     * 关联目标表字段ID
     */
	@TableField("target_column_id")
	private String targetColumnId;
    /**
     * 关联类型
     */
	@TableField("relation_type")
	private String relationType;
    /**
     * 关联其他信息
     */
	@TableField("relation_ext_info")
	private String relationExtInfo;


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

	public String getSourceTableId() {
		return sourceTableId;
	}

	public void setSourceTableId(String sourceTableId) {
		this.sourceTableId = sourceTableId;
	}

	public String getSourceColumnId() {
		return sourceColumnId;
	}

	public void setSourceColumnId(String sourceColumnId) {
		this.sourceColumnId = sourceColumnId;
	}

	public String getTargetTableId() {
		return targetTableId;
	}

	public void setTargetTableId(String targetTableId) {
		this.targetTableId = targetTableId;
	}

	public String getTargetColumnId() {
		return targetColumnId;
	}

	public void setTargetColumnId(String targetColumnId) {
		this.targetColumnId = targetColumnId;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getRelationExtInfo() {
		return relationExtInfo;
	}

	public void setRelationExtInfo(String relationExtInfo) {
		this.relationExtInfo = relationExtInfo;
	}

}
