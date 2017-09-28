package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 需求和数据集关联表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_requirement_dataset_map")
public class DrapRequirementDatasetMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 需求资源ID
     */
	@TableField("require_id")
	private String requireId;
    /**
     * 来源对象ID
     */
	@TableField("dataset_id")
	private String datasetId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequireId() {
		return requireId;
	}

	public void setRequireId(String requireId) {
		this.requireId = requireId;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

}
