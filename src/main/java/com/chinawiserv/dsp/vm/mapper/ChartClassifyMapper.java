package com.chinawiserv.dsp.vm.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartClassify;
import com.chinawiserv.dsp.vm.entity.vo.ChartClassifyVo;

/**
 * <p>
 * 图表分类信息 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartClassifyMapper extends BaseMapper<ChartClassify> {

	List<ChartClassifyVo> selectVoPage(Page<ChartClassifyVo> page, Map<String, Object> paramMap);

	ChartClassifyVo selectVoById(String id);

	int selectVoCount(Map<String, Object> paramMap);

	int baseInsert(ChartClassify entity);

	int baseUpdate(ChartClassify entity);

	int baseDelete(String id);

	// /**
	// * 根据条件查询分类信息 结果集为1
	// *
	// * @param paramMap
	// * @return
	// */
	// ChartClassifyVo selectOneByParams(Map<String, Object> paramMap);

	List<ChartClassifyVo> selectByChartId(String chartId);
}
