package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
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

    boolean baseUpdate(SysDictCategory entity);

    int deleteByCategory(Map paramMap);

    List<SysDictCategory> listBySystemId(String systemId);

    List<SysDictCategory> listByList(List<String> list);

    List<String> listIdsByList(List<String> list);

    long batchInsert(List<SysDictCategory> list);

}