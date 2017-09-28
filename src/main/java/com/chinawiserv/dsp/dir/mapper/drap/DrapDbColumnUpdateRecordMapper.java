package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbColumnUpdateRecord;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbColumnUpdateRecordVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库字段更新记录 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbColumnUpdateRecordMapper extends BaseMapper<DrapDbColumnUpdateRecord> {

    List<DrapDbColumnUpdateRecordVo> selectVoPage(Page<DrapDbColumnUpdateRecordVo> page, Map<String, Object> paramMap);

    DrapDbColumnUpdateRecordVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbColumnUpdateRecord entity);

    int baseUpdate(DrapDbColumnUpdateRecord entity);

    int baseDelete(String id);
}