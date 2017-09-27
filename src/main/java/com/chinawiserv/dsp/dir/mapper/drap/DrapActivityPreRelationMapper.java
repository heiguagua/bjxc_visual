package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityPreRelation;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityPreRelationVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动前置关系表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivityPreRelationMapper extends BaseMapper<DrapActivityPreRelation> {

    List<DrapActivityPreRelationVo> selectVoPage(Page<DrapActivityPreRelationVo> page, Map<String, Object> paramMap);

    DrapActivityPreRelationVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivityPreRelation entity);

    int baseUpdate(DrapActivityPreRelation entity);

    int baseDelete(String id);
}