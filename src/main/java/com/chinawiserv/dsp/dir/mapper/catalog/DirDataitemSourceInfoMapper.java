package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitemSourceInfo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemSourceInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据项来源信息表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataitemSourceInfoMapper extends BaseMapper<DirDataitemSourceInfo> {

    List<DirDataitemSourceInfoVo> selectVoPage(Page<DirDataitemSourceInfoVo> page, Map<String, Object> paramMap);

    DirDataitemSourceInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataitemSourceInfo entity);

    int baseUpdate(DirDataitemSourceInfo entity);

    int baseDelete(String id);

    int insertList(@Param("list") List<DirDataitemSourceInfo> list);
}