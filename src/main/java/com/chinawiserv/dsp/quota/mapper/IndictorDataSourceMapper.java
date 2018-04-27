package com.chinawiserv.dsp.quota.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorDataSource;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataSourceVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 指标数据来源表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorDataSourceMapper extends BaseMapper<IndictorDataSource> {

    List<IndictorDataSourceVo> selectVoPage(Page<IndictorDataSourceVo> page, Map<String, Object> paramMap);

    IndictorDataSourceVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(IndictorDataSource entity);

    int baseUpdate(IndictorDataSource entity);

    int baseDelete(String id);
}