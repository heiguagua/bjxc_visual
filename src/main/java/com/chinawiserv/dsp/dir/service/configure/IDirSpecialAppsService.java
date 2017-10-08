package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 专题应用表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirSpecialAppsService extends ICommonService<DirSpecialApps, DirSpecialAppsVo> {
	void DeleteByFlag(String id);
	
	
}
