package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetAttachment;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetAttachmentVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author tx
 * @since 2017-11-28
 */
public interface DirDatasetAttachmentMapper extends BaseMapper<DirDatasetAttachment> {

    List<DirDatasetAttachmentVo> selectVoPage(Page<DirDatasetAttachmentVo> page, Map<String, Object> paramMap);

    DirDatasetAttachmentVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetAttachment entity);

    int baseUpdate(DirDatasetAttachment entity);

    int baseDelete(String id);
}