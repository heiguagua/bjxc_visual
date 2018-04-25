package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuTemplate;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuTemplateVo;
import com.chinawiserv.dsp.vm.mapper.ChartMenuTemplateMapper;
import com.chinawiserv.dsp.vm.service.IChartMenuTemplateService;

/**
 * <p>
 * 图表与菜单关系模板表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartMenuTemplateServiceImpl extends CommonServiceImpl<ChartMenuTemplateMapper, ChartMenuTemplate, ChartMenuTemplateVo> implements IChartMenuTemplateService {

	@Autowired
	private ChartMenuTemplateMapper mapper;

	@Override
	public boolean insertVO(ChartMenuTemplateVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartMenuTemplateVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartMenuTemplateVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ChartMenuTemplateVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
