package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementResources;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementResourcesVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 需求资源信息表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapRequirementResourcesMapper extends BaseMapper<DrapRequirementResources> {

    List<DrapRequirementResourcesVo> selectVoPage(Page<DrapRequirementResourcesVo> page, Map<String, Object> paramMap);

    DrapRequirementResourcesVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapRequirementResources entity);

    int baseUpdate(DrapRequirementResources entity);

    int baseDelete(String id);
}