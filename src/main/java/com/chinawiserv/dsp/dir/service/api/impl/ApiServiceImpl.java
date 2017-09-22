package com.chinawiserv.dsp.dir.service.api.impl;

import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.mapper.api.ApiMapper;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:16:20
 * Chinawiserv Technologies Co., Ltd.
 */
@Service
public class ApiServiceImpl implements IApiService {
    @Autowired
    private ApiMapper mapper;

    @Override
    public List<Map<String, Object>> test(Map<String, Object> paramMap) {
        return mapper.test(paramMap);
    }
    /**
     * 根据目录ID查询子目录
     * */
    @Override
    public List<Map<String, Object>> getSubDirectoryById(Map<String, Object> paramMap) {
        return mapper.getSubDirectoryById(paramMap);
    }
    /**
     * 查询数据集下面的数据项
     * */
    @Override
    public List<Map<String, Object>> getSubDataItemById(Map<String, Object> paramMap) {
        return mapper.getSubDataItemById(paramMap);
    }

    @Override
    public List<Map<String, Object>> getDatasetByClassifyId(Map<String, Object> paramMap) {
        return mapper.getDatasetByClassifyId(paramMap);
    }

    @Override
    public List<Map<String, Object>> getDbInfoByDatasetId(Map<String, Object> paramMap) {
        return null;
    }
    /**
     *
     * */
    @Override
    public Map<String,Object> getServiceInfoByDatasetId(Map<String, Object> paramMap) {
        Map<String,Object> result = Maps.newHashMap();
        Map<String,Object> tableParamMap = Maps.newHashMap();
        /**
         * 查询数据库信息
         * */
        List<Map<String,Object>> dbResult = mapper.getDbInfoByDatasetId(paramMap);
        result.put("dbInfo",dbResult);

        /**
         * 查询数据表、字段对应关系
         * */
        List<Map<String,Object>> tableResult = mapper.getTableInfoByDatasetId(paramMap);

        if(null != tableResult && tableResult.size() > 0){

            for(Iterator iter = tableResult.iterator(); iter.hasNext();){
                Map<String,Object> tableInfo = (Map<String,Object>)iter.next();
                if(null != tableInfo){
                    String sourceTableId = (String)tableInfo.get("sourceTableId");
                    if(StringUtils.isNotBlank(sourceTableId)){
                        tableParamMap.put("tableId",sourceTableId);
                        List<Map<String,Object>> sourceTableColumnList = mapper.getColumnInfoByTableId(tableParamMap);
                        tableInfo.put("sourceTableColumns",sourceTableColumnList);
                    }

                    String targetTableId = (String)tableInfo.get("targetTableId");
                    if(StringUtils.isNotBlank(targetTableId)){
                        tableParamMap.put("tableId",targetTableId);
                        List<Map<String,Object>> targetTableColumnList = mapper.getColumnInfoByTableId(tableParamMap);
                        tableInfo.put("targetTableColumns",targetTableColumnList);
                    }
                }
            }

        }
        result.put("tableInfo",tableResult);
        return result;
    }
    /**
     * 发布服务，往表插入数据
     * */
    @Override
    public boolean releaseService(Map<String, Object> paramMap) {
        return false;
    }

    /**
     * 同步神马用户数据(插入更新)
     * */
    @Override
    public Map<String, Object> syncUserInfo(List<SysUser> userList) {
        return null;
    }

    @Override
    public List<DirClassify> syncClassifyData() {
        return mapper.syncClassifyData();
    }
}
