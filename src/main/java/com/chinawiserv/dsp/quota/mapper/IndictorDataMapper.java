package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorData;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标数据表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
public interface IndictorDataMapper extends BaseMapper<IndictorData> {

    List<IndictorDataVo> selectVoPage(Page<IndictorDataVo> page, Map<String, Object> paramMap);

    IndictorDataVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorData entity);

    int baseUpdate(IndictorData entity);

    int baseDelete(String id);
}