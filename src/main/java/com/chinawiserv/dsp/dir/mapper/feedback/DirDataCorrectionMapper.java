package com.chinawiserv.dsp.dir.mapper.feedback;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCorrection;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据纠错记录 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataCorrectionMapper extends BaseMapper<DirDataCorrection> {

    List<DirDataCorrectionVo> selectVoPage(Page<DirDataCorrectionVo> page, Map<String, Object> paramMap);

    DirDataCorrectionVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataCorrection entity);

    int baseUpdate(DirDataCorrection entity);

    int baseDelete(String id);
}