package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuCustom;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuCustomVo;
import com.chinawiserv.dsp.vm.mapper.ChartMenuCustomMapper;
import com.chinawiserv.dsp.vm.service.IChartMenuCustomService;

/**
 * <p>
 * 图表与菜单自定义关系 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartMenuCustomServiceImpl extends CommonServiceImpl<ChartMenuCustomMapper, ChartMenuCustom, ChartMenuCustomVo> implements IChartMenuCustomService {

	@Autowired
	private ChartMenuCustomMapper mapper;

	@Override
	public boolean insertVO(ChartMenuCustomVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartMenuCustomVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartMenuCustomVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartMenuCustomVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
