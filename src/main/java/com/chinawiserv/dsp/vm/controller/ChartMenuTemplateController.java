package com.chinawiserv.dsp.vm.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
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

	@RequestMapping("/index")
	public String init(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "vm/indexForCharTemplet";
	}

	/**
	 * 查询默认模板哪些图表
	 */
	// @RequiresPermissions("XXX:XXX:list")
	@RequestMapping("/templateList")
	@ResponseBody
	public HandleResult templateList(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			// String menuId = paramMap.getOrDefault("menuId", "").toString();
			handleResult = service.selectChartTemplateList();
		} catch (Exception e) {
			handleResult.error("查询模板图表列表失败");
			logger.error("查询模板图表列表失败", e);
		}
		return handleResult;
	}
}
