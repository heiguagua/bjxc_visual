package com.chinawiserv.dsp.vm.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuCustom;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuCustomVo;

/**
 * <p>
 * 图表与菜单自定义关系 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ChartMenuCustomMapper extends BaseMapper<ChartMenuCustom> {

	List<ChartMenuCustomVo> selectVoPage(Page<ChartMenuCustomVo> page, Map<String, Object> paramMap);

	ChartMenuCustomVo selectVoById(String id);

	int selectVoCount(Map<String, Object> paramMap);

	int baseInsert(ChartMenuCustom entity);

	/**
	 * 更新图表基础信息
	 * 
	 * @param chartMenuCustom
	 * @return
	 */
	int baseUpdate(ChartMenuCustom entity);

	int baseDelete(String id);

	/**
	 * 根据用户id.菜单id 查询当前页的图表列表
	 * 
	 * @param paramMap
	 * @return
	 */
	List<ChartMenuCustomVo> selectChartListByUserAndMenu(Map<String, Object> paramMap);

	/**
	 * 根据图标id删除图表信息
	 * 
	 * @param chartId
	 * @return
	 */
	int deleteByChartId(String chartId);

	// /**
	// * 更新图表基础信息
	// *
	// * @param chartMenuCustom
	// * @return
	// */
	// int updateByPo(ChartMenuCustom chartMenuCustom);
}
