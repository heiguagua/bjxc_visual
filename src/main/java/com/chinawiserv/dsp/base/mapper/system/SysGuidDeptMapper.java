package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysGuidDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysGuidDeptVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务指导部门记录表 Mapper 接口
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
public interface SysGuidDeptMapper extends BaseMapper<SysGuidDept> {

    List<SysGuidDeptVo> selectVoPage(Page<SysGuidDeptVo> page, Map<String, Object> paramMap);

    SysGuidDeptVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysGuidDept entity);

    int baseUpdate(SysGuidDept entity);

    int baseDelete(String id);

    List<SysGuidDeptVo> selectVoList(String curDeptId);

}