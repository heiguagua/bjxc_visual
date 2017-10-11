package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDictCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictCategoryVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.service.system.ISysDictCategoryService;
import com.chinawiserv.dsp.base.service.system.ISysDictIcon;
import com.chinawiserv.dsp.base.service.system.ISysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Controller
@RequestMapping("/sysDict")
//todo 将所有的XXX修改为真实值
public class SysDictController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDictService service;
    
    @Autowired
    private ISysDictIcon service2;

    @Autowired
    private ISysDictCategoryService service3;

//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "system/dataDict/dataDictList";
    }

    /**
     * 字典明细管理
     */

    /**
     * 分页查询系统字典表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/detailsList")
    @ResponseBody
    public PageResult detailsList(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<SysDictVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询系统字典明细表出错");
		    logger.error("分页查询系统字典明细表出错", e);
		}
		return pageResult;
    }

    /**
     * 查询所有字典的数据，并转换成下拉框接受的数据格式
     */
    @RequestMapping("/dictDataForSelect")
    @ResponseBody
    public HandleResult getDictDataForSelect(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String, Map<String, SysDictVo>> dictData = service.getDictDataForSelect(paramMap);
            handleResult.put("vo",dictData);
        } catch (Exception e) {
            handleResult.error("查询系统字典表出错");
            logger.error("查询系统字典表出错", e);
        }
        return handleResult;
    }
        
    /**
     * 查询所有字典的数据，并转换成下拉框接受的数据格式
     */
    @RequestMapping("/dictIcon")
    @ResponseBody
    public HandleResult getDictIconForSelect(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String, Map<String, SysIconVo>> dictData = service2.getDictIconForSelect(paramMap);
            handleResult.put("vo",dictData);
        } catch (Exception e) {
            handleResult.error("查询Icon字典表出错");
            logger.error("查询Icon字典表出错", e);
        }
        return handleResult;
    }
    /**
     * 新增系统字典明细表
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/detailAdd")
    public  String add(){
		return "system/dataDict/dataDictDetailAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建系统字典明细表")
    @RequestMapping("/detailDoAdd")
    @ResponseBody
    public HandleResult detailDoAdd(SysDictVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建系统字典明细表成功");
		} catch (Exception e) {
		    handleResult.error("创建系统字典明细表失败");
		    logger.error("创建系统字典明细表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除系统字典明细表
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除系统字典明细表")
    @RequestMapping("/detailDelete")
    @ResponseBody
    public HandleResult detailDelete(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try{
            if (service.deleteDictById(id)){
                handleResult.success("删除系统字典明细表成功");
            }
        }catch (Exception e){
            handleResult.error("删除系统字典明细表失败");
            logger.error("删除系统字典明细表失败+" + id, e);
        }

		return handleResult;
    }

    /**
     * 编辑系统字典明细表
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/detailEdit")
    public  String detailEdit(@RequestParam String id,Model model){
		model.addAttribute("dictId",id);
		return "system/dataDict/dataDictDetailEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping(value = "/detailEditLoad",method = RequestMethod.GET)
    @ResponseBody
    public  HandleResult detailEditLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            SysDictVo vo = service.selectVoDetailById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取系统字典明细表信息失败");
		    logger.error("获取系统字典明细表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑系统字典明细表")
    @RequestMapping("/detailDoEdit")
    @ResponseBody
    public  HandleResult detailDoEdit(SysDictVo entity, Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateDetailVO(entity);
		    handleResult.success("编辑系统字典明细表成功");
		} catch (Exception e) {
		    handleResult.error("编辑系统字典明细表失败");
		    logger.error("编辑系统字典明细表失败", e);
		}
		return handleResult;
    }


    /**
     * 分页查询系统字典表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult List(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<SysDictCategoryVo> page = service3.selectCategoryVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询系统字典表出错");
            logger.error("分页查询系统字典表出错", e);
        }
        return pageResult;
    }


    /**
     * 新增系统字典表
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String Add(){
        return "system/dataDict/dataDictAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建系统字典表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysDictCategoryVo entity){
        HandleResult handleResult = new HandleResult();
        try {
            service3.insertVO(entity);
            handleResult.success("创建系统字典表成功");
        } catch (Exception e) {
            handleResult.error("创建系统字典表失败");
            logger.error("创建系统字典表失败", e);
        }
        return handleResult;
    }

    /**
     * 删除系统字典表
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除系统字典表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try{
            service3.deleteByCategoryCode(paramMap);
            handleResult.success("删除系统字典表成功");
        }catch (Exception e) {
            handleResult.error("删除系统字典表失败");
            logger.error("删除系统字典表失败", e);
        }

        return handleResult;
    }

    /**
     * 编辑系统字典表
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String Edit(@RequestParam String id,Model model){
        model.addAttribute("categoryId",id);
        return "system/dataDict/dataDictEdit";
    }

    //    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping(value = "/editLoad",method = RequestMethod.GET)
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysDictCategoryVo vo = service3.selectVoById(id);
            handleResult.put("vo", vo);
        } catch (Exception e) {
            handleResult.error("获取系统字典表信息失败");
            logger.error("获取系统字典表信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑系统字典表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysDictCategoryVo entity, Model model){
        HandleResult handleResult = new HandleResult();
        try {
            service3.updateCategoryVO(entity);
            handleResult.success("编辑系统字典表成功");
        } catch (Exception e) {
            handleResult.error("编辑系统字典表失败");
            logger.error("编辑系统字典表失败", e);
        }
        return handleResult;
    }
}
