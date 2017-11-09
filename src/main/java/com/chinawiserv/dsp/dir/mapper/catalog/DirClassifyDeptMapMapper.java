package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyDeptMapVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 部门分类关联表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-11-08
 */
public interface DirClassifyDeptMapMapper extends BaseMapper<DirClassifyDeptMap> {

    List<DirClassifyDeptMapVo> selectVoPage(Page<DirClassifyDeptMapVo> page, Map<String, Object> paramMap);

    DirClassifyDeptMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirClassifyDeptMap entity);

    int baseUpdate(DirClassifyDeptMap entity);

    int baseDelete(String id);
}