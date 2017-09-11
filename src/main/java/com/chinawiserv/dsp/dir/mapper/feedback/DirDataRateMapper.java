package com.chinawiserv.dsp.dir.mapper.feedback;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataRate;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataRateVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集评分记录 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataRateMapper extends BaseMapper<DirDataRate> {

    List<DirDataRateVo> selectVoPage(Page<DirDataRateVo> page, Map<String, Object> paramMap);

    DirDataRateVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataRate entity);

    int baseUpdate(DirDataRate entity);

    int baseDelete(String id);
}