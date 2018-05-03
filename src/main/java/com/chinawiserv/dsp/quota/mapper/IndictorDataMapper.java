package com.chinawiserv.dsp.quota.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.quota.entity.po.IndictorData;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataVo;

/**
 * <p>
 * 指标数据表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
public interface IndictorDataMapper extends BaseMapper<IndictorData> {
	//
	// List<IndictorDataVo> selectVoPage(Page<IndictorDataVo> page, Map<String,
	// Object> paramMap);
	//
	// IndictorDataVo selectVoById(String id);
	//
	// int selectVoCount(Map<String, Object> paramMap);
	//
	// int baseInsert(IndictorData entity);
	//
	// int baseUpdate(IndictorData entity);
	//
	// int baseDelete(String id);

	/**
	 * 根据指标id查询数据 sum数据
	 * 
	 * @param paramMap
	 * @return
	 */
	IndictorDataVo selectSumReportDateByMap(Map<String, Object> paramMap);
}
