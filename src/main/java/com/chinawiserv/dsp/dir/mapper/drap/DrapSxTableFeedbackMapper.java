package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSxTableFeedback;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSxTableFeedbackVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据表反馈记录(淞幸) Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapSxTableFeedbackMapper extends BaseMapper<DrapSxTableFeedback> {

    List<DrapSxTableFeedbackVo> selectVoPage(Page<DrapSxTableFeedbackVo> page, Map<String, Object> paramMap);

    DrapSxTableFeedbackVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapSxTableFeedback entity);

    int baseUpdate(DrapSxTableFeedback entity);

    int baseDelete(String id);
}