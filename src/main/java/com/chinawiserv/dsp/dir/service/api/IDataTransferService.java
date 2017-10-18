package com.chinawiserv.dsp.dir.service.api;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/10/14
 * Time:19:21
 * Chinawiserv Technologies Co., Ltd.
 */
public interface IDataTransferService {
    /**
     * 封装上报数据
     */
    Map<String, Object> getReportDataByDataset(Map<String, Object> paramMap);

    /**
     * 解析上报数据
     */
    Map<String, Object> analysisReportData(String dataSource);

}
