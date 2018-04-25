package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartDescIndictorMap;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescIndictorMapVo;
import com.chinawiserv.dsp.vm.mapper.ChartDescIndictorMapMapper;
import com.chinawiserv.dsp.vm.service.IChartDescIndictorMapService;

/**
 * <p>
 * 图表描述与指标关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartDescIndictorMapServiceImpl extends CommonServiceImpl<ChartDescIndictorMapMapper, ChartDescIndictorMap, ChartDescIndictorMapVo> implements IChartDescIndictorMapService {

	@Autowired
	private ChartDescIndictorMapMapper mapper;

	@Override
	public boolean insertVO(ChartDescIndictorMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartDescIndictorMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartDescIndictorMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartDescIndictorMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
