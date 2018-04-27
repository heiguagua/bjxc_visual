package com.chinawiserv.dsp.quota.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorDataSource;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataSourceVo;
import com.chinawiserv.dsp.quota.mapper.IndictorDataSourceMapper;
import com.chinawiserv.dsp.quota.service.IIndictorDataSourceService;

/**
 * <p>
 * 指标数据来源表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Service
public class IndictorDataSourceServiceImpl extends CommonServiceImpl<IndictorDataSourceMapper, IndictorDataSource, IndictorDataSourceVo> implements IIndictorDataSourceService {

	@Autowired
	private IndictorDataSourceMapper mapper;

	@Override
	public boolean insertVO(IndictorDataSourceVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorDataSourceVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorDataSourceVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorDataSourceVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
