package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;

/**
 * <p>
  * 目录分类表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDeptMapMapper extends BaseMapper<DirDeptMap> {

    int baseInsert(DirDeptMap entity);

    String selectByDeptId(String deptId);

    String selectByDeptFId(String belongDeptId);
}