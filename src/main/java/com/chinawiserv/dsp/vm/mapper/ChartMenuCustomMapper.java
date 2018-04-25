package com.chinawiserv.dsp.vm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuCustom;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuCustomVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 图表与菜单自定义关系 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartMenuCustomMapper extends BaseMapper<ChartMenuCustom> {

    List<ChartMenuCustomVo> selectVoPage(Page<ChartMenuCustomVo> page, Map<String, Object> paramMap);

    ChartMenuCustomVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(ChartMenuCustom entity);

    int baseUpdate(ChartMenuCustom entity);

    int baseDelete(String id);
}