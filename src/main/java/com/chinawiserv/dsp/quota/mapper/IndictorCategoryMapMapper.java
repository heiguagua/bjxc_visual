package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategoryMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标分类关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorCategoryMapMapper extends BaseMapper<IndictorCategoryMap> {

    List<IndictorCategoryMapVo> selectVoPage(Page<IndictorCategoryMapVo> page, Map<String, Object> paramMap);

    IndictorCategoryMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorCategoryMap entity);

    int baseUpdate(IndictorCategoryMap entity);

    int baseDelete(String id);
}