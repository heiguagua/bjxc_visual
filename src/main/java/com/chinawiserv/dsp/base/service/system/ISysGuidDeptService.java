package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysGuidDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysGuidDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务指导部门记录表 服务类
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
public interface ISysGuidDeptService extends ICommonService<SysGuidDept, SysGuidDeptVo> {

    List<SysGuidDeptVo> selectVoList(String curDeptId);
}
