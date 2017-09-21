package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirPolicy;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirPolicyVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 政策表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirPolicyService extends ICommonService<DirPolicy, DirPolicyVo> {
	void DeleteByFlag(String id);
}
