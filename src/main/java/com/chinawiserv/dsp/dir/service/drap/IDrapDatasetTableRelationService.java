package com.chinawiserv.dsp.dir.service.drap;

import java.util.List;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetTableRelation;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetTableRelationVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;

/**
 * <p>
 * 信息资源梳理表关系记录表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapDatasetTableRelationService extends
		ICommonService<DrapDatasetTableRelation, DrapDatasetTableRelationVo> {
	HandleResult insertTableRelation(List<DrapDatasetVo> datasetRelationLst);
}
