package com.chinawiserv.dsp.vm.service;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuCustom;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuCustomVo;

/**
 * <p>
 * 图表与菜单自定义关系 服务类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface IChartMenuCustomService extends ICommonService<ChartMenuCustom, ChartMenuCustomVo> {

	/**
	 * 根据菜单Id 用户Id 查询 当前页的图表信息
	 * 
	 * @param menuId
	 * @return
	 * @throws Exception
	 */
	public HandleResult selectChartListByUserAndMenu(String menuId) throws Exception;

	/**
	 * 更新图标位置信息
	 * 
	 * @param locationStr
	 * @return
	 * @throws Exception
	 */
	public boolean updateChartLocation(String locationStr) throws Exception;

}
