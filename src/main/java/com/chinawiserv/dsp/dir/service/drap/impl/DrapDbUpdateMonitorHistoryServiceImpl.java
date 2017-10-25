package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbUpdateHistory;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbUpdateMonitorHistoryVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbUpdateMonitorHistoryMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbUpdateMonitorHistoryService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据库更新状态监控记录表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbUpdateMonitorHistoryServiceImpl extends CommonServiceImpl<DrapDbUpdateMonitorHistoryMapper, DrapDbUpdateHistory , DrapDbUpdateMonitorHistoryVo> implements IDrapDbUpdateMonitorHistoryService {

    @Autowired
    private DrapDbUpdateMonitorHistoryMapper mapper;


    @Override
    public boolean insertVO(DrapDbUpdateMonitorHistoryVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbUpdateMonitorHistoryVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbUpdateMonitorHistoryVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbUpdateMonitorHistoryVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
