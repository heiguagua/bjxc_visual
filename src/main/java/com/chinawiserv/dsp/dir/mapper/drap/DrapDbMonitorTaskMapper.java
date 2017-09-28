package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbMonitorTask;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbMonitorTaskVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库监控任务表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbMonitorTaskMapper extends BaseMapper<DrapDbMonitorTask> {

    List<DrapDbMonitorTaskVo> selectVoPage(Page<DrapDbMonitorTaskVo> page, Map<String, Object> paramMap);

    DrapDbMonitorTaskVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbMonitorTask entity);

    int baseUpdate(DrapDbMonitorTask entity);

    int baseDelete(String id);
}