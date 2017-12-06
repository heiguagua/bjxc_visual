package com.chinawiserv.dsp.dir.controller.drap;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessActivityVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessActivityService;
import com.google.common.collect.Maps;

import org.apache.commons.collections.MapUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 业务活动表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drap/drapBusinessActivity")
//todo 将所有的XXX修改为真实值
public class DrapBusinessActivityController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapBusinessActivityService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询业务活动表
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapBusinessActivityVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询业务活动表出错");
		    logger.error("分页查询业务活动表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增业务活动表
     */
    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "XXX/XXX/XXXAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("XXX:XXX:add")
    @Log("创建业务活动表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapBusinessActivityVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建业务活动表成功");
		} catch (Exception e) {
		    handleResult.error("创建业务活动表失败");
		    logger.error("创建业务活动表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除业务活动表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除业务活动表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除业务活动表成功");
    }

    /**
     * 编辑业务活动表
     */
    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "XXX/XXX/XXXEdit";
    }

    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DrapBusinessActivityVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取业务活动表信息失败");
		    logger.error("获取业务活动表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑业务活动表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapBusinessActivityVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑业务活动表成功");
		} catch (Exception e) {
		    handleResult.error("编辑业务活动表失败");
		    logger.error("编辑业务活动表失败", e);
		}
		return handleResult;
    }
    
    /**
     * 接收drap的业务数据
     */
//    @RequiresPermissions("XXX:XXX:edit")
//    @Log("接收drap的业务数据")
    @RequestMapping("/api/receiveBusinessData")
    @ResponseBody
    public  Object receiveBusinessData(@RequestParam Map<String,Object> paramMap){
//    	HashMap<String, Object> result = Maps.newHashMap();
    	try {
    		if(paramMap !=null && !paramMap.isEmpty()){
    			String data = MapUtils.getString(paramMap, "data");
    			Map<String, Object> dataObj = (Map<String, Object>)JSONObject.parse(data);
    			this.service.updateBusinessData(dataObj);
    		}
//    		result.put("status", "200");
    		return "200";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("接收drap的业务数据", e);
//			result.put("status", "500");
			return "500";
		}
//    	return result;
    }
}
