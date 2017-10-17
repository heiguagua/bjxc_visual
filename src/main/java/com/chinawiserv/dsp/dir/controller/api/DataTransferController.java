package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.dir.service.api.IDataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/10/14
 * Time:19:29
 * Chinawiserv Technologies Co., Ltd.
 */
@Controller
@RequestMapping("api/report")
public class DataTransferController extends BaseController {
    @Autowired
    private IDataTransferService service;

    /**
     * 封装上报数据的接口
     */
    @RequestMapping("getReportDataByDataset")
    @ResponseBody
    public Map<String, Object> getReportDataByDataset(@RequestParam Map<String, Object> paramMap) {
        return service.getReportDataByDataset(paramMap);
    }

    /**
     * 解析上报数据的接口
     */
    @RequestMapping("analysisReportData")
    @ResponseBody
    public Map<String, Object> analysisReportData(@RequestParam Map<String, Object> paramMap) {
        return service.analysisReportData(paramMap);
    }
}
