package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.Indictor;
import com.chinawiserv.dsp.quota.entity.vo.IndictorVo;
import com.chinawiserv.dsp.quota.mapper.IndictorMapper;
import com.chinawiserv.dsp.quota.service.IIndictorService;

/**
 * <p>
 * 指标表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorServiceImpl extends CommonServiceImpl<IndictorMapper, Indictor, IndictorVo> implements IIndictorService {

	@Autowired
	private IndictorMapper mapper;

	@Override
	public boolean insertVO(IndictorVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
