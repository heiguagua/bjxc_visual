package com.chinawiserv.dsp.quota.entity.vo;

import com.chinawiserv.dsp.quota.entity.po.Indictor;

/**
 * <p>
 * 指标表 Vo对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public class IndictorVo extends Indictor {
	private Integer selectable;

	public Integer getSelectable() {
		return selectable;
	}

	public void setSelectable(Integer selectable) {
		this.selectable = selectable;
	}
}
