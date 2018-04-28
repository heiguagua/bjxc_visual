package com.chinawiserv.dsp.quota.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryVo;

/**
 * <p>
 * 指标分类表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorCategoryMapper extends BaseMapper<IndictorCategory> {

	List<IndictorCategoryVo> selectVoPage(Page<IndictorCategoryVo> page, Map<String, Object> paramMap);

	IndictorCategoryVo selectVoById(String id);

	int selectVoCount(Map<String, Object> paramMap);

	int baseInsert(IndictorCategory entity);

	int baseUpdate(IndictorCategory entity);

	int baseDelete(String id);

	/**
	 * 查询分类指标树
	 * 
	 * @param paramMap
	 * @return
	 */
	List<IndictorCategoryVo> selectSubVoList(Map<String, Object> paramMap);
}
