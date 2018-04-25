package com.chinawiserv.dsp.vm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartConf;
import com.chinawiserv.dsp.vm.entity.vo.ChartConfVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统图表配置表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartConfMapper extends BaseMapper<ChartConf> {

    List<ChartConfVo> selectVoPage(Page<ChartConfVo> page, Map<String, Object> paramMap);

    ChartConfVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(ChartConf entity);

    int baseUpdate(ChartConf entity);

    int baseDelete(String id);
}