package com.chinawiserv.dsp.vm.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 图表描述与指标关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_chart_desc_indictor_map")
public class ChartDescIndictorMap implements Serializable {

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
     * 指标编号
     */
	@TableField("indictor_code")
	private String indictorCode;
    /**
     * 指标显示名称
     */
	@TableField("indictor_show_name")
	private String indictorShowName;


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

	public String getIndictorCode() {
		return indictorCode;
	}

	public void setIndictorCode(String indictorCode) {
		this.indictorCode = indictorCode;
	}

	public String getIndictorShowName() {
		return indictorShowName;
	}

	public void setIndictorShowName(String indictorShowName) {
		this.indictorShowName = indictorShowName;
	}

}
