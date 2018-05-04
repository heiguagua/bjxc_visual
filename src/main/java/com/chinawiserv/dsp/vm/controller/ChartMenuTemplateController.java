package com.chinawiserv.dsp.vm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.vm.service.IChartMenuTemplateService;

/**
 * <p>
 * 图表与菜单关系模板表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartMenuTemplate")
// todo 将所有的XXX修改为真实值
public class ChartMenuTemplateController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartMenuTemplateService service;

}
