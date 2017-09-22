package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    /**
     * 推送用户数据的接口
     * */
    @RequestMapping("syncUserData")
    @ResponseBody
    public HandleResult syncUserData(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysUser> result = service.syncUserData();
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
     * 推送部门数据的接口
     * */
    @RequestMapping("syncDeptData")
    @ResponseBody
    public HandleResult syncDeptData(){
        HandleResult handleResult = new HandleResult();
        try{
            List<SysDept> result = service.syncDeptData();
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
