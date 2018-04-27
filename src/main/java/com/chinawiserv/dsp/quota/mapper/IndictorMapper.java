package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.Indictor;
import com.chinawiserv.dsp.quota.entity.vo.IndictorVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorMapper extends BaseMapper<Indictor> {

    List<IndictorVo> selectVoPage(Page<IndictorVo> page, Map<String, Object> paramMap);

    IndictorVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(Indictor entity);

    int baseUpdate(Indictor entity);

    int baseDelete(String id);
}