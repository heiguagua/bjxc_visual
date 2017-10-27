package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysRoleVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 系统角色表 Mapper 接口1
 * </p>
 *
 * @author zhanf
 * @since 2017-05-08
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVo> selectVoPage(Page<SysRoleVo> page, Map<String, Object> paramMap);

    SysRoleVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    Integer deleteBatchRoleByIds(List<String> ids);

    List<SysRole> selectRolesByUserId(String userId);
}