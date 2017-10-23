package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.common.util.HttpUtil;
import com.chinawiserv.dsp.base.common.util.Props;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.enums.catalog.ReportStatus;
import com.chinawiserv.dsp.dir.service.api.IDataTransferService;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("api/transfer")
public class DataTransferController extends BaseController {
    @Autowired
    private IDataTransferService service;

    private Props props = Props.of("conf/common.properties");

    /**
     * 封装上报数据的接口
     */
    @RequestMapping("getReportDataByDataset")
    @ResponseBody
    public HandleResult getReportDataByDataset(@RequestParam Map<String, Object> paramMap) {
        HandleResult result = new HandleResult();
        /**
         * 获取上报地址
         * */
        String address = props.get("data.transfer.address");

        Map<String,Object> dataTransferResult = service.getReportDataByDataset(paramMap);

        if(null == dataTransferResult && !dataTransferResult.isEmpty()){
            return result;
        }
        Gson gson = new Gson();
        String dataTransferResultJsonStr = gson.toJson(dataTransferResult);

        String resultJsonStr = null;
        try {
            resultJsonStr = HttpUtil.sendPostJson(address,dataTransferResultJsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(StringUtils.isNotBlank(resultJsonStr)&&resultJsonStr.startsWith("{")&&resultJsonStr.endsWith("}")){
            JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
            Integer insertCount = (Integer)resultJson.get("insert");
            Integer updateCount = (Integer)resultJson.get("update");
            String msg = (String)resultJson.get("msg");
            result.put("insertCount",insertCount);
            result.put("updateCount",updateCount);
            if(ReportStatus.REPORT_SUCCESS.getDesc().equalsIgnoreCase(msg)){
                result.success(msg);//上报成功
                result.setState(true);
            }else{
                result.error(msg);//上报失败
                result.setState(false);
            }
        }
        return result;
    }

    /**
     * 解析上报数据的接口
     */
    @RequestMapping("analysisReportData")
    @ResponseBody
    public Map<String, Object> analysisReportData(@RequestBody String requestBody) {
        return service.analysisReportData(requestBody);
    }
}
