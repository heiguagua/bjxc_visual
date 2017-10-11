package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDictCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictCategoryVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统字典表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface SysDictCategoryMapper extends BaseMapper<SysDictCategory> {

    List<SysDictCategoryVo> selectCategoryVoPage(Page<SysDictCategoryVo> page, Map<String, Object> paramMap);

    SysDictCategoryVo selectVoById(String categoryCode);

    int selectCategoryVoCount(Map<String, Object> paramMap);

    int baseInsert(SysDictCategory entity);

    int dictInsert(SysDictCategory entity);

    boolean baseUpdate(SysDictCategory entity);

    int baseDelete(String id);

    int deleteByCategory(Map paramMap);

}