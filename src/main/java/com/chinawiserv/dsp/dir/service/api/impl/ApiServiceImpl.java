package com.chinawiserv.dsp.dir.service.api.impl;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetServiceMap;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;
import com.chinawiserv.dsp.dir.mapper.api.ApiMapper;
import com.chinawiserv.dsp.dir.mapper.api.DirServiceInfoMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetServiceMapMapper;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private DirServiceInfoMapper dirServiceInfoMapper;

    @Autowired
    private DirDatasetServiceMapMapper dirDatasetServiceMapMapper;

    @Override
    public List<Map<String, Object>> test(Map<String, Object> paramMap) {
        return apiMapper.test(paramMap);
    }
    /**
     * 根据目录ID查询子目录
     * */
    @Override
    public List<Map<String, Object>> getSubDirectoryById(Map<String, Object> paramMap) {
        return apiMapper.getSubDirectoryById(paramMap);
    }
    /**
     * 查询数据集下面的数据项
     * */
    @Override
    public List<Map<String, Object>> getSubDataItemById(Map<String, Object> paramMap) {
        return apiMapper.getSubDataItemById(paramMap);
    }

    @Override
    public List<Map<String, Object>> getDatasetByClassifyId(Map<String, Object> paramMap) {
        return apiMapper.getDatasetByClassifyId(paramMap);
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
        List<Map<String,Object>> dbResult = apiMapper.getDbInfoByDatasetId(paramMap);
        result.put("dbInfo",dbResult);

        /**
         * 查询数据表、字段对应关系
         * */
        List<Map<String,Object>> tableResult = apiMapper.getTableInfoByDatasetId(paramMap);

        if(null != tableResult && tableResult.size() > 0){

            for(Iterator iter = tableResult.iterator(); iter.hasNext();){
                Map<String,Object> tableInfo = (Map<String,Object>)iter.next();
                if(null != tableInfo){
                    String sourceTableId = (String)tableInfo.get("sourceTableId");
                    if(StringUtils.isNotBlank(sourceTableId)){
                        tableParamMap.put("tableId",sourceTableId);
                        List<Map<String,Object>> sourceTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        tableInfo.put("sourceTableColumns",sourceTableColumnList);
                    }

                    String targetTableId = (String)tableInfo.get("targetTableId");
                    if(StringUtils.isNotBlank(targetTableId)){
                        tableParamMap.put("tableId",targetTableId);
                        List<Map<String,Object>> targetTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        tableInfo.put("targetTableColumns",targetTableColumnList);
                    }
                }
            }

        }
        result.put("tableInfo",tableResult);
        return result;
    }
    /**
     * 发布服务，往表插入数据(dir_service_info/dir_dataset_service_map)
     * */
    @Override
    public HandleResult releaseService(Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }else{
            String serviceInfoStr = (String)paramMap.get("serviceInfo"); //获取服务信息的JSON字符串
            if(null != serviceInfoStr){
                JSONArray serviceInfoArr = JSONArray.fromObject(serviceInfoStr);
                //解析JSON字符串,获取服务相关信息
                for (int i = 0; i < serviceInfoArr.size(); i++) {

                    DirServiceInfo dirServiceInfo = new DirServiceInfo();

                    DirDatasetServiceMap dirDatasetServiceMap = new DirDatasetServiceMap();

                    JSONObject serviceInfo = serviceInfoArr.getJSONObject(i);
                    String serviceName = (String)serviceInfo.get("serviceName");
                    String serviceType = (String)serviceInfo.get("serviceType");
                    String serviceUrl = (String)serviceInfo.get("serviceUrl");
                    String requestType = (String)serviceInfo.get("requestType");
                    String dataStyle = (String)serviceInfo.get("dataStyle");
                    String serviceInfoParams = (String)serviceInfo.get("serviceInfoParams");
                    String serviceNo = (String)serviceInfo.get("serviceNo");
                    String status = (String)serviceInfo.get("status");
                    String dcmId = (String)serviceInfo.get("dcmId");
                    Date startDate = null;
                    Date endDate = null;
                    Date operateDate = new Date();
                    try {
                        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)serviceInfo.get("startDate"));
                        endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)serviceInfo.get("endDate"));
                    } catch (ParseException e) {
                        logger.error(e.getMessage());
                    }

                    dirServiceInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    dirServiceInfo.setOperateDate(operateDate);
                    dirServiceInfo.setRequestMethod(requestType);
                    dirServiceInfo.setServiceUrl(serviceUrl);
                    dirServiceInfo.setServiceName(serviceName);
                    dirServiceInfo.setServiceType(serviceType);
                    dirServiceInfo.setRequestFormat(dataStyle);
                    dirServiceInfo.setRequestInfo(serviceInfoParams);

                    dirDatasetServiceMap.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    dirDatasetServiceMap.setServiceId(serviceNo);
                    dirDatasetServiceMap.setStatus(status);
                    dirDatasetServiceMap.setValidFrom(startDate);
                    dirDatasetServiceMap.setValidTo(endDate);
                    dirDatasetServiceMap.setObjId(null);
                    dirDatasetServiceMap.setObjType(null);
                    /**
                     * 插入服务信息
                     * */
                    dirServiceInfoMapper.insert(dirServiceInfo);
                    /**
                     * 插入数据集服务关联信息
                     * */
                    dirDatasetServiceMapMapper.insert(dirDatasetServiceMap);


                }
            }
        }

        return null;
    }
    /**
     * 下架服务
     * */
    @Override
    public HandleResult unReleaseService(Map<String, Object> paramMap) {
        return null;
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
        return apiMapper.syncClassifyData();
    }

    @Override
    public List<SysDept> syncDeptData() {
        return apiMapper.syncDeptData();
    }

    @Override
    public List<SysUser> syncUserData() {
        return apiMapper.syncUserData();
    }

    @Override
    public List<Map<String, Object>> getDbInfoBySystemId(Map<String, Object> paramMap) {
        return apiMapper.getDbInfoBySystemId(paramMap);
    }


}
