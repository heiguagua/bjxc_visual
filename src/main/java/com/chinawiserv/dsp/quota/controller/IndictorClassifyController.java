package com.chinawiserv.dsp.quota.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.quota.service.IIndictorClassifyService;

/**
 * <p>
 * 指标分类方式 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/indictorClassify")
// todo 将所有的XXX修改为真实值
public class IndictorClassifyController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IIndictorClassifyService service;

}
