package com.chinawiserv.dsp.dir.mapper.feedback;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataComment;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCommentVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集评论记录 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataCommentMapper extends BaseMapper<DirDataComment> {

    List<DirDataCommentVo> selectVoPage(Page<DirDataCommentVo> page, Map<String, Object> paramMap);

    DirDataCommentVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataComment entity);

    int baseUpdate(DirDataComment entity);

    int baseDelete(String id);
}