package com.chinawiserv.dsp.dir.controller.drap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.dir.entity.vo.drap.AuditEntity;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * @param paramMap
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
		result = service.insertBusinessRequirement(voLst);
		} catch (Exception e) {
			logger.error("同步需求异常。", e.toString());
		}
		return result;
	}

	/**
	 * 同步需求
	 *
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete")
	public Object deleteRequirement(@RequestParam Map<String,Object> paramMap) {
		HandleResult result = new HandleResult();
		Object obj = paramMap.get("data");

		Map<String,List<String>> deleteMap = null;
		if (obj instanceof String)
		{
			deleteMap = (Map<String, List<String>>) JSONObject.parse((String)obj);
		}
		try {
			if (deleteMap == null || deleteMap.isEmpty()) {
				result.error("待删除数据为空。");
			}
			result = service.deleteBusinessRequirement(deleteMap);
		} catch (Exception e) {
			logger.error("需求删除异常。", e.toString());
		}
		return result;
	}

	/**
	 * 同步需求
	 *
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateRequirementStatus")
	public Object updateRequirementStatus(@RequestParam Map<String,Object> paramMap) {
		HashMap<String, Object> result = Maps.newHashMap();
		try {
			if(paramMap !=null && !paramMap.isEmpty()){
				String data = MapUtils.getString(paramMap, "data");
				AuditEntity auditEntity = JSONObject.parseObject(data, AuditEntity.class);
				this.service.updateRequirementStatus(auditEntity);
			}
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("接收drap的业务数据", e);
			return 500;
		}
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
