package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorComposeMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorComposeMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 统计指标来源指标关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorComposeMapMapper extends BaseMapper<IndictorComposeMap> {

    List<IndictorComposeMapVo> selectVoPage(Page<IndictorComposeMapVo> page, Map<String, Object> paramMap);

    IndictorComposeMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorComposeMap entity);

    int baseUpdate(IndictorComposeMap entity);

    int baseDelete(String id);
}