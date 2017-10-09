package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegionDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionDeptVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 行政部门表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
public interface SysRegionDeptMapper extends BaseMapper<SysRegionDept> {

    List<SysRegionDeptVo> selectVoPage(Page<SysRegionDeptVo> page, Map<String, Object> paramMap);

    SysRegionDeptVo selectVoById(String id);

    List<SysRegionDeptVo> selectVoListForTreeData(Map<String,Object> param);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysRegionDept entity);

    int baseUpdate(SysRegionDept entity);

    int baseDelete(String id);
}