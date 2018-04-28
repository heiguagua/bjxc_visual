package com.chinawiserv.dsp.quota.service;

import java.util.Map;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.quota.entity.po.IndictorCategory;
import com.chinawiserv.dsp.quota.entity.vo.IndictorCategoryVo;

/**
 * <p>
 * 指标分类表 服务类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IIndictorCategoryService extends ICommonService<IndictorCategory, IndictorCategoryVo> {

	/**
	 * 根据fid查询指标分类树
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	HandleResult selectSubVoList(Map<String, Object> paramMap) throws Exception;

}
