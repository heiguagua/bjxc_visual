package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门数据权限分配表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface ISysDeptAuthorityService extends ICommonService<SysDeptAuthority, SysDeptAuthorityVo> {

    List<SysDeptAuthorityVo> selectVoList(Map<String, Object> paramMap);

    List<String> selectParentDeptAuthIds(Map<String, Object> paramMap);

}
