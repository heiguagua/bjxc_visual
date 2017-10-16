package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集扩展信息（【川】基本载体） Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
@TableName("dir_dataset_ext_carrier")
public class DirDatasetExtCarrier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据集ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 存储载体
     */
	@TableField("carrier_type")
	private String carrierType;


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

	public String getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}

}
