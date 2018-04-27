package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorClassify;
import com.chinawiserv.dsp.quota.entity.vo.IndictorClassifyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标分类方式 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorClassifyMapper extends BaseMapper<IndictorClassify> {

    List<IndictorClassifyVo> selectVoPage(Page<IndictorClassifyVo> page, Map<String, Object> paramMap);

    IndictorClassifyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorClassify entity);

    int baseUpdate(IndictorClassify entity);

    int baseDelete(String id);
}