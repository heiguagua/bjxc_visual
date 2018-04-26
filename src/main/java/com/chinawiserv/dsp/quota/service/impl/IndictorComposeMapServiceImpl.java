package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorComposeMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorComposeMapVo;
import com.chinawiserv.dsp.quota.mapper.IndictorComposeMapMapper;
import com.chinawiserv.dsp.quota.service.IIndictorComposeMapService;

/**
 * <p>
 * 统计指标来源指标关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorComposeMapServiceImpl extends CommonServiceImpl<IndictorComposeMapMapper, IndictorComposeMap, IndictorComposeMapVo> implements IIndictorComposeMapService {

	@Autowired
	private IndictorComposeMapMapper mapper;

	@Override
	public boolean insertVO(IndictorComposeMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorComposeMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorComposeMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorComposeMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
