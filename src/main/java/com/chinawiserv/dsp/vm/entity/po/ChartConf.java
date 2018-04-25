package com.chinawiserv.dsp.vm.entity.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统图表配置表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_chart_conf")
public class ChartConf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 图表编号
     */
	@TableField("chart_code")
	private String chartCode;
    /**
     * 图表标题
     */
	@TableField("chart_name")
	private String chartName;
    /**
     * 标题是否显示
     */
	@TableField("is_name_show")
	private Integer isNameShow;
    /**
     * 图表描述
     */
	@TableField("chart_desc")
	private String chartDesc;
    /**
     * 图表类型
     */
	@TableField("chart_type")
	private String chartType;
    /**
     * 图表URL
     */
	@TableField("chart_url")
	private String chartUrl;
    /**
     * 图表时间范围类型
     */
	@TableField("chart_time_type")
	private String chartTimeType;
    /**
     * 图表时间范围取值
     */
	@TableField("chart_time_scope")
	private String chartTimeScope;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 创建人
     */
	@TableField("create_user_id")
	private String createUserId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_user_id")
	private String updateUserId;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
