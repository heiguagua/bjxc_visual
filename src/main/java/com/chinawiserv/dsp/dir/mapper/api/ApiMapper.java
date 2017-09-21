package com.chinawiserv.dsp.dir.mapper.api;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:47
 * Chinawiserv Technologies Co., Ltd.
 */
public interface ApiMapper{

    List<Map<String,Object>> test(Map<String,Object> paramMap);

    List<Map<String,Object>> getSubDirectoryById(Map<String,Object> paramMap);

    List<Map<String,Object>> getSubDataItemById(Map<String,Object> paramMap);

    List<Map<String, Object>> getDatasetByClassifyId(Map<String, Object> paramMap);

    List<Map<String, Object>> getDbInfoByDatasetId(Map<String, Object> paramMap);

    List<Map<String, Object>> getItemAndTableInfoByDatasetId(Map<String, Object> paramMap);

}
