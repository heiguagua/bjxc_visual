package com.chinawiserv.dsp.vm.entity.vo;

import java.util.List;

import com.chinawiserv.dsp.vm.entity.po.ChartConf;

/**
 * <p>
 * 系统图表配置表 Vo对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public class ChartConfVo extends ChartConf {
	private String subTitle;

	private String description;

	private String location;

	private Integer showOrder;

	private String chartMenuCustomId;

	private List<ChartClassifyVo> listChartClassify;

	private List<ChartDescIndictorMapVo> listChartDescIndictorMap;

	private List<ClassifyIndictorMapVo> listClassifyIndictorMap;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getChartMenuCustomId() {
		return chartMenuCustomId;
	}

	public void setChartMenuCustomId(String chartMenuCustomId) {
		this.chartMenuCustomId = chartMenuCustomId;
	}

	public List<ChartClassifyVo> getListChartClassify() {
		return listChartClassify;
	}

	public void setListChartClassify(List<ChartClassifyVo> listChartClassify) {
		this.listChartClassify = listChartClassify;
	}

	public List<ChartDescIndictorMapVo> getListChartDescIndictorMap() {
		return listChartDescIndictorMap;
	}

	public void setListChartDescIndictorMap(List<ChartDescIndictorMapVo> listChartDescIndictorMap) {
		this.listChartDescIndictorMap = listChartDescIndictorMap;
	}

	public List<ClassifyIndictorMapVo> getListClassifyIndictorMap() {
		return listClassifyIndictorMap;
	}

	public void setListClassifyIndictorMap(List<ClassifyIndictorMapVo> listClassifyIndictorMap) {
		this.listClassifyIndictorMap = listClassifyIndictorMap;
	}

}
