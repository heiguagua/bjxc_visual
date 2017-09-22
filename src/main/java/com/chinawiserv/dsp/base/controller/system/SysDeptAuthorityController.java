package com.chinawiserv.dsp.base.controller.system;

import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityService;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyAuthorityService;
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
    private IDirClassifyAuthorityService dirClassifyAuthorityService;

    @RequiresPermissions("system:deptAuthority:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "system/deptAuthority/deptAuthorityList";
    }

    /**
     * 编辑部门数据权限分配表
     */
    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, @RequestParam String authType, Model model) throws Exception {
		model.addAttribute("id", id);
		model.addAttribute("authType", authType);
        return "system/deptAuthority/deptAuthorityEdit";
    }

    /**
     * 编辑组织机构权限
     */
    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id, @RequestParam String authType){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String, Object> paramMap = new HashMap();
            if(StringUtils.isBlank(id)){
                throw new Exception("被分配的权限不能为空！");
            }
            if(ShiroUtils.getLoginUserDeptId().equals(id)){
                throw new Exception("被分配的权限不能为登录用户所属部门！");
            }
            List result = null;
            paramMap.put("authObjType", AuthObjTypeEnum.DEPT);
            if("dept".equals(authType)){
                paramMap.put("deptId", id);
                result = service.selectVoList(paramMap);
            }else if("dir".equals(authType)){
                paramMap.put("classifyId", id);
                result = dirClassifyAuthorityService.selectVoList(paramMap);
            }
            handleResult.put("selected", result);
        } catch (Exception e) {
            handleResult.error("获取数据权限信息失败");
            logger.error("获取数据权限失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:deptAuthority:edit")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(@RequestParam Map<String, Object> paramMap){
		HandleResult handleResult = new HandleResult();
		try {
		    String authType = (String) paramMap.get("authType");
            String authObjIds = (String) paramMap.get("authObjIds");
            if("dept".equals(authType)){
                String deptId = (String) paramMap.get("deptId");
                SysDeptAuthorityVo sysDeptAuthorityVo = new SysDeptAuthorityVo();
                sysDeptAuthorityVo.setDeptId(deptId);
                sysDeptAuthorityVo.setAuthObjIds(authObjIds);
                service.updateVO(sysDeptAuthorityVo);
            }else if("dir".equals(authType)){
                DirClassifyAuthorityVo dirClassifyAuthorityVo = new DirClassifyAuthorityVo();

            }
		    handleResult.success("编辑数据权限分配表成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据权限分配表失败");
		    logger.error("编辑数据权限分配表失败", e);
		}
		return handleResult;
    }
}
