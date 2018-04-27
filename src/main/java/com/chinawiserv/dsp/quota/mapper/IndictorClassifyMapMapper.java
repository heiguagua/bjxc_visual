package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorClassifyMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorClassifyMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标分类方式关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorClassifyMapMapper extends BaseMapper<IndictorClassifyMap> {

    List<IndictorClassifyMapVo> selectVoPage(Page<IndictorClassifyMapVo> page, Map<String, Object> paramMap);

    IndictorClassifyMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorClassifyMap entity);

    int baseUpdate(IndictorClassifyMap entity);

    int baseDelete(String id);
}