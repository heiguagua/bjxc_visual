package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbUpdateMonitorHistory;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbUpdateMonitorHistoryVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库更新状态监控记录表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbUpdateMonitorHistoryMapper extends BaseMapper<DrapDbUpdateMonitorHistory> {

    List<DrapDbUpdateMonitorHistoryVo> selectVoPage(Page<DrapDbUpdateMonitorHistoryVo> page, Map<String, Object> paramMap);

    DrapDbUpdateMonitorHistoryVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbUpdateMonitorHistory entity);

    int baseUpdate(DrapDbUpdateMonitorHistory entity);

    int baseDelete(String id);
}