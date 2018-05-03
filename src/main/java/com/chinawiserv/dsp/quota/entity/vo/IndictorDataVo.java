package com.chinawiserv.dsp.quota.entity.vo;

import java.math.BigDecimal;

import com.chinawiserv.dsp.quota.entity.po.IndictorData;

/**
 * <p>
 * 指标数据表 Vo对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public class IndictorDataVo extends IndictorData {
	public String setStartTime;

	public BigDecimal valData;

	public String name;

	public BigDecimal getValData() {
		return valData;
	}

	public void setValData(BigDecimal valData) {
		this.valData = valData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetStartTime() {
		return setStartTime;
	}

	public void setSetStartTime(String setStartTime) {
		this.setStartTime = setStartTime;
	}

}
