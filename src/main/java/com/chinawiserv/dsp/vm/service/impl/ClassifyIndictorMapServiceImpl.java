package com.chinawiserv.dsp.vm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ClassifyIndictorMap;
import com.chinawiserv.dsp.vm.entity.vo.ClassifyIndictorMapVo;
import com.chinawiserv.dsp.vm.mapper.ClassifyIndictorMapMapper;
import com.chinawiserv.dsp.vm.service.IClassifyIndictorMapService;

/**
 * <p>
 * 图表分类与指标关系表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ClassifyIndictorMapServiceImpl extends CommonServiceImpl<ClassifyIndictorMapMapper, ClassifyIndictorMap, ClassifyIndictorMapVo> implements IClassifyIndictorMapService {

	@Autowired
	private ClassifyIndictorMapMapper mapper;

	@Override
	public boolean insertVO(ClassifyIndictorMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ClassifyIndictorMapVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ClassifyIndictorMapVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<ClassifyIndictorMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}
}
