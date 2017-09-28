package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataPublish;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataPublishVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据发布情况 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataPublishMapper extends BaseMapper<DirDataPublish> {

    List<DirDataPublishVo> selectVoPage(Page<DirDataPublishVo> page, Map<String, Object> paramMap);

    DirDataPublishVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataPublish entity);

    int baseUpdate(DirDataPublish entity);

    int baseDelete(String id);

    int insertListData(@Param("list") List<DirDataPublishVo> list);
}