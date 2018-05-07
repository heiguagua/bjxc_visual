package com.chinawiserv.dsp.vm.service;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuTemplate;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuTemplateVo;

/**
 * <p>
 * 图表与菜单关系模板表 服务类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface IChartMenuTemplateService extends ICommonService<ChartMenuTemplate, ChartMenuTemplateVo> {
	/**
	 * 查询模板图标
	 * 
	 * @return
	 * @throws Exception
	 */
	public HandleResult selectChartTemplateList() throws Exception;

}
