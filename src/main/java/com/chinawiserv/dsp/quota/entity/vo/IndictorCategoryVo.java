package com.chinawiserv.dsp.quota.entity.vo;

import java.util.List;

import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;

/**
 * <p>
 * 指标分类表 Vo对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public class IndictorCategoryVo extends IndictorCategory {
	private String hasLeaf;

	private Integer selectable;

	private List<IndictorVo> indictorVos;

	public String getHasLeaf() {
		return hasLeaf;
	}

	public void setHasLeaf(String hasLeaf) {
		this.hasLeaf = hasLeaf;
	}

	public Integer getSelectable() {
		return selectable;
	}

	public void setSelectable(Integer selectable) {
		this.selectable = selectable;
	}

	public List<IndictorVo> getIndictorVos() {
		return indictorVos;
	}

	public void setIndictorVos(List<IndictorVo> indictorVos) {
		this.indictorVos = indictorVos;
	}

}
