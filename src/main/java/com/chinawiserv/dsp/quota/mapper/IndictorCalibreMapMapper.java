package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorCalibreMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCalibreMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标统计口径关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorCalibreMapMapper extends BaseMapper<IndictorCalibreMap> {

    List<IndictorCalibreMapVo> selectVoPage(Page<IndictorCalibreMapVo> page, Map<String, Object> paramMap);

    IndictorCalibreMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorCalibreMap entity);

    int baseUpdate(IndictorCalibreMap entity);

    int baseDelete(String id);
}