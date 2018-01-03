package com.chinawiserv.dsp.dir.controller.api;

import com.alibaba.fastjson.JSON;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.*;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysUserRoleService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Description:资源管理查询相关API
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:31
 * Chinawiserv Technologies Co., Ltd.
 */
@Controller
@RequestMapping("api/drap")
public class DrapApiController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IApiService service;

    @Autowired
    ISysUserService userService;

    @Autowired
    ISysUserRoleService sysUserRoleService;

    @Autowired
    ISysDeptService sysDeptService;
    /**
     * 推送用户数据的接口
     * */
    @RequestMapping("syncUserData")
    @ResponseBody
    public Map<String,String> syncUserData(@RequestParam Map<String,Object> paramMap){
        Map<String,String> map = Maps.newHashMap();

        List<SysUser> resultUserList  = Lists.newArrayList();
        List<SysUserRole> resultUserRoleList = Lists.newArrayList();
        try{
            resultUserList = service.syncUserData();
            resultUserRoleList = sysUserRoleService.selectList(null);

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        map.put("userArray", JSON.toJSONString(resultUserList));
        map.put("userRoleArray", JSON.toJSONString(resultUserRoleList));
        return map;
    }
    /**
     * 推送部门数据的接口
     * */
    @RequestMapping("syncDeptData")
    @ResponseBody
    public List<SysDept> syncDeptData(){
        List<SysDept> result = Lists.newArrayList();
        try{
            result = service.syncDeptData();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     * 推送字典数据的接口
     * */
    @RequestMapping("syncDictData")
    @ResponseBody
    public HandleResult syncSysDict(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysDict> result = service.syncSysDictData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }


    /**
     * 推送行政区划数据的接口
     * */

    @RequestMapping("syncRegionData")
    @ResponseBody
    public HandleResult syncSysRegion(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysRegion> result = service.syncSysRegionData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }

    /**
     * 推送行政区划级别数据的接口
     * */
    @RequestMapping("syncRegionLevelData")
    @ResponseBody
    public HandleResult syncSysRegionLevel(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysRegionLevel> result = service.syncSysRegionLevelData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }

    /**
     * 同步同步部门权限分配信息sys_dept_authority
     * */
    @RequestMapping("syncDeptAuthorityData")
    @ResponseBody
    public HandleResult syncDeptAuthority(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysDeptAuthority> result = service.syncSysDeptAuthorityData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }

    /**
     * 同步同步部门权限分配信息sys_dept_authority_apply
     * */
    @RequestMapping("syncDeptAuthorityApplyData")
    @ResponseBody
    public HandleResult syncDeptAuthorityApply(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysDeptAuthorityApply> result = service.syncSysDeptAuthorityApplyData();
            handleResult.put("rows",result);
            handleResult.setState(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }

}
