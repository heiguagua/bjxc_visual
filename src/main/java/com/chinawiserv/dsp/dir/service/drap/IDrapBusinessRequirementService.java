package com.chinawiserv.dsp.dir.service.drap;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;
import com.chinawiserv.dsp.dir.entity.vo.drap.AuditEntity;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 业务资源需求表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapBusinessRequirementService extends ICommonService<DrapBusinessRequirement, DrapBusinessRequirementVo> {
	/**
	 * 需求同步
	 * @param voLst
	 * @return
	 */
	HandleResult insertBusinessRequirement(List<DrapBusinessRequirementVo> voLst);

	/**
	 * 删除需求
	 * @param paramMap
	 * @return
	 */
	HandleResult deleteBusinessRequirement(Map<String,?> paramMap);

    void updateRequirementStatus(AuditEntity auditEntity) throws Exception;
}
