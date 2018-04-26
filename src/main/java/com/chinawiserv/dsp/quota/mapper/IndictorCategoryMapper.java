package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标分类表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorCategoryMapper extends BaseMapper<IndictorCategory> {

    List<IndictorCategoryVo> selectVoPage(Page<IndictorCategoryVo> page, Map<String, Object> paramMap);

    IndictorCategoryVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorCategory entity);

    int baseUpdate(IndictorCategory entity);

    int baseDelete(String id);
}