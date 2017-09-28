package com.chinawiserv.dsp.base.controller.system;

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
                throw new Exception("被分配的部门权限不能为空！");
            }
            List result = null;
            paramMap.put("authObjType", AuthObjTypeEnum.DEPT.getKey());
            paramMap.put("authObjId", id);
            if("dept".equals(authType)){
                result = service.selectVoList(paramMap);
            }else if("dir".equals(authType)){
                result = dirClassifyAuthorityService.selectVoList(paramMap);
            }
            handleResult.put("selected", result);
        } catch (Exception e) {
            handleResult.error("获取部门数据权限信息失败");
            logger.error("获取部门数据权限失败", e);
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
            String authObjId = (String) paramMap.get("authObjId");
            if(StringUtils.isNoneBlank(authType, authObjId)){
                if("dept".equals(authType)){
                    String deptIds = (String) paramMap.get("deptIds");
                    if(StringUtils.isNotBlank(deptIds)){
                        SysDeptAuthorityVo sysDeptAuthorityVo = new SysDeptAuthorityVo();
                        sysDeptAuthorityVo.setDeptIds(deptIds);
                        sysDeptAuthorityVo.setAuthObjType(AuthObjTypeEnum.DEPT.getKey());
                        sysDeptAuthorityVo.setAuthObjId(authObjId);
                        service.updateVO(sysDeptAuthorityVo);
                    }
                }else if("dir".equals(authType)){
                    String classifyIds = (String) paramMap.get("classifyIds");
                    if(StringUtils.isNotBlank(classifyIds)){
                        String authDetail = (String) paramMap.get("authDetail");
                        DirClassifyAuthorityVo dirClassifyAuthorityVo = new DirClassifyAuthorityVo();
                        dirClassifyAuthorityVo.setClassifyIds(classifyIds);
                        dirClassifyAuthorityVo.setAuthObjType(AuthObjTypeEnum.DEPT.getKey());
                        dirClassifyAuthorityVo.setAuthObjId(authObjId);
                        dirClassifyAuthorityVo.setAuthDetail(authDetail);
                        dirClassifyAuthorityService.updateVO(dirClassifyAuthorityVo);
                    }
                }else throw new Exception("未识别的数据分配类型");
            }else throw new Exception("未识别被分配的数据");
            handleResult.success("编辑部门数据权限分配表成功");
		} catch (Exception e) {
		    handleResult.error("编辑部门数据权限分配表失败");
		    logger.error("编辑部门数据权限分配表失败", e);
		}
		return handleResult;
    }
}
