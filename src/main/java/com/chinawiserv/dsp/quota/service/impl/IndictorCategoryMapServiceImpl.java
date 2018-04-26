package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategoryMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryMapVo;
import com.chinawiserv.dsp.quota.mapper.IndictorCategoryMapMapper;
import com.chinawiserv.dsp.quota.service.IIndictorCategoryMapService;

/**
 * <p>
 * 指标分类关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorCategoryMapServiceImpl extends CommonServiceImpl<IndictorCategoryMapMapper, IndictorCategoryMap, IndictorCategoryMapVo> implements IIndictorCategoryMapService {

	@Autowired
	private IndictorCategoryMapMapper mapper;

	@Override
	public boolean insertVO(IndictorCategoryMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorCategoryMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorCategoryMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorCategoryMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
