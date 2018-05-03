package com.chinawiserv.dsp.quota.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.quota.service.IIndictorCategoryService;

/**
 * <p>
 * 指标分类表 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/indictorCategory")
// todo 将所有的XXX修改为真实值
public class IndictorCategoryController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IIndictorCategoryService service;

	/**
	 * 查询指标分类树
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("/subCategoryList")
	@ResponseBody
	public HandleResult subCategoryList(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			String fid = (String) paramMap.get("fid");
			if (StringUtils.isEmpty(fid)) {
				paramMap.put("fid", "root");
			}
			handleResult = service.selectSubVoList(paramMap);
		} catch (Exception e) {
			handleResult.error("查询指标分类失败");
			logger.error("查询指标分类失败", e);
		}
		return handleResult;
	}
}
