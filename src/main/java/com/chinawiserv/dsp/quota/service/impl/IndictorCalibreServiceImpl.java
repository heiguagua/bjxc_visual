package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorCalibre;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCalibreVo;
import com.chinawiserv.dsp.quota.mapper.IndictorCalibreMapper;
import com.chinawiserv.dsp.quota.service.IIndictorCalibreService;

/**
 * <p>
 * 指标统计口径 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorCalibreServiceImpl extends CommonServiceImpl<IndictorCalibreMapper, IndictorCalibre, IndictorCalibreVo> implements IIndictorCalibreService {

	@Autowired
	private IndictorCalibreMapper mapper;

	@Override
	public boolean insertVO(IndictorCalibreVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorCalibreVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorCalibreVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorCalibreVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
