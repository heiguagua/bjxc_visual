package com.chinawiserv.dsp.vm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuTemplate;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuTemplateVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 图表与菜单关系模板表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartMenuTemplateMapper extends BaseMapper<ChartMenuTemplate> {

    List<ChartMenuTemplateVo> selectVoPage(Page<ChartMenuTemplateVo> page, Map<String, Object> paramMap);

    ChartMenuTemplateVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(ChartMenuTemplate entity);

    int baseUpdate(ChartMenuTemplate entity);

    int baseDelete(String id);
}