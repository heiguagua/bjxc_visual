package com.chinawiserv.dsp.base.controller.system;

import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
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
 * Created by zengpzh on 2017/9/21.
 */
@Controller
@RequestMapping("/system/userDirAuthority")
public class SysUserDirAuthorityController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ISysUserService userService;

    @Autowired
    private IDirClassifyAuthorityService dirClassifyAuthorityService;

    @RequiresPermissions("system:userDirAuthority:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "system/userDirAuthority/userDirAuthorityList";
    }

    /**
     * 编辑部门数据权限分配表
     */
    @RequiresPermissions("system:userDirAuthority:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) throws Exception {
        model.addAttribute("id", id);
        return "system/userDirAuthority/userDirAuthorityEdit";
    }

    /**
     * 编辑组织机构权限
     */
    @RequiresPermissions("system:userDirAuthority:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String, Object> paramMap = new HashMap();
            if(StringUtils.isBlank(id)){
                throw new Exception("被分配权限的用户不能为空！");
            }
            if(ShiroUtils.getLoginUserDeptId().equals(id)){
                throw new Exception("被分配的用户权限不能为登录用户所属部门！");
            }
            paramMap.put("authObjType", AuthObjTypeEnum.USER.getKey());
            paramMap.put("authObjId", id);
            List result = dirClassifyAuthorityService.selectVoList(paramMap);
            //如果为空，说明为默认数据权限用户，数据权限为所属部门分配的数据权限
            if(result.isEmpty()){
                SysUserVo sysUserVo = userService.selectVoById(id);
                String deptId = sysUserVo.getDeptId();
                if(StringUtils.isNotBlank(deptId)){
                    paramMap.put("authObjType", AuthObjTypeEnum.DEPT.getKey());
                    paramMap.put("authObjId", deptId);
                    result = dirClassifyAuthorityService.selectVoList(paramMap);
                }
            }
            handleResult.put("selected", result);
        } catch (Exception e) {
            handleResult.error("获取用户数据权限信息失败");
            logger.error("获取用户数据权限失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:userDirAuthority:edit")
    @Log("编辑用户目录数据权限")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(@RequestParam Map<String, Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            String authObjId = (String) paramMap.get("authObjId");
            String classifyIds = (String) paramMap.get("classifyIds");
            String authDetail = (String) paramMap.get("authDetail");
            DirClassifyAuthorityVo dirClassifyAuthorityVo = new DirClassifyAuthorityVo();
            dirClassifyAuthorityVo.setClassifyIds(classifyIds);
            dirClassifyAuthorityVo.setAuthObjType(AuthObjTypeEnum.USER.getKey());
            dirClassifyAuthorityVo.setAuthObjId(authObjId);
            dirClassifyAuthorityVo.setAuthDetail(authDetail);
            dirClassifyAuthorityService.updateVO(dirClassifyAuthorityVo);
            handleResult.success("编辑用户数据权限分配表成功");
        } catch (Exception e) {
            handleResult.error("编辑用户数据权限分配表失败");
            logger.error("编辑用户数据权限分配表失败", e);
        }
        return handleResult;
    }

}
