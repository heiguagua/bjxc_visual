package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartClassify;
import com.chinawiserv.dsp.vm.entity.vo.ChartClassifyVo;
import com.chinawiserv.dsp.vm.mapper.ChartClassifyMapper;
import com.chinawiserv.dsp.vm.service.IChartClassifyService;

/**
 * <p>
 * 图表分类信息 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartClassifyServiceImpl extends CommonServiceImpl<ChartClassifyMapper, ChartClassify, ChartClassifyVo> implements IChartClassifyService {

	@Autowired
	private ChartClassifyMapper mapper;

	@Override
	public boolean insertVO(ChartClassifyVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartClassifyVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartClassifyVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartClassifyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
