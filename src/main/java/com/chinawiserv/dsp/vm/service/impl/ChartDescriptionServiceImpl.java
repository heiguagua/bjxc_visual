package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartDescription;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescriptionVo;
import com.chinawiserv.dsp.vm.mapper.ChartDescriptionMapper;
import com.chinawiserv.dsp.vm.service.IChartDescriptionService;

/**
 * <p>
 * 图表指标描述信息 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartDescriptionServiceImpl extends CommonServiceImpl<ChartDescriptionMapper, ChartDescription, ChartDescriptionVo> implements IChartDescriptionService {

	@Autowired
	private ChartDescriptionMapper mapper;

	@Override
	public boolean insertVO(ChartDescriptionVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartDescriptionVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartDescriptionVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartDescriptionVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
