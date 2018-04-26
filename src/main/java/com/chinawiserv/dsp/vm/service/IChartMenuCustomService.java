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

	public HandleResult selectChartListByUserAndMenu(String menuId) throws Exception;

}
