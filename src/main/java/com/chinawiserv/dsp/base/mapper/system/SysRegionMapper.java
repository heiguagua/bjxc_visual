package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 行政区域表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
public interface SysRegionMapper extends BaseMapper<SysRegion> {

    List<SysRegionVo> selectVoPage(Page<SysRegionVo> page, Map<String, Object> paramMap);

    SysRegionVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysRegion entity);

    int baseUpdate(SysRegion entity);

    int baseDelete(String id);
}