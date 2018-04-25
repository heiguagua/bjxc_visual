package com.chinawiserv.dsp.vm.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 图表分类信息 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_chart_classify")
public class ChartClassify implements Serializable {

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
     * 分类名称
     */
	@TableField("classify_name")
	private String classifyName;
    /**
     * 分类级别
     */
	@TableField("classify_level")
	private String classifyLevel;
    /**
     * 对应图形类型
     */
	@TableField("chart_type")
	private String chartType;


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

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getClassifyLevel() {
		return classifyLevel;
	}

	public void setClassifyLevel(String classifyLevel) {
		this.classifyLevel = classifyLevel;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

}
