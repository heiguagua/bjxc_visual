package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbConnectMonitorHistory;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbConnectMonitorHistoryVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库连接状态监控记录表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbConnectMonitorHistoryMapper extends BaseMapper<DrapDbConnectMonitorHistory> {

    List<DrapDbConnectMonitorHistoryVo> selectVoPage(Page<DrapDbConnectMonitorHistoryVo> page, Map<String, Object> paramMap);

    DrapDbConnectMonitorHistoryVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbConnectMonitorHistory entity);

    int baseUpdate(DrapDbConnectMonitorHistory entity);

    int baseDelete(String id);
}