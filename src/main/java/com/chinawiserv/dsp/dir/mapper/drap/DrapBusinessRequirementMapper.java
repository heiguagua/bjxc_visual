package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务资源需求表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapBusinessRequirementMapper extends BaseMapper<DrapBusinessRequirement> {

    List<DrapBusinessRequirementVo> selectVoPage(Page<DrapBusinessRequirementVo> page, Map<String, Object> paramMap);

    DrapBusinessRequirementVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapBusinessRequirement entity);

    int baseUpdate(DrapBusinessRequirement entity);

    int baseDelete(String id);
}