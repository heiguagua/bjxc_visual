package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirIntrude;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirIntrudeVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 政策表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirIntrudeService extends ICommonService<DirIntrude, DirIntrudeVo> {
	void DeleteByFlag(String id);
}
