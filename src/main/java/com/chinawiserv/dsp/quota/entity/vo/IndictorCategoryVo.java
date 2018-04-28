package com.chinawiserv.dsp.quota.entity.vo;

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

	public String getHasLeaf() {
		return hasLeaf;
	}

	public void setHasLeaf(String hasLeaf) {
		this.hasLeaf = hasLeaf;
	}

}
