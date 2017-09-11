package com.chinawiserv.dsp.dir.mapper.feedback;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirSuggestion;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirSuggestionVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 咨询建议表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirSuggestionMapper extends BaseMapper<DirSuggestion> {

    List<DirSuggestionVo> selectVoPage(Page<DirSuggestionVo> page, Map<String, Object> paramMap);

    DirSuggestionVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirSuggestion entity);

    int baseUpdate(DirSuggestion entity);

    int baseDelete(String id);
}