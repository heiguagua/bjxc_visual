package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDict;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictCategoryVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import org.apache.ibatis.annotations.Param;

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
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<SysDictVo> selectVoPage(Page<SysDictVo> page, Map<String, Object> paramMap);

    List<SysDictVo> selectDictList(Map<String, Object> paramMap);

    List<SysDictVo> selectDictDetailList(Page<SysDictVo> page, Map<String, Object> paramMap);
    
    List<SysDictVo> selectVoListForTreeData(Map<String, Object> paramMap);
    
    List<SysDictVo> selectVoListForTreeDataForApp(Map<String, Object> paramMap);

    SysDictCategoryVo selectVoById(String categoryCode);

    SysDictVo selectDetailVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysDict entity);

    int dictInsert(SysDict entity);

    int baseUpdate(SysDict entity);

    int baseDelete(String id);

    String selectDictcodeByCategoryAndName(@Param("dict_name") String dict_name,@Param("category") String category);
}