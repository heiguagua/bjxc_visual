package com.chinawiserv.dsp.vm.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 图表与菜单自定义关系 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_chart_menu_custom")
public class ChartMenuCustom implements Serializable {

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
	 * 菜单ID
	 */
	@TableField("menu_id")
	private String menuId;

	/**
	 * 图表位置
	 */
	private String location;

	/**
	 * 图表显示顺序
	 */
	@TableField("show_order")
	private Integer showOrder;

	/**
	 * 使用人
	 */
	private String user;

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

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
