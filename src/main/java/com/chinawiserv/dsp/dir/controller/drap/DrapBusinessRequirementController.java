package com.chinawiserv.dsp.dir.controller.drap;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessRequirementService;

/**
 * <p>
 * 业务资源需求表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drap/requirement/")
public class DrapBusinessRequirementController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapBusinessRequirementService service;

    /**
	 * 同步需求
	 * @param voLst
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insert")
	public Object insertRequirement(List<DrapBusinessRequirementVo> voLst)
	{
		HandleResult result = new HandleResult();
		try {
			if (voLst == null || voLst.isEmpty())
			{
				result.error("待同步数据数据为空。");
			}
			service.insertBusinessRequirement(voLst);
		} catch (Exception e) {
			logger.error("同步需求异常。",e.toString());
		}
		return result;
	}
}
