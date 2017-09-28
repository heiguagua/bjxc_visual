package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;

/**
 * <p>
 * 业务资源需求表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapBusinessRequirementVo extends DrapBusinessRequirement{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DrapRequirementResourcesVo> requireSourceVoLst;

	public List<DrapRequirementResourcesVo> getRequireSourceVoLst() {
		return requireSourceVoLst;
	}

	public void setRequireSourceVoLst(
			List<DrapRequirementResourcesVo> requireSourceVoLst) {
		this.requireSourceVoLst = requireSourceVoLst;
	}
	

}
