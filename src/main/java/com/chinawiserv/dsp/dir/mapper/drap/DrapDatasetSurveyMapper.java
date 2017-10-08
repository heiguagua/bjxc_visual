package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetSurvey;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetSurveyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 梳理信息资源大普查信息表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
public interface DrapDatasetSurveyMapper extends BaseMapper<DrapDatasetSurvey> {

    List<DrapDatasetSurveyVo> selectVoPage(Page<DrapDatasetSurveyVo> page, Map<String, Object> paramMap);

    DrapDatasetSurveyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetSurvey entity);

    int baseUpdate(DrapDatasetSurvey entity);

    int baseDelete(String id);

    void batchInsert(List<DrapDatasetSurvey> drapDatasetSurveyList);
}