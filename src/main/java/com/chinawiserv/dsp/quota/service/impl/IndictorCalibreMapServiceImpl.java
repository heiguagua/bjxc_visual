package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorCalibreMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCalibreMapVo;
import com.chinawiserv.dsp.quota.mapper.IndictorCalibreMapMapper;
import com.chinawiserv.dsp.quota.service.IIndictorCalibreMapService;

/**
 * <p>
 * 指标统计口径关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorCalibreMapServiceImpl extends CommonServiceImpl<IndictorCalibreMapMapper, IndictorCalibreMap, IndictorCalibreMapVo> implements IIndictorCalibreMapService {

	@Autowired
	private IndictorCalibreMapMapper mapper;

	@Override
	public boolean insertVO(IndictorCalibreMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorCalibreMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorCalibreMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorCalibreMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
