package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 梳理数据集扩展信息（【国】资源格式） Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
@TableName("drap_dataset_ext_format")
public class DrapDatasetExtFormat implements Serializable {

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
     * 资源格式分类
     */
	@TableField("format_category")
	private String formatCategory;
    /**
     * 资源格式类型
     */
	@TableField("format_type")
	private String formatType;
    /**
     * 资源格式说明
     */
	@TableField("format_info")
	private String formatInfo;


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

	public String getFormatCategory() {
		return formatCategory;
	}

	public void setFormatCategory(String formatCategory) {
		this.formatCategory = formatCategory;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getFormatInfo() {
		return formatInfo;
	}

	public void setFormatInfo(String formatInfo) {
		this.formatInfo = formatInfo;
	}

}
