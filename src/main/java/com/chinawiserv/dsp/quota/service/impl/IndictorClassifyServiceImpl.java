package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorClassify;
import com.chinawiserv.dsp.quota.entity.vo.IndictorClassifyVo;
import com.chinawiserv.dsp.quota.mapper.IndictorClassifyMapper;
import com.chinawiserv.dsp.quota.service.IIndictorClassifyService;

/**
 * <p>
 * 指标分类方式 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Service
public class IndictorClassifyServiceImpl extends CommonServiceImpl<IndictorClassifyMapper, IndictorClassify, IndictorClassifyVo> implements IIndictorClassifyService {

	@Autowired
	private IndictorClassifyMapper mapper;

	@Override
	public boolean insertVO(IndictorClassifyVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorClassifyVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorClassifyVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorClassifyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
