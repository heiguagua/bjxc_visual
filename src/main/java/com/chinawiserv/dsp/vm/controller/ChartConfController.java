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
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.vm.service.IChartConfService;

/**
 * <p>
 * 系统图表配置表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartConf")
// todo 将所有的XXX修改为真实值
public class ChartConfController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartConfService service;

	/**
	 * 执行新增图表
	 */
	// @RequiresPermissions("XXX:XXX:add")
	@Log("创建系统图表配置表")
	@RequestMapping("/addUsersChart")
	@ResponseBody
	public HandleResult doAddUsersChart(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			if (service.insertUsersChart(paramMap))
				// todo 保存成功后查询该条数据
				handleResult.success("创建系统图表配置表成功");
			else
				handleResult.error("创建系统图表配置表失败");
		} catch (Exception e) {
			handleResult.error("创建系统图表配置表失败");
			logger.error("创建系统图表配置表失败", e);
		}
		return handleResult;
	}

	/**
	 * 加载图表配置信息
	 */
	// @RequiresPermissions("XXX:XXX:add")
	@Log("加载图表配置信息")
	@RequestMapping("/loadChartDetail")
	@ResponseBody
	public HandleResult loadChartDetail(@RequestParam Map<String, Object> paramMap, String id) {
		HandleResult handleResult = new HandleResult();
		try {
			handleResult.put("data", service.selectVoById(id));
			handleResult.success("查询当前系统图表配置表成功");

		} catch (Exception e) {
			handleResult.error("查询当前系统图表配置表失败");
			logger.error("查询当前系统图表配置表失败", e);
		}
		return handleResult;
	}

	/**
	 * 编辑用户图表
	 */
	// @RequiresPermissions("XXX:XXX:add")
	@Log("编辑系统图表配置表")
	@RequestMapping("/editUsersChart")
	@ResponseBody
	public HandleResult editUsersChart(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			if (service.editUsersChart(paramMap))
				handleResult.success("编辑系统图表配置表成功");
			else
				handleResult.error("编辑系统图表配置表失败");
		} catch (Exception e) {
			handleResult.error("编辑系统图表配置表失败");
			logger.error("编辑系统图表配置表失败", e);
		}
		return handleResult;
	}

	/**
	 * 删除系统图表配置表
	 */
	// @RequiresPermissions("XXX:XXX:delete")
	@Log("删除系统图表配置表")
	@RequestMapping("/deleteByChartId")
	@ResponseBody
	public HandleResult deleteByChartId(@RequestParam String id) {
		HandleResult handleResult = new HandleResult();
		try {
			if (service.deleteChartConfigById(id))

				handleResult.success("删除当前系统图表配置表成功");
			else
				handleResult.error("删除当前系统图表配置表失败");
			// service.deleteById(id);
		} catch (Exception e) {
			handleResult.error("删除当前系统图表配置表失败");
			logger.error("删除当前系统图表配置表失败", e);
		}
		return handleResult;
	}

}
