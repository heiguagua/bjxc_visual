package com.chinawiserv.dsp.dir.controller.catalog;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;
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
 * 数据集（信息资源） 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/catalog")
public class DirDatasetController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDatasetService service;

    @RequestMapping("/catalogue")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "catalog/catalogue/catalogueList";
    }

    /**
     * 分页查询数据集（信息资源）
     */
    @RequiresPermissions("catalog:catalogue:list")
    @RequestMapping("/catalogue/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirDatasetVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询数据集（信息资源）出错");
		    logger.error("分页查询数据集（信息资源）出错", e);
		}
		return pageResult;
    }

    /**
     * 新增数据集（信息资源）
     */
    @RequiresPermissions("catalog:catalogue:add")
    @RequestMapping("/catalogue/add")
    public  String add(){
		return "catalog/catalogue/catalogueAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("XXX:XXX:add")
    @Log("创建数据集（信息资源）")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDatasetVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建数据集（信息资源）成功");
		} catch (Exception e) {
		    handleResult.error("创建数据集（信息资源）失败");
		    logger.error("创建数据集（信息资源）失败", e);
		}
		return handleResult;
    }

    /**
     * 删除数据集（信息资源）
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除数据集（信息资源）")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除数据集（信息资源）成功");
    }

    /**
     * 编辑数据集（信息资源）
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
            DirDatasetVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据集（信息资源）信息失败");
		    logger.error("获取数据集（信息资源）信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑数据集（信息资源）")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDatasetVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑数据集（信息资源）成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据集（信息资源）失败");
		    logger.error("编辑数据集（信息资源）失败", e);
		}
		return handleResult;
    }
}
