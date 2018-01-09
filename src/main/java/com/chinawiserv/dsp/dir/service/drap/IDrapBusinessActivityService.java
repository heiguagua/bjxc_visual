package com.chinawiserv.dsp.dir.service.drap;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessActivity;
import com.chinawiserv.dsp.dir.entity.vo.drap.AuditEntity;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessActivityVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 业务活动表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapBusinessActivityService extends ICommonService<DrapBusinessActivity, DrapBusinessActivityVo> {

	void updateBusinessData(Map<String, Object> dataObj) throws Exception;

	void deleteBusinessData(Map<String, Object> dataObj) throws Exception;

    void updateBusinessStatus(AuditEntity auditEntity) throws Exception;
}
