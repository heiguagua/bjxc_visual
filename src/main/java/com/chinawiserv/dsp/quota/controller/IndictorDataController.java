package com.chinawiserv.dsp.quota.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.quota.service.IIndictorDataService;

/**
 * <p>
 * 指标数据表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/indictorData")
// todo 将所有的XXX修改为真实值
public class IndictorDataController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IIndictorDataService service;

	@RequiresPermissions("XXX:XXX:list")
	@RequestMapping("")
	public String init(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "XXX/XXX/XXXList";
	}

}
