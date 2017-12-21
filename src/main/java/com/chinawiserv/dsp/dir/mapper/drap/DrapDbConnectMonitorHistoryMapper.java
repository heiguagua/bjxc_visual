package com.chinawiserv.dsp.dir.mapper.drap;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbConnectHistory;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbConnectMonitorHistoryVo;


/**
 * <p>
  * 数据库连接状态监控记录表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbConnectMonitorHistoryMapper extends BaseMapper<DrapDbConnectHistory> {

    List<DrapDbConnectMonitorHistoryVo> selectVoPage(Page<DrapDbConnectMonitorHistoryVo> page, Map<String, Object> paramMap);

    DrapDbConnectMonitorHistoryVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbConnectHistory entity);

    int baseUpdate(DrapDbConnectHistory entity);

    int baseDelete(String id);
}