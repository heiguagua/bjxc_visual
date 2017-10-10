package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDict;

/**
 * <p>
 * 系统字典表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public class SysDictVo extends SysDict {
	
	private String hasLeaf;

	private String stateName;

	private String regionName;

	public String getHasLeaf() {
		return hasLeaf;
	}

	public void setHasLeaf(String hasLeaf) {
		this.hasLeaf = hasLeaf;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
