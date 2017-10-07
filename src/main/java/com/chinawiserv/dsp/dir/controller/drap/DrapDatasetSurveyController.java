package com.chinawiserv.dsp.dir.controller.drap;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetSurveyVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetSurveyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 梳理信息资源大普查信息表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
@Controller
@RequestMapping("/drapDatasetSurvey")
//todo 将所有的XXX修改为真实值
public class DrapDatasetSurveyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapDatasetSurveyService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询梳理信息资源大普查信息表
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapDatasetSurveyVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询梳理信息资源大普查信息表出错");
		    logger.error("分页查询梳理信息资源大普查信息表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增梳理信息资源大普查信息表
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
    @Log("创建梳理信息资源大普查信息表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapDatasetSurveyVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建梳理信息资源大普查信息表成功");
		} catch (Exception e) {
		    handleResult.error("创建梳理信息资源大普查信息表失败");
		    logger.error("创建梳理信息资源大普查信息表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除梳理信息资源大普查信息表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除梳理信息资源大普查信息表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除梳理信息资源大普查信息表成功");
    }

    /**
     * 编辑梳理信息资源大普查信息表
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
            DrapDatasetSurveyVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取梳理信息资源大普查信息表信息失败");
		    logger.error("获取梳理信息资源大普查信息表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑梳理信息资源大普查信息表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapDatasetSurveyVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑梳理信息资源大普查信息表成功");
		} catch (Exception e) {
		    handleResult.error("编辑梳理信息资源大普查信息表失败");
		    logger.error("编辑梳理信息资源大普查信息表失败", e);
		}
		return handleResult;
    }
}
