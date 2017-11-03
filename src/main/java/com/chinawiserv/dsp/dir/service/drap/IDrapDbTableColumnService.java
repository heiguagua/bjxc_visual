package com.chinawiserv.dsp.dir.service.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableColumn;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableColumnVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 数据表字段信息 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapDbTableColumnService extends ICommonService<DrapDbTableColumn, DrapDbTableColumnVo> {

	void updateDbTableColumnVos(List<DrapDbTableColumnVo> dbTableColumnVos) throws Exception;
	
}
