package com.chinawiserv.dsp.quota.controller;

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
import com.chinawiserv.dsp.quota.service.IIndictorService;

/**
 * <p>
 * 指标表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/indictor")
// todo 将所有的XXX修改为真实值
public class IndictorController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IIndictorService service;

	/**
	 * 查询系统指标数据
	 */
	@Log("查询系统指标数据")
	@RequestMapping("/getIndictorDataByChartId")
	@ResponseBody
	public HandleResult getIndictorDataByChartId(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			handleResult = service.getIndictorData(paramMap);
		} catch (Exception e) {
			handleResult.error("删除当前系统图表配置表失败");
			logger.error("删除当前系统图表配置表失败", e);
		}
		return handleResult;
	}
}
