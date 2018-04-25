package com.chinawiserv.dsp.vm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartDescription;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescriptionVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 图表指标描述信息 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartDescriptionMapper extends BaseMapper<ChartDescription> {

    List<ChartDescriptionVo> selectVoPage(Page<ChartDescriptionVo> page, Map<String, Object> paramMap);

    ChartDescriptionVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(ChartDescription entity);

    int baseUpdate(ChartDescription entity);

    int baseDelete(String id);
}