package com.chinawiserv.dsp.vm.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartDescIndictorMap;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescIndictorMapVo;

/**
 * <p>
 * 图表描述与指标关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartDescIndictorMapMapper extends BaseMapper<ChartDescIndictorMap> {

	List<ChartDescIndictorMapVo> selectVoPage(Page<ChartDescIndictorMapVo> page, Map<String, Object> paramMap);

	ChartDescIndictorMapVo selectVoById(String id);

	int selectVoCount(Map<String, Object> paramMap);

	int baseInsert(ChartDescIndictorMap entity);

	int baseUpdate(ChartDescIndictorMap entity);

	int baseDelete(String id);

	/**
	 * 根据图标id删除图表信息
	 * 
	 * @param chartId
	 * @return
	 */
	int deleteByChartId(String chartId);
}
