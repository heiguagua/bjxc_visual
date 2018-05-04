package com.chinawiserv.dsp.vm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.vm.service.IChartDescriptionService;

/**
 * <p>
 * 图表指标描述信息 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartDescription")
// todo 将所有的XXX修改为真实值
public class ChartDescriptionController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartDescriptionService service;

}
