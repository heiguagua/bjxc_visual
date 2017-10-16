package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集扩展信息（【川】服务领域） Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
@TableName("dir_dataset_ext_sevice_field")
public class DirDatasetExtSeviceField implements Serializable {

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
     * 服务领域类型
     */
	@TableField("sevice_field_type")
	private String seviceFieldType;
    /**
     * 服务领域
     */
	@TableField("service_field_property")
	private String serviceFieldProperty;


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

	public String getSeviceFieldType() {
		return seviceFieldType;
	}

	public void setSeviceFieldType(String seviceFieldType) {
		this.seviceFieldType = seviceFieldType;
	}

	public String getServiceFieldProperty() {
		return serviceFieldProperty;
	}

	public void setServiceFieldProperty(String serviceFieldProperty) {
		this.serviceFieldProperty = serviceFieldProperty;
	}

}
