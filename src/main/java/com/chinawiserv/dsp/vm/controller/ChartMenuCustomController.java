package com.chinawiserv.dsp.vm.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.vm.service.IChartMenuCustomService;

/**
 * <p>
 * 图表与菜单自定义关系 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartMenuCustom")
// todo 将所有的XXX修改为真实值
public class ChartMenuCustomController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartMenuCustomService service;

	// @RequiresPermissions("XXX:XXX:list")
	@RequestMapping("/index")
	public String init(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "vm/indexForCharTemplet";
	}

	/**
	 * 根据用户、菜单查询 该页有哪些图表
	 */
	// @RequiresPermissions("XXX:XXX:list")
	@RequestMapping("/chartList")
	@ResponseBody
	public HandleResult chartListByUserAndMenu(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			String menuId = ShiroUtils.getSessionAttribute("res").toString();
			handleResult = service.selectChartListByUserAndMenu(menuId);
		} catch (Exception e) {
			handleResult.error("查询当前菜单图表列表失败");
			logger.error("查询当前菜单图表列表失败", e);
		}
		return handleResult;
	}

	// config
	@RequestMapping("/config")
	public String config(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "vm/config";
	}

	/**
	 * 更新图标的位置信息
	 */

	@Log(" 更新图标的位置信息")
	@RequestMapping("/updateChartLocation")
	@ResponseBody
	public HandleResult updateChartLocation(@RequestParam String locationStr) {
		HandleResult handleResult = new HandleResult();
		try {
			if (service.updateChartLocation(locationStr))
				handleResult.success(" 更新图标的位置信息成功");
			else
				handleResult.error(" 更新图标的位置信息失败");
		} catch (Exception e) {
			handleResult.error(" 更新图标的位置信息失败");
			logger.error(" 更新图标的位置信息失败", e);
		}
		return handleResult;
	}

}
