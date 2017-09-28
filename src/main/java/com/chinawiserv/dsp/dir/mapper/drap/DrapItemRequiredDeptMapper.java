package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapItemRequiredDept;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapItemRequiredDeptVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务数据项关联需求部门(NO) Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapItemRequiredDeptMapper extends BaseMapper<DrapItemRequiredDept> {

    List<DrapItemRequiredDeptVo> selectVoPage(Page<DrapItemRequiredDeptVo> page, Map<String, Object> paramMap);

    DrapItemRequiredDeptVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapItemRequiredDept entity);

    int baseUpdate(DrapItemRequiredDept entity);

    int baseDelete(String id);
}