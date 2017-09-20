package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.dir.service.api.IApiService;
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
    @Autowired
    private IApiService service;
    /**
     * 查询子目录的数据
     * */
    @RequestMapping("getSubDirectoryById")
    @ResponseBody
    public List<Map<String,Object>> getSubDirectoryById(@RequestParam Map<String,Object> paramMap){
        return service.getSubDirectoryById(paramMap);
    }

    /**
     * 查询数据集关联的数据项
     * */
    @RequestMapping("getSubDataItemById")
    @ResponseBody
    public List<Map<String,Object>> getSubDataItemById(@RequestParam Map<String,Object> paramMap){
        return service.getSubDataItemById(paramMap);
    }

    /**
     * 查询指定目录下面的数据集
     * */
    @RequestMapping("getDatasetByClassifyId")
    @ResponseBody
    public List<Map<String,Object>> getDatasetByClassifyId(@RequestParam Map<String,Object> paramMap){
        return service.getDatasetByClassifyId(paramMap);
    }

    /**
     * 查询指定数据集下面的数据库信息
     * */
    @RequestMapping("getDbInfoByDatasetId")
    @ResponseBody
    public List<Map<String, Object>> getDbInfoByDatasetId(Map<String, Object> paramMap){
        return service.getDbInfoByDatasetId(paramMap);
    }

    /**
     * 查询指定数据集下面的表信息、字段信息
     * */
    @RequestMapping("getItemAndTableInfoByDatasetId")
    @ResponseBody
    public List<Map<String, Object>> getItemAndTableInfoByDatasetId(Map<String, Object> paramMap){
        return service.getItemAndTableInfoByDatasetId(paramMap);
    }
}
