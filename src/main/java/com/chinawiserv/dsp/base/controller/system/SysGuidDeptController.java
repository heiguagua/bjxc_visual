package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysGuidDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysGuidDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysGuidDeptService;
import org.apache.commons.lang3.StringUtils;
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
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务指导部门记录表 前端控制器
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
@Controller
@RequestMapping("/sysGuidDept")
public class SysGuidDeptController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysGuidDeptService service;

    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询业务指导部门记录表
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<SysGuidDeptVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询业务指导部门记录表出错");
		    logger.error("分页查询业务指导部门记录表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增业务指导部门记录表
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
    @Log("创建业务指导部门记录表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysGuidDeptVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建业务指导部门记录表成功");
		} catch (Exception e) {
		    handleResult.error("创建业务指导部门记录表失败");
		    logger.error("创建业务指导部门记录表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除业务指导部门记录表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除业务指导部门记录表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除业务指导部门记录表成功");
    }

    /**
     * 编辑业务指导部门记录表
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
            SysGuidDeptVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取业务指导部门记录表信息失败");
		    logger.error("获取业务指导部门记录表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑业务指导部门记录表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysGuidDeptVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑业务指导部门记录表成功");
		} catch (Exception e) {
		    handleResult.error("编辑业务指导部门记录表失败");
		    logger.error("编辑业务指导部门记录表失败", e);
		}
		return handleResult;
    }

    /**
     * 编辑指导部门
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/guid")
    public String guid(@RequestParam String id, Model model){
        model.addAttribute("id", id);
        return "system/dept/guid";
    }

    /**
     * 保存指导部门
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/doGuid")
    @ResponseBody
    public HandleResult doGuid(SysGuidDeptVo sgd){
        HandleResult handleResult = new HandleResult();
        try {
            if(StringUtils.isNotBlank(sgd.getId())){
                service.updateVO(sgd);

            }else{
                service.insertVO(sgd);
            }
            handleResult.success("保存指导部门成功");
        } catch (Exception e) {
            handleResult.error("保存指导部门失败");
            logger.error("保存指导部门失败", e);
        }
        return handleResult;
    }

    /**
     * 获取指导部门
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/guidLoad")
    @ResponseBody
    public HandleResult guidLoad(@RequestParam String curDeptId){
        HandleResult handleResult = new HandleResult();
        try {
            List<SysGuidDeptVo> result = service.selectVoList(curDeptId);
            if(result.size()==1){
                handleResult.put("selected", result.get(0));
                handleResult.put("selectedDept", sysDeptService.selectVoById(result.get(0).getGuidDeptId()));
            }else{
                handleResult.error("获取指导部门不止一个");
            }
        } catch (Exception e) {
            handleResult.error("获取指导部门信息失败");
            logger.error("获取指导部门失败", e);
        }
        return handleResult;
    }

    /**
     * 获取指导部门
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/getfRegionCodeByDeptId")
    @ResponseBody
    public String getfRegionCodeByDeptId(@RequestParam String deptId){
        return sysDeptService.getfRegionCodeByDeptId(deptId);
    }
}
