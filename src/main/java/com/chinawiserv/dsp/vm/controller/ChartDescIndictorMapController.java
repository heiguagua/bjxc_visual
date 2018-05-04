package com.chinawiserv.dsp.vm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.vm.service.IChartDescIndictorMapService;

/**
 * <p>
 * 图表描述与指标关系表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartDescIndictorMap")
// todo 将所有的XXX修改为真实值
public class ChartDescIndictorMapController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartDescIndictorMapService service;

}
