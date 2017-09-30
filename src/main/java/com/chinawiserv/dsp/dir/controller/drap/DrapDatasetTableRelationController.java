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

import com.alibaba.fastjson.JSONArray;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetTableRelationService;

/**
 * <p>
 * 信息资源梳理表关系记录表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drap/relation")
//todo 将所有的XXX修改为真实值
public class DrapDatasetTableRelationController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapDatasetTableRelationService service;

    /**
     * 执行新增
     */
    @Log("创建信息资源梳理表关系记录表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(@RequestParam Map<String,Object> paramMap){
		HandleResult handleResult = new HandleResult();
		try {
            Object obj = paramMap.get("data");
            if (obj instanceof String)
            {
            	List<DrapDatasetVo> datasetLst = JSONArray.parseArray((String)obj, DrapDatasetVo.class);
            	service.insertTableRelation(datasetLst);
            }
			logger.info(paramMap.toString());
			handleResult.success("创建信息资源梳理表关系记录表成功");
		} catch (Exception e) {
		    handleResult.error("创建信息资源梳理表关系记录表失败");
		    logger.error("创建信息资源梳理表关系记录表失败", e);
		}
		return handleResult;
    }
}
