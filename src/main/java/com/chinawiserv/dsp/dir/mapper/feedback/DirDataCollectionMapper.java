package com.chinawiserv.dsp.dir.mapper.feedback;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCollection;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCollectionVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集收藏记录 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataCollectionMapper extends BaseMapper<DirDataCollection> {

    List<DirDataCollectionVo> selectVoPage(Page<DirDataCollectionVo> page, Map<String, Object> paramMap);

    DirDataCollectionVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataCollection entity);

    int baseUpdate(DirDataCollection entity);

    int baseDelete(String id);
}