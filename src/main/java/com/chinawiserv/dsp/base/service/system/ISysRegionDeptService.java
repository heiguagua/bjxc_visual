package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysRegionDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 行政部门表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
public interface ISysRegionDeptService extends ICommonService<SysRegionDept, SysRegionDeptVo> {

    List<SysRegionDeptVo> selectVoList(Map<String, Object> paramMap) throws Exception;
}
