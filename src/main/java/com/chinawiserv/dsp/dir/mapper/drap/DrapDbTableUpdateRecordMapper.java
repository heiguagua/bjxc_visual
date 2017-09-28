package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableUpdateRecord;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableUpdateRecordVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库表更新记录表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbTableUpdateRecordMapper extends BaseMapper<DrapDbTableUpdateRecord> {

    List<DrapDbTableUpdateRecordVo> selectVoPage(Page<DrapDbTableUpdateRecordVo> page, Map<String, Object> paramMap);

    DrapDbTableUpdateRecordVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbTableUpdateRecord entity);

    int baseUpdate(DrapDbTableUpdateRecord entity);

    int baseDelete(String id);
}