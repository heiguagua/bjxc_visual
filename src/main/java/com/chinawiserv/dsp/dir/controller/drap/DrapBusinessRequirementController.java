package com.chinawiserv.dsp.dir.controller.drap;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.dir.service.api.IApiService;
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
    @Autowired
    private IApiService service1;
	/**
	 * 同步需求
	 * 
	 * @param voLst
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insert")
	public Object insertRequirement(@RequestParam Map<String,Object> paramMap) {
		HandleResult result = new HandleResult();
		Object obj = paramMap.get("data");

		List<DrapBusinessRequirementVo> voLst = null;
		if (obj instanceof String)
		{
			voLst = JSONArray.parseArray((String)obj, DrapBusinessRequirementVo.class);
		}
		try {
			if (voLst == null || voLst.isEmpty()) {
				result.error("待同步数据数据为空。");
			}
			service.insertBusinessRequirement(voLst);
		} catch (Exception e) {
			logger.error("同步需求异常。", e.toString());
		}
		return result;
	}
	

    /**
     * 推送用户数据的接口
     * */
    @RequestMapping("syncUserData")
    @ResponseBody
    public HandleResult syncUserData(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysUser> result = service1.syncUserData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }
}
