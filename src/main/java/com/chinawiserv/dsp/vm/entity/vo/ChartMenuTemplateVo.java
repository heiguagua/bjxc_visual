package com.chinawiserv.dsp.vm.entity.vo;

import com.chinawiserv.dsp.vm.entity.po.ChartMenuTemplate;

/**
 * <p>
 * 图表与菜单关系模板表 Vo对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public class ChartMenuTemplateVo extends ChartMenuTemplate {
	private String chartCode;

	private String chartName;

	private Integer isNameShow;

	private String chartDesc;

	private String chartType;

	private String chartUrl;

	private String chartTimeType;

	private String chartTimeScope;

	private Integer hasSubIndictor;

	public String getChartCode() {
		return chartCode;
	}

	public void setChartCode(String chartCode) {
		this.chartCode = chartCode;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public Integer getIsNameShow() {
		return isNameShow;
	}

	public void setIsNameShow(Integer isNameShow) {
		this.isNameShow = isNameShow;
	}

	public String getChartDesc() {
		return chartDesc;
	}

	public void setChartDesc(String chartDesc) {
		this.chartDesc = chartDesc;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getChartUrl() {
		return chartUrl;
	}

	public void setChartUrl(String chartUrl) {
		this.chartUrl = chartUrl;
	}

	public String getChartTimeType() {
		return chartTimeType;
	}

	public void setChartTimeType(String chartTimeType) {
		this.chartTimeType = chartTimeType;
	}

	public String getChartTimeScope() {
		return chartTimeScope;
	}

	public void setChartTimeScope(String chartTimeScope) {
		this.chartTimeScope = chartTimeScope;
	}

	public Integer getHasSubIndictor() {
		return hasSubIndictor;
	}

	public void setHasSubIndictor(Integer hasSubIndictor) {
		this.hasSubIndictor = hasSubIndictor;
	}

}
