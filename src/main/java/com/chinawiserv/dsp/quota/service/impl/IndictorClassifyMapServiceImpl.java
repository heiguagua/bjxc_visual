package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorClassifyMap;
import com.chinawiserv.dsp.quota.entity.vo.IndictorClassifyMapVo;
import com.chinawiserv.dsp.quota.mapper.IndictorClassifyMapMapper;
import com.chinawiserv.dsp.quota.service.IIndictorClassifyMapService;

/**
 * <p>
 * 指标分类方式关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Service
public class IndictorClassifyMapServiceImpl extends CommonServiceImpl<IndictorClassifyMapMapper, IndictorClassifyMap, IndictorClassifyMapVo> implements IIndictorClassifyMapService {

	@Autowired
	private IndictorClassifyMapMapper mapper;

	@Override
	public boolean insertVO(IndictorClassifyMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorClassifyMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorClassifyMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorClassifyMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
