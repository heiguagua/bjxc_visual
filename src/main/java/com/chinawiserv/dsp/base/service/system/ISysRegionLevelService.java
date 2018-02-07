package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysRegionLevel;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionLevelVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;

/**
 * <p>
 * 行政级别表 服务类
 * </p>
 *
 * @author tx123
 * @since 2018-02-07
 */
public interface ISysRegionLevelService extends ICommonService<SysRegionLevel, SysRegionLevelVo> {
    List<SysRegionLevelVo> findByRegionLevelValueGreaterThan(String regionCode);
}
