package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegionLevel;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionLevelVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 行政级别表 Mapper 接口
 * </p>
 *
 * @author tx123
 * @since 2018-02-07
 */
public interface SysRegionLevelMapper extends BaseMapper<SysRegionLevel> {

    List<SysRegionLevelVo> selectVoPage(Page<SysRegionLevelVo> page, Map<String, Object> paramMap);

    SysRegionLevelVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysRegionLevel entity);

    int baseUpdate(SysRegionLevel entity);

    int baseDelete(String id);

    List<SysRegionLevelVo> findByRegionLevelValueGreaterThan(Integer regionLevelValue);
}