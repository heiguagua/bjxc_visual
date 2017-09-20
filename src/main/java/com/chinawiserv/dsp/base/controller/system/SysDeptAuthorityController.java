package com.chinawiserv.dsp.base.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.enums.system.AuthTypeEnum;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityService;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
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
 * 部门数据权限分配表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Controller
@RequestMapping("/system/deptAuthority")
public class SysDeptAuthorityController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptAuthorityService service;

    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("system:deptAuthority:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "system/deptAuthority/deptAuthorityList";
    }

    /**
     * 分页查询部门数据权限分配表
     */
    @RequiresPermissions("system:deptAuthority:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<SysDeptVo> page = sysDeptService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询组织机构出错");
            logger.error("分页查询组织机构出错", e);
        }
        return pageResult;
    }

    /**
     * 编辑部门数据权限分配表
     */
    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id, @RequestParam String authType, Model model) throws Exception {
		model.addAttribute("id", id);
		model.addAttribute("authType", authType);
        return "system/deptAuthority/deptAuthorityEdit";
    }

    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String authType){
		HandleResult handleResult = new HandleResult();
		try {
            JSONArray result = null;
		    if(AuthTypeEnum.DEPT.getKey().equals(authType)){
                result = sysDeptService.getDeptSelectDataList(null);
            }else if(AuthTypeEnum.USER.getKey().equals(authType)){

            }else throw new Exception("未能识别要分配的权限类型");
            handleResult.put("selectData", result);
		} catch (Exception e) {
		    handleResult.error("获取部门数据权限分配表信息失败");
		    logger.error("获取部门数据权限分配表信息失败", e);
		}
		return handleResult;
    }

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysDeptAuthorityVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑部门数据权限分配表成功");
		} catch (Exception e) {
		    handleResult.error("编辑部门数据权限分配表失败");
		    logger.error("编辑部门数据权限分配表失败", e);
		}
		return handleResult;
    }
}
