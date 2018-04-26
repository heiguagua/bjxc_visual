package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryVo;
import com.chinawiserv.dsp.quota.mapper.IndictorCategoryMapper;
import com.chinawiserv.dsp.quota.service.IIndictorCategoryService;

/**
 * <p>
 * 指标分类表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorCategoryServiceImpl extends CommonServiceImpl<IndictorCategoryMapper, IndictorCategory, IndictorCategoryVo> implements IIndictorCategoryService {

	@Autowired
	private IndictorCategoryMapper mapper;

	@Override
	public boolean insertVO(IndictorCategoryVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorCategoryVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorCategoryVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorCategoryVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
