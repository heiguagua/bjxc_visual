package com.chinawiserv.dsp.dir.service.api.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
import com.google.common.collect.Lists;
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
        List<Map<String,Object>> tableRelation = apiMapper.getTableInfoByDatasetId(paramMap);
        List<Map<String,Object>> tableInfoList = Lists.newArrayList();
        if(null != tableRelation && tableRelation.size() > 0){

            for(Iterator iter = tableRelation.iterator(); iter.hasNext();){

                Map<String,Object> tableInfo = (Map<String,Object>)iter.next();
                if(null != tableInfo){
                    String sourceTableId = (String)tableInfo.get("sourceTableId");
                    String sourceTableName = (String)tableInfo.get("sourceTableName");
                    if(StringUtils.isNotBlank(sourceTableId)){
                        tableParamMap.put("tableId",sourceTableId);
                        List<Map<String,Object>> sourceTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        Map<String,Object> tableSource = Maps.newHashMap();
                        tableSource.put("tableName",sourceTableName);
                        tableSource.put("tableColunms",sourceTableColumnList);
                        tableInfoList.add(tableSource);
                    }

                    String targetTableId = (String)tableInfo.get("targetTableId");
                    String targetTableName = (String)tableInfo.get("targetTableName");
                    if(StringUtils.isNotBlank(targetTableId)){
                        tableParamMap.put("tableId",targetTableId);
                        List<Map<String,Object>> targetTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        Map<String,Object> tableTarget = Maps.newHashMap();
                        tableTarget.put("tableName",targetTableName);
                        tableTarget.put("tableColunms",targetTableColumnList);
                        tableInfoList.add(tableTarget);
                    }
                }
            }

        }
        result.put("tableRelation",tableRelation);
        result.put("tableInfo",tableInfoList);
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



                    JSONObject serviceInfo = serviceInfoArr.getJSONObject(i);
                    String serviceName = (String)serviceInfo.get("serviceName");
                    String serviceType = (String)serviceInfo.get("serviceType");
                    String serviceUrl = (String)serviceInfo.get("serviceUrl");
                    String requestType = (String)serviceInfo.get("requestType");
                    String dataStyle = (String)serviceInfo.get("dataStyle");
                    String serviceInfoParams = null;
                    try{
                        serviceInfoParams = serviceInfo.get("serviceInfoParams").toString();
                    }catch (Exception e){
                        serviceInfoParams = "";
                    }
                    String serviceId = (String)serviceInfo.get("serviceNo");
                    String status = (String)serviceInfo.get("status");
                    String dirOrDrapType = (String)serviceInfo.get("dirType"); //目录梳理类型
                    String dirOrDrapTypeId = (String)serviceInfo.get("dirTypeId"); //目录数据集OR梳理数据表ID

                    /**
                     * 多个源，对ID进行拆分
                     * */
                    String[] idList = null;
                    if(null != dirOrDrapTypeId && dirOrDrapTypeId.contains(",")){
                        idList = dirOrDrapTypeId.split(",");
                    }
                    Date startDate = null;
                    Date endDate = null;

                    try {
                        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)serviceInfo.get("startDate"));
                    } catch (Exception e) {
                        startDate = null;
                    }
                    try {
                        endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)serviceInfo.get("endDate"));
                    } catch (Exception e) {
                        endDate = null;
                    }

                    /**
                     * 初始化PO:DirServiceInfo
                     * */
                    if(null == serviceId || "" == serviceId){
                        return handleResult;
                    }

                    dirServiceInfo.setId(serviceId);
                    dirServiceInfo.setOperateDate(new Date());
                    dirServiceInfo.setRequestMethod(requestType);
                    dirServiceInfo.setServiceUrl(serviceUrl);
                    dirServiceInfo.setServiceName(serviceName);
                    dirServiceInfo.setServiceType(serviceType);
                    dirServiceInfo.setRequestFormat(dataStyle);
                    dirServiceInfo.setRequestInfo(serviceInfoParams);


                    DirServiceInfo dirServiceInfoIf = dirServiceInfoMapper.selectById(serviceId);

                    if(null != dirServiceInfoIf){
                        dirServiceInfoMapper.updateById(dirServiceInfo);
                    }else if(null == dirServiceInfoIf){
                        dirServiceInfoMapper.insert(dirServiceInfo);
                    }

                    if(null != idList){
                        for (int j = 0; j < idList.length; j++) {
                            DirDatasetServiceMap dirDatasetServiceMapEntity = new DirDatasetServiceMap();
                            dirDatasetServiceMapEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
                            dirDatasetServiceMapEntity.setServiceId(serviceId);
                            dirDatasetServiceMapEntity.setStatus(status);
                            dirDatasetServiceMapEntity.setValidFrom(startDate);
                            dirDatasetServiceMapEntity.setValidTo(endDate);
                            dirDatasetServiceMapEntity.setObjId(idList[j]);
                            dirDatasetServiceMapEntity.setObjType(dirOrDrapType);
                            dirDatasetServiceMapEntity.setOperateTime(new Date());

                            DirDatasetServiceMap dirDatasetServiceMapEntityParam = new DirDatasetServiceMap();

                            dirDatasetServiceMapEntityParam.setServiceId(serviceId);
                            dirDatasetServiceMapEntityParam.setObjId(idList[j]);
                            dirDatasetServiceMapEntityParam.setObjType(dirOrDrapType);

                            DirDatasetServiceMap dirDatasetServiceMapEntityIf = dirDatasetServiceMapMapper.selectOne(dirDatasetServiceMapEntityParam);
                            if(null == dirDatasetServiceMapEntityIf){
                                dirDatasetServiceMapMapper.insert(dirDatasetServiceMapEntity);
                            }else{
                                dirDatasetServiceMapEntityIf.setValidFrom(startDate);
                                dirDatasetServiceMapEntityIf.setValidTo(endDate);
                                dirDatasetServiceMapEntityIf.setStatus(status);
                                dirDatasetServiceMapEntityIf.setOperateTime(new Date());
                                dirDatasetServiceMapMapper.updateById(dirDatasetServiceMapEntityIf);
                            }
                        }
                        handleResult.setState(true);
                        handleResult.setMsg("发布成功");
                    }else if(null == idList){
                        /**
                         * 判断是否是重新发布，重新发布就更新数据库，不是就插入数据库
                         * */

                        DirDatasetServiceMap dirDatasetServiceMapParam = new DirDatasetServiceMap();
                        dirDatasetServiceMapParam.setServiceId(serviceId);
                        dirDatasetServiceMapParam.setObjId(dirOrDrapTypeId);
                        DirDatasetServiceMap dirDatasetServiceMapIf = dirDatasetServiceMapMapper.selectOne(dirDatasetServiceMapParam);
                        if (null != dirDatasetServiceMapIf){
                            dirDatasetServiceMapIf.setValidFrom(startDate);
                            dirDatasetServiceMapIf.setValidTo(endDate);
                            dirDatasetServiceMapIf.setObjType(dirOrDrapType);
                            dirDatasetServiceMapIf.setStatus(status);
                            dirDatasetServiceMapIf.setOperateTime(new Date());
                            dirDatasetServiceMapMapper.updateById(dirDatasetServiceMapIf);
                            handleResult.setState(true);
                            handleResult.setMsg("发布成功");
                        }else if(null == dirDatasetServiceMapIf){
                            /**
                             * 插入数据集服务关联信息
                             * */
                            DirDatasetServiceMap dirDatasetServiceMap = new DirDatasetServiceMap();
                            dirDatasetServiceMap.setId(UUID.randomUUID().toString().replaceAll("-",""));
                            dirDatasetServiceMap.setServiceId(serviceId);
                            dirDatasetServiceMap.setStatus(status);
                            dirDatasetServiceMap.setValidFrom(startDate);
                            dirDatasetServiceMap.setValidTo(endDate);
                            dirDatasetServiceMap.setObjId(dirOrDrapTypeId);
                            dirDatasetServiceMap.setObjType(dirOrDrapType);
                            dirDatasetServiceMap.setOperateTime(new Date());
                            dirDatasetServiceMapMapper.insert(dirDatasetServiceMap);
                            handleResult.setState(true);
                            handleResult.setMsg("发布成功");
                        }
                    }

                }
            }else {
                handleResult.setState(false);
            }
        }

        return handleResult;
    }
    /**
     * 下架服务，更新服务状态
     * */
    @Override
    public HandleResult unReleaseService(Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
         if(null == paramMap || paramMap.size() == 0){
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        }else{
             DirDatasetServiceMap dirDatasetServiceMapParam = new DirDatasetServiceMap();
             String status = (String)paramMap.get("status");
             String serviceId = (String)paramMap.get("serviceNo");
             dirDatasetServiceMapParam.setServiceId(serviceId);
             Wrapper wrapper = new EntityWrapper();
             wrapper.eq("service_id",serviceId);
             List<DirDatasetServiceMap> mapList = dirDatasetServiceMapMapper.selectList(wrapper);
             if(null != mapList && !mapList.isEmpty()){
                 for (DirDatasetServiceMap map:mapList) {
                     map.setStatus(status);
                     map.setOperateTime(new Date());
                     dirDatasetServiceMapMapper.updateById(map);
                 }
                 handleResult.setState(true);
                 handleResult.setMsg("下架成功");
             }else{
                 logger.error(serviceId+"的服务不存在");
                 handleResult.setState(false);
                 handleResult.setMsg(serviceId+"的服务不存在");
             }

        }
        return handleResult;
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

    @Override
    public List<Map<String, Object>> getSystemInfoByDeptId(Map<String, Object> paramMap) {
        return apiMapper.getSystemInfoByDeptId(paramMap);
    }


}
