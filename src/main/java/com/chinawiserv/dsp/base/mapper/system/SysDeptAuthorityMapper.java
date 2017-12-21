package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 部门数据权限分配表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface SysDeptAuthorityMapper extends BaseMapper<SysDeptAuthority> {

    List<SysDeptAuthorityVo> selectVoPage(Page<SysDeptAuthorityVo> page, Map<String, Object> paramMap);

    SysDeptAuthorityVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysDeptAuthority entity);

    int baseUpdate(SysDeptAuthority entity);

    int baseDelete(String id);

    List<SysDeptAuthorityVo> selectVoList(Map<String, Object> paramMap);

    int deleteByVo(SysDeptAuthorityVo sysDeptAuthorityVo);

    List<String> getSelectedNodeByCurrentNode(Map<String, Object> paramMap);

    List<String> getAllDeptParentNode(Map<String, Object> paramMap);
}