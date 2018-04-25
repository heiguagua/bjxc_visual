package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartConf;
import com.chinawiserv.dsp.vm.entity.vo.ChartConfVo;
import com.chinawiserv.dsp.vm.mapper.ChartConfMapper;
import com.chinawiserv.dsp.vm.service.IChartConfService;

/**
 * <p>
 * 系统图表配置表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartConfServiceImpl extends CommonServiceImpl<ChartConfMapper, ChartConf, ChartConfVo> implements IChartConfService {

	@Autowired
	private ChartConfMapper mapper;

	@Override
	public boolean insertVO(ChartConfVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartConfVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartConfVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartConfVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
