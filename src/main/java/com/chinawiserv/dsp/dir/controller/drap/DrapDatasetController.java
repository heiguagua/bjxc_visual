package com.chinawiserv.dsp.dir.controller.drap;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetService;
import org.apache.commons.collections.MapUtils;
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
 * 信息资源（数据集） 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drap/drapDataset")
//todo 将所有的XXX修改为真实值
public class DrapDatasetController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapDatasetService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询信息资源（数据集）
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapDatasetVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询信息资源（数据集）出错");
		    logger.error("分页查询信息资源（数据集）出错", e);
		}
		return pageResult;
    }

    /**
     * 新增信息资源（数据集）
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
    @Log("创建信息资源（数据集）")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapDatasetVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建信息资源（数据集）成功");
		} catch (Exception e) {
		    handleResult.error("创建信息资源（数据集）失败");
		    logger.error("创建信息资源（数据集）失败", e);
		}
		return handleResult;
    }

    /**
     * 删除信息资源（数据集）
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除信息资源（数据集）")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除信息资源（数据集）成功");
    }

    /**
     * 编辑信息资源（数据集）
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
            DrapDatasetVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取信息资源（数据集）信息失败");
		    logger.error("获取信息资源（数据集）信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑信息资源（数据集）")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapDatasetVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑信息资源（数据集）成功");
		} catch (Exception e) {
		    handleResult.error("编辑信息资源（数据集）失败");
		    logger.error("编辑信息资源（数据集）失败", e);
		}
		return handleResult;
    }

    /**
     * 接收drap的业务数据
     */
    @RequestMapping("/api/receiveDataset")
    @ResponseBody
    public Object receiveDataset(@RequestParam Map<String,Object> paramMap){
        try {
            if(paramMap !=null && !paramMap.isEmpty()){
                String data = MapUtils.getString(paramMap, "data");
                Map<String, Object> dataObj = (Map<String, Object>) JSONObject.parse(data);
                service.insertDataset(dataObj);
                return "200";
            }else{
                return "500";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收梳理的信息资源数据失败", e);
            return "500";
        }
    }
    
    /**
     * 删除drap的业务数据
     */
    @RequestMapping("/api/deleteDataset")
    @ResponseBody
    public Object deleteDataset(@RequestParam Map<String,Object> paramMap){
        try {
            if(paramMap !=null && !paramMap.isEmpty()){
                String data = MapUtils.getString(paramMap, "data");
                Map<String, Object> dataObj = (Map<String, Object>) JSONObject.parse(data);
                service.deleteDataset(dataObj);
                return "200";
            }else{
                return "500";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收梳理的信息资源数据失败", e);
            return "500";
        }
    }
    
}
