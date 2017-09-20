package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:服务发布相关API
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:31
 * Chinawiserv Technologies Co., Ltd.
 */
@Controller
@RequestMapping("api/service")
public class ServiceApiController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IApiService service;
    /**
     * 查询子目录的数据
     * */
    @RequestMapping("getSubDirectoryById")
    @ResponseBody
    public HandleResult getSubDirectoryById(@RequestParam Map<String,Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            List<Map<String,Object>> result = service.getSubDirectoryById(paramMap);
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
     * 查询数据集关联的数据项
     * */
    @RequestMapping("getSubDataItemById")
    @ResponseBody
    public HandleResult getSubDataItemById(@RequestParam Map<String,Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            List<Map<String,Object>> result = service.getSubDataItemById(paramMap);
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
     * 查询指定目录下面的数据集
     * */
    @RequestMapping("getDatasetByClassifyId")
    @ResponseBody
    public HandleResult getDatasetByClassifyId(@RequestParam Map<String,Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            List<Map<String,Object>> result = service.getDatasetByClassifyId(paramMap);
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
     * 查询指定数据集下面的数据库信息
     * */
    @RequestMapping("getDbInfoByDatasetId")
    @ResponseBody
    public HandleResult getDbInfoByDatasetId(Map<String, Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            List<Map<String,Object>> result = service.getDbInfoByDatasetId(paramMap);
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
     * 查询指定数据集下面的表信息、字段信息
     * */
    @RequestMapping("getItemAndTableInfoByDatasetId")
    @ResponseBody
    public HandleResult getItemAndTableInfoByDatasetId(Map<String, Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            List<Map<String,Object>> result = service.getItemAndTableInfoByDatasetId(paramMap);
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
     * 发布服务
     * */
    @RequestMapping("getItemAndTableInfoByDatasetId")
    @ResponseBody
    public HandleResult releaseService(Map<String, Object> paramMap){
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }
        try{
            boolean result = service.releaseService(paramMap);
            handleResult.setState(result);
        }catch (Exception e){
            logger.error(e.getMessage());
            handleResult.setMsg(e.getMessage());
            handleResult.setState(false);
        }
        return handleResult;
    }
}
