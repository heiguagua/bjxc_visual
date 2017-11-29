package com.chinawiserv.dsp.dir.controller.sys;

import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
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
 * 部门目录数据权限分配表 前端控制器
 * </p>
 *
 * @author tangxiong
 * @since 2017-11-3
 */
@Controller
@RequestMapping("/system/deptDirAuthority")
public class SysDeptDirAuthorityController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirClassifyAuthorityService dirClassifyAuthorityService;

    @RequiresPermissions("system:deptDirAuthority:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/sys/deptDirAuthority/deptDirAuthorityList";
    }


    /**
     * 编辑部门数据权限分配表
     */
    @RequiresPermissions("system:deptDirAuthority:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) throws Exception {
		model.addAttribute("id", id);
        return "dir/sys/deptDirAuthority/deptDirAuthorityEdit";
    }

    /**
     * 编辑组织机构权限
     */
    @RequiresPermissions("system:deptDirAuthority:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String, Object> paramMap = new HashMap();
            if(StringUtils.isBlank(id)){
                throw new Exception("被分配权限的部门不能为空！");
            }
            paramMap.put("authObjType", AuthObjTypeEnum.DEPT.getKey());
            paramMap.put("authObjId", id);
            List result = dirClassifyAuthorityService.selectVoList(paramMap);
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
    @RequiresPermissions("system:deptDirAuthority:edit")
    @Log("组织机构目录数据权限分配")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(@RequestParam Map<String, Object> paramMap){
		HandleResult handleResult = new HandleResult();
		try {
            String authObjId = (String) paramMap.get("authObjId");
            if(StringUtils.isNoneBlank(authObjId)){
                String classifyIds = (String) paramMap.get("classifyIds");
//                    if(StringUtils.isNotBlank(classifyIds)){
                String authDetail = (String) paramMap.get("authDetail");
                DirClassifyAuthorityVo dirClassifyAuthorityVo = new DirClassifyAuthorityVo();
                dirClassifyAuthorityVo.setClassifyIds(classifyIds);
                dirClassifyAuthorityVo.setAuthObjType(AuthObjTypeEnum.DEPT.getKey());
                dirClassifyAuthorityVo.setAuthObjId(authObjId);
                dirClassifyAuthorityVo.setAuthDetail(authDetail);
                dirClassifyAuthorityService.updateVO(dirClassifyAuthorityVo);
            }else throw new Exception("未识别被分配的数据");
            handleResult.success("编辑部门数据权限分配表成功");
		} catch (Exception e) {
		    handleResult.error("编辑部门数据权限分配表失败");
		    logger.error("编辑部门数据权限分配表失败", e);
		}
		return handleResult;
    }

}
