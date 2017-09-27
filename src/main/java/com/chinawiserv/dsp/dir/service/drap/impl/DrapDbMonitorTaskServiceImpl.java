package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbMonitorTask;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbMonitorTaskVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbMonitorTaskMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbMonitorTaskService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据库监控任务表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbMonitorTaskServiceImpl extends CommonServiceImpl<DrapDbMonitorTaskMapper, DrapDbMonitorTask , DrapDbMonitorTaskVo> implements IDrapDbMonitorTaskService {

    @Autowired
    private DrapDbMonitorTaskMapper mapper;


    @Override
    public boolean insertVO(DrapDbMonitorTaskVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbMonitorTaskVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbMonitorTaskVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbMonitorTaskVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
