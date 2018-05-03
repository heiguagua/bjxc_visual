package com.chinawiserv.dsp.quota.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryVo;
import com.chinawiserv.dsp.quota.entity.vo.IndictorVo;
import com.chinawiserv.dsp.quota.mapper.IndictorCategoryMapper;
import com.chinawiserv.dsp.quota.mapper.IndictorMapper;
import com.chinawiserv.dsp.quota.service.IIndictorCategoryService;

/**
 * <p>
 * 指标分类表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
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

	@Autowired
	private IndictorMapper indictorMapper;

	@Override
	public HandleResult selectSubVoList(Map<String, Object> paramMap) throws Exception {
		HandleResult handleResult = new HandleResult();
		List<IndictorCategoryVo> resultVos = new ArrayList<>();
		List<IndictorCategoryVo> indictorCategoryVos = mapper.selectSubVoList(paramMap);

		for (IndictorCategoryVo vo : indictorCategoryVos) {
			resultVos.add(vo);
			List<IndictorVo> indictorVos = indictorMapper.selectByCategoryId(vo.getId());
			for (IndictorVo indictorVo : indictorVos) {
				IndictorCategoryVo indictorCategoryVo = new IndictorCategoryVo();
				indictorCategoryVo.setCode(indictorVo.getCode());
				indictorCategoryVo.setSelectable(indictorVo.getSelectable());
				indictorCategoryVo.setName(indictorVo.getName());
				resultVos.add(indictorCategoryVo);
			}
		}
		handleResult.put("data", resultVos);
		return handleResult;
	}
}
