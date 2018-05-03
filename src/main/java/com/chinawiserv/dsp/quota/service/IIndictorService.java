package com.chinawiserv.dsp.quota.service;

import java.util.Map;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.quota.entity.po.Indictor;
import com.chinawiserv.dsp.quota.entity.vo.IndictorVo;

/**
 * <p>
 * 指标表 服务类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IIndictorService extends ICommonService<Indictor, IndictorVo> {
	/**
	 * 根据图表条件查询指标数据
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	HandleResult getIndictorData(Map<String, Object> paramMap) throws Exception;

}
