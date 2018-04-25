package com.chinawiserv.dsp.vm.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 图表指标描述信息 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_chart_description")
public class ChartDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 图表ID
     */
	@TableField("chart_id")
	private String chartId;
    /**
     * 副标题
     */
	@TableField("sub_title")
	private String subTitle;
    /**
     * 描述信息
     */
	private String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChartId() {
		return chartId;
	}

	public void setChartId(String chartId) {
		this.chartId = chartId;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
