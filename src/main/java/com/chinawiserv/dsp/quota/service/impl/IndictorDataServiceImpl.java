package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorData;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataVo;
import com.chinawiserv.dsp.quota.mapper.IndictorDataMapper;
import com.chinawiserv.dsp.quota.service.IIndictorDataService;

/**
 * <p>
 * 指标数据表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@Service
public class IndictorDataServiceImpl extends CommonServiceImpl<IndictorDataMapper, IndictorData, IndictorDataVo> implements IIndictorDataService {

	@Autowired
	private IndictorDataMapper mapper;

	@Override
	public boolean insertVO(IndictorDataVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorDataVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorDataVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorDataVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
