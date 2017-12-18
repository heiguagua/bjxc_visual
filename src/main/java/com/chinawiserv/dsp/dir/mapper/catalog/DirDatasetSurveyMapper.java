package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceRelation;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSurvey;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSurveyVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lianrongfa on 2017/10/7.
 */
public interface DirDatasetSurveyMapper extends BaseMapper<DirDatasetSurvey> {

    public List<DirDatasetSurveyVo> baseSelect(Map<String,Object> param);

    public int baseInsert(DirDatasetSurvey dirDatasetSurvey);

    public int baseUpdate(DirDatasetSurvey dirDatasetSurvey);

    DirDatasetSurvey selectDrapSurveyByDatasetId(@Param("dataset_id")String dataset_id);

    void batchInsert(List<DirDatasetSurvey> dirDatasetSurveyList);
}
