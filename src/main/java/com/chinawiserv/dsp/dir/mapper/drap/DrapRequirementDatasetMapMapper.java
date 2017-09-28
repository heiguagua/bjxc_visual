package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementDatasetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementDatasetMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 需求和数据集关联表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapRequirementDatasetMapMapper extends BaseMapper<DrapRequirementDatasetMap> {

    List<DrapRequirementDatasetMapVo> selectVoPage(Page<DrapRequirementDatasetMapVo> page, Map<String, Object> paramMap);

    DrapRequirementDatasetMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapRequirementDatasetMap entity);

    int baseUpdate(DrapRequirementDatasetMap entity);

    int baseDelete(String id);
}