package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityRelDepts;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityRelDeptsVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动关联部门表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivityRelDeptsMapper extends BaseMapper<DrapActivityRelDepts> {

    List<DrapActivityRelDeptsVo> selectVoPage(Page<DrapActivityRelDeptsVo> page, Map<String, Object> paramMap);

    DrapActivityRelDeptsVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivityRelDepts entity);

    int baseUpdate(DrapActivityRelDepts entity);

    int baseDelete(String id);
}