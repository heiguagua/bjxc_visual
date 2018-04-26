package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorCalibre;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCalibreVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标统计口径 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorCalibreMapper extends BaseMapper<IndictorCalibre> {

    List<IndictorCalibreVo> selectVoPage(Page<IndictorCalibreVo> page, Map<String, Object> paramMap);

    IndictorCalibreVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorCalibre entity);

    int baseUpdate(IndictorCalibre entity);

    int baseDelete(String id);
}