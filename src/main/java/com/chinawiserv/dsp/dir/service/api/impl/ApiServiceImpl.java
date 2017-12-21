package com.chinawiserv.dsp.dir.service.api.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.*;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.mapper.system.SysDictMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyDeptMap;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetServiceMap;
import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;
import com.chinawiserv.dsp.dir.enums.service.ServiceType;
import com.chinawiserv.dsp.dir.mapper.api.ApiMapper;
import com.chinawiserv.dsp.dir.mapper.api.DirServiceInfoMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyDeptMapMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetClassifyMapMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetServiceMapMapper;
import com.chinawiserv.dsp.dir.mapper.configure.DirSpecialAppsMapper;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysDictMapper sysDictMapper;

    @Autowired
    private DirClassifyMapper dirClassifyMapper;

    @Autowired
    private DirClassifyDeptMapMapper dirClassifyDeptMapMapper;

    @Autowired
    private DirDatasetClassifyMapMapper dirDatasetClassifyMapMapper;

    @Autowired
    private DirSpecialAppsMapper dirSpecialAppsMapper;

    @Override
    public List<Map<String, Object>> test(Map<String, Object> paramMap) {
        return apiMapper.test(paramMap);
    }

    /**
     * 根据目录ID查询子目录
     */
    @Override
    public List<Map<String, Object>> getSubDirectoryById(Map<String, Object> paramMap) {
        return apiMapper.getSubDirectoryById(paramMap);
    }

    /**
     * 查询数据集下面的数据项
     */
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
        return apiMapper.getDbInfoByDatasetId(paramMap);
    }

    /**
     *
     * */
    @Override
    public Map<String, Object> getServiceInfoByDatasetId(Map<String, Object> paramMap) {
        Map<String, Object> result = Maps.newHashMap();
        Map<String, Object> tableParamMap = Maps.newHashMap();
        /**
         * 查询数据库信息
         * */
        List<Map<String, Object>> dbResult = apiMapper.getDbInfoByDatasetId(paramMap);
        result.put("dbInfo", dbResult);

        /**
         * 查询数据表、字段对应关系
         * */
        List<Map<String, Object>> tableRelation = apiMapper.getTableInfoByDatasetId(paramMap);
        List<Map<String, Object>> tableInfoList = Lists.newArrayList();
        if (null != tableRelation && tableRelation.size() > 0) {

            for (Iterator iter = tableRelation.iterator(); iter.hasNext(); ) {

                Map<String, Object> tableInfo = (Map<String, Object>) iter.next();
                if (null != tableInfo) {
                    String sourceTableId = (String) tableInfo.get("sourceTableId");
                    if (StringUtils.isNotBlank(sourceTableId)) {
                        tableParamMap.put("tableId", sourceTableId);
                        List<Map<String, Object>> sourceTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        Map<String, Object> tableSource = Maps.newHashMap();
                        tableSource.put("tableName", tableInfo.get("sourceTableName"));
                        tableSource.put("tableDesc", tableInfo.get("sourceTableDesc"));
                        tableSource.put("tableColunms", sourceTableColumnList);
                        tableInfoList.add(tableSource);
                    }

                    String targetTableId = (String) tableInfo.get("targetTableId");
                    if (StringUtils.isNotBlank(targetTableId)) {
                        tableParamMap.put("tableId", targetTableId);
                        List<Map<String, Object>> targetTableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                        Map<String, Object> tableTarget = Maps.newHashMap();
                        tableTarget.put("tableName", tableInfo.get("targetTableName"));
                        tableTarget.put("tableDesc", tableInfo.get("targetTableDesc"));
                        tableTarget.put("tableColunms", targetTableColumnList);
                        tableInfoList.add(tableTarget);
                    }
                }
            }
            result.put("tableRelation", tableRelation);
        } else {
            /**
             * 单表无关系
             * */
            tableRelation = apiMapper.getTableInfoWithoutRelationByDatasetId(paramMap);
            if (null != tableRelation && tableRelation.size() > 0) {
                for (Iterator iter = tableRelation.iterator(); iter.hasNext(); ) {
                    Map<String, Object> tableInfo = (Map<String, Object>) iter.next();
                    if (null != tableInfo) {
                        String tableId = (String) tableInfo.get("tableId");
                        String tableName = (String) tableInfo.get("tableName");
                        String tableDesc = (String) tableInfo.get("tableDesc");
                        if (StringUtils.isNotBlank(tableId)) {
                            tableParamMap.put("tableId", tableId);
                            List<Map<String, Object>> tableColumnList = apiMapper.getColumnInfoByTableId(tableParamMap);
                            Map<String, Object> table = Maps.newHashMap();
                            table.put("tableName", tableName);
                            table.put("tableDesc", tableDesc);
                            table.put("tableColunms", tableColumnList);
                            table.put("tableId", tableId);
                            tableInfoList.add(table);
                        }
                    }
                }
            }
        }
        result.put("tableInfo", tableInfoList);
        return result;
    }

    /**
     * 发布服务，往表插入数据(dir_service_info/dir_dataset_service_map)
     */
    @Override
    public HandleResult releaseService(Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        if (null == paramMap || paramMap.size() == 0) {
            handleResult.setMsg("未传入参数");
            handleResult.setState(false);
            return handleResult;
        } else {
            String serviceInfoStr = (String) paramMap.get("serviceInfo"); //获取服务信息的JSON字符串

            if (null != serviceInfoStr) {
                JSONArray serviceInfoArr = JSONArray.fromObject(serviceInfoStr);
                //解析JSON字符串,获取服务相关信息
                for (int i = 0; i < serviceInfoArr.size(); i++) {

                    DirServiceInfo dirServiceInfo = new DirServiceInfo();

                    JSONObject serviceInfo = serviceInfoArr.getJSONObject(i);
                    String serviceName = (String) serviceInfo.get("serviceName");
                    String serviceType = (String) serviceInfo.get("serviceType");
                    String serviceUrl = (String) serviceInfo.get("serviceUrl");
                    String requestType = (String) serviceInfo.get("requestType");
                    String dataStyle = (String) serviceInfo.get("dataStyle");
                    String classifyId = (String) serviceInfo.get("classifyId");
                    String serviceInfoParams = "";
                    try {
                        serviceInfoParams = serviceInfo.get("serviceInfoParams").toString();
                    } catch (Exception e) {
                        serviceInfoParams = "";
                    }
                    String serviceId = (String) serviceInfo.get("serviceNo");
                    String status = (String) serviceInfo.get("status");
                    String dirOrDrapType = (String) serviceInfo.get("dirType"); //目录梳理类型
                    String dirOrDrapTypeId = (String) serviceInfo.get("dirTypeId"); //目录数据集 OR 梳理数据表ID OR mongoDB数据集ID

                    /**
                     * 来自梳理的处理
                     * */
                    if ("hackle".equalsIgnoreCase(dirOrDrapType)) {
                        String systemId = (String) serviceInfo.get("systemId"); //系统ID
                        String dbId = (String) serviceInfo.get("dbId");  //数据库ID
                        String dirStructure = (String) serviceInfo.get("dirStructure");  //数据表
                        /**
                         * 查询表对应的ID
                         * */
                        Map<String, Object> tableParamMap = Maps.newHashMap();
                        tableParamMap.put("systemId", systemId);
                        tableParamMap.put("dbId", dbId);
                        if (null != dirStructure && !dirStructure.contains(",")) {
                            tableParamMap.put("tableName", serviceName);
                            DrapDbTableInfo drapDbTableInfo = apiMapper.getTableInfoBySystemIdAndDbId(tableParamMap);
                            if (null != drapDbTableInfo) {
                                String tableId = drapDbTableInfo.getId();
                                dirOrDrapTypeId = tableId;
                            } else if (null == drapDbTableInfo) {
                                handleResult.error("发布失败，对应表不存在或未同步");
                                handleResult.setState(false);
                                return handleResult;
                            }
                        }

                        if (dirStructure.contains(",")) {
                            StringBuffer sb = new StringBuffer();
                            String[] tableNames = dirStructure.split(",");
                            for (String tableName : tableNames) {
                                tableParamMap.put("tableName", tableName);
                                DrapDbTableInfo drapDbTableInfo = apiMapper.getTableInfoBySystemIdAndDbId(tableParamMap);
                                if (null != drapDbTableInfo) {
                                    String tableId = drapDbTableInfo.getId();
                                    sb.append(tableId);
                                    sb.append(",");
                                } else if (null == drapDbTableInfo) {
                                    handleResult.error("发布失败，对应表不存在或未同步");
                                    handleResult.setState(false);
                                    return handleResult;
                                }
                            }
                            if (null != sb) {
                                dirOrDrapTypeId = sb.toString();
                            }
                        }
                    }
                    DirDatasetClassifyMap dirDatasetClassifyMap = new DirDatasetClassifyMap();
                    /**
                     * 多个源，对ID进行拆分
                     * */
                    String[] idList = null;
                    if (null != dirOrDrapTypeId && dirOrDrapTypeId.contains(",")) {
                        idList = dirOrDrapTypeId.split(",");
                    }
                    Date startDate = null;
                    Date endDate = null;

                    try {
                        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) serviceInfo.get("startDate"));
                    } catch (Exception e) {
                        startDate = null;
                    }
                    try {
                        endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) serviceInfo.get("endDate"));
                    } catch (Exception e) {
                        endDate = null;
                    }

                    /**
                     * 初始化PO:DirServiceInfo
                     * */
                    if (null == serviceId || "" == serviceId) {
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

                    if (null != dirServiceInfoIf) {
                        dirServiceInfoMapper.updateById(dirServiceInfo);
                    } else if (null == dirServiceInfoIf) {
                        dirServiceInfoMapper.insert(dirServiceInfo);
                    }

                    if (null != idList) {
                        for (int j = 0; j < idList.length; j++) {
                            dirDatasetClassifyMap.setDatasetId(idList[j]);
                            dirDatasetClassifyMap.setClassifyId(classifyId);
                            DirDatasetClassifyMap dirDatasetClassifyMapIf = dirDatasetClassifyMapMapper.selectOne(dirDatasetClassifyMap);
                            if (null != dirDatasetClassifyMapIf) {
                                idList[j] = dirDatasetClassifyMapIf.getId();
                            } else if (null == dirDatasetClassifyMapIf && !"hackle".equalsIgnoreCase(dirOrDrapType)) {
                                handleResult.setMsg("发布失败，信息资源、目录信息查询失败，请检查是否存在或同步");
                                handleResult.setState(false);
                                return handleResult;
                            }
                            DirDatasetServiceMap dirDatasetServiceMapEntity = new DirDatasetServiceMap();
                            dirDatasetServiceMapEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
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
                            if (null == dirDatasetServiceMapEntityIf) {
                                dirDatasetServiceMapMapper.insert(dirDatasetServiceMapEntity);
                            } else {
                                dirDatasetServiceMapEntityIf.setValidFrom(startDate);
                                dirDatasetServiceMapEntityIf.setValidTo(endDate);
                                dirDatasetServiceMapEntityIf.setStatus(status);
                                dirDatasetServiceMapEntityIf.setOperateTime(new Date());
                                dirDatasetServiceMapMapper.updateById(dirDatasetServiceMapEntityIf);
                            }
                        }
                        handleResult.setState(true);
                        handleResult.setMsg("发布成功");
                    } else if (null == idList) {
                        /**
                         * 判断是否是重新发布，重新发布就更新数据库，不是就插入数据库
                         * */

                        DirDatasetServiceMap dirDatasetServiceMapParam = new DirDatasetServiceMap();
                        dirDatasetServiceMapParam.setServiceId(serviceId);
                        /**
                         * 查询dcmId
                         * */

                        dirDatasetClassifyMap.setClassifyId(classifyId);
                        dirDatasetClassifyMap.setDatasetId(dirOrDrapTypeId);
                        List<DirDatasetClassifyMap> list = dirDatasetClassifyMapMapper.selectList(new EntityWrapper<DirDatasetClassifyMap>().addFilter("classify_id = {0}", classifyId).addFilter("dataset_id = {0}", dirOrDrapTypeId));
                        if (null != list && list.size() == 1) {
                            dirOrDrapTypeId = list.get(0).getId();
                        } else if ((null == list || list.size() > 1) && !"hackle".equalsIgnoreCase(dirOrDrapType)) {
                            handleResult.setMsg("发布失败，信息资源、目录信息查询失败，请检查是否存在或同步");
                            handleResult.setState(false);
                            return handleResult;
                        }
                        dirDatasetServiceMapParam.setObjId(dirOrDrapTypeId);
                        DirDatasetServiceMap dirDatasetServiceMapIf = dirDatasetServiceMapMapper.selectOne(dirDatasetServiceMapParam);
                        if (null != dirDatasetServiceMapIf) {
                            dirDatasetServiceMapIf.setValidFrom(startDate);
                            dirDatasetServiceMapIf.setValidTo(endDate);
                            dirDatasetServiceMapIf.setObjType(dirOrDrapType);
                            dirDatasetServiceMapIf.setStatus(status);
                            dirDatasetServiceMapIf.setOperateTime(new Date());
                            dirDatasetServiceMapMapper.updateById(dirDatasetServiceMapIf);
                            handleResult.setState(true);
                            handleResult.setMsg("发布成功");
                        } else if (null == dirDatasetServiceMapIf) {
                            /**
                             * 插入数据集服务关联信息
                             * */
                            DirDatasetServiceMap dirDatasetServiceMap = new DirDatasetServiceMap();
                            dirDatasetServiceMap.setId(UUID.randomUUID().toString().replaceAll("-", ""));
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
            } else {
                handleResult.setState(false);
            }
        }

        return handleResult;
    }

    /**
     * 下架服务，更新服务状态
     */
    @Override
    public HandleResult unReleaseService(Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        handleResult.setState(false);
        if (null == paramMap || paramMap.size() == 0) {
            handleResult.setMsg("未传入参数");
            return handleResult;
        }

        String serviceInfoStr = (String) paramMap.get("serviceInfo");
        if (null != serviceInfoStr && serviceInfoStr.startsWith("[")) {
            JSONArray serviceInfoArr = JSONArray.fromObject(serviceInfoStr);
            //解析JSON字符串,获取服务相关信息
            for (int i = 0; i < serviceInfoArr.size(); i++) {
                JSONObject serviceInfo = serviceInfoArr.getJSONObject(i);
                String status = (String) serviceInfo.get("status");
                String serviceId = (String) serviceInfo.get("serviceNo");
                String serviceType = (String) serviceInfo.get("serviceType");
                String objId = null;
                if(ServiceType.DIR.getValue().equalsIgnoreCase(serviceType)){
                    String classifyId = (String) serviceInfo.get("classifyId");
                    String datasetId = (String) serviceInfo.get("setDataId");
                    /**
                     * 查询dcmId
                     * */
                    List<DirDatasetClassifyMap> list = dirDatasetClassifyMapMapper.selectList(new EntityWrapper<DirDatasetClassifyMap>().addFilter("dataset_id = {0}", datasetId).addFilter("classify_id = {0}", classifyId));
                    if(null != list && list.size() == 1){
                        objId = list.get(0).getId();
                    }else{
                        handleResult.setMsg("查询资源目录出错，资源不存在或存在相同资源");
                        return handleResult;
                    }
                }

//                if(ServiceType.HACKLE.getValue().equalsIgnoreCase(serviceType)){
//                    /**
//                     * 查询表ID
//                     * */
//                    Map<String,Object> tableParamMap = Maps.newHashMap();
//                    tableParamMap.put ("systemId",serviceInfo.get("systemId"));
//                    tableParamMap.put ("dbId",serviceInfo.get("dbId"));
//                    tableParamMap.put ("tableName",serviceInfo.get("tableName"));
//                    DrapDbTableInfo table = null;
//                    try {
//                        table =  apiMapper.getTableInfoBySystemIdAndDbId(tableParamMap);
//                    } catch (Exception e) {
//                        handleResult.setMsg("数据表"+serviceInfo.get("tableName")+"查询错误，请检查是否存在或存在多个");
//                        return handleResult;
//                    }
//                    if(null != table){
//                        objId = table.getId();
//                    }
//                }

                /**
                 * MongoDB 无datasetId和classifyId,单独处理
                 * */

                if(ServiceType.HACKLE.getValue().equalsIgnoreCase(serviceType)||ServiceType.MONGODB.getValue().equalsIgnoreCase(serviceType)||StringUtils.isBlank(serviceType)){
                    List<DirDatasetServiceMap> mongoServiceList = dirDatasetServiceMapMapper.selectList(new EntityWrapper<DirDatasetServiceMap>().addFilter("service_id = {0}",serviceId));
                    if(!CollectionUtils.isEmpty(mongoServiceList)){
                        int a = 0;
                        for (DirDatasetServiceMap map:mongoServiceList) {
                            map.setStatus(status);
                            map.setOperateTime(new Date());
                            a += dirDatasetServiceMapMapper.updateById(map);
                        }
                        if(a == mongoServiceList.size()){
                            handleResult.setState(true);
                            handleResult.setMsg("下架成功");
                        }else{
                            handleResult.setMsg("下架失败");
                        }
                    }
                    return handleResult;
                }

                List<DirDatasetServiceMap> mapList = dirDatasetServiceMapMapper.selectList(new EntityWrapper<DirDatasetServiceMap>().addFilter("obj_id = {0}",objId).addFilter("service_id = {0}",serviceId));

                if(null != mapList && mapList.size()==1){
                    DirDatasetServiceMap map = mapList.get(0);
                    map.setStatus(status);
                    map.setOperateTime(new Date());
                    dirDatasetServiceMapMapper.updateById(map);
                    handleResult.setState(true);
                    handleResult.setMsg("下架成功");
                }else{
                    logger.error("服务号service_no:"+ serviceId + "[obj_id:"+ objId +"]的服务不存在或存在多个");
                    handleResult.setMsg("服务号service_no:"+ serviceId + "[obj_id:"+ objId +"]的服务不存在或存在多个");
                }
            }
        }
        return handleResult;
    }

    /**
     * 同步神马用户数据(插入更新)
     */
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
    public List<SysDict> syncSysDictData() {
        return apiMapper.syncSysDictData();
    }

    @Override
    public List<SysUser> syncUserData() {
        return apiMapper.syncUserData();
    }

    @Override
    public List<SysRegion> syncSysRegionData() {
        return apiMapper.syncSysRegionData();
    }

    @Override
    public List<SysRegionLevel> syncSysRegionLevelData() {
        return apiMapper.syncSysRegionLevelData();
    }

    @Override
    public List<SysDeptAuthority> syncSysDeptAuthorityData() {
        return apiMapper.syncSysDeptAuthorityData();
    }

    @Override
    public List<SysDeptAuthorityApply> syncSysDeptAuthorityApplyData() {
        return apiMapper.syncSysDeptAuthorityApplyData();
    }

    @Override
    public List<Map<String, Object>> getDbInfoBySystemId(Map<String, Object> paramMap) {
        return apiMapper.getDbInfoBySystemId(paramMap);
    }

    @Override
    public List<Map<String, Object>> getSystemInfoByDeptId(Map<String, Object> paramMap) {
        return apiMapper.getSystemInfoByDeptId(paramMap);
    }

    @Override
    public HandleResult serviceAuthority(Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        /**
         * 获取token
         * */
        String token = (String) paramMap.get("token");

        /**
         * 获取服务封装类型
         * */
        String serviceType = (String) paramMap.get("type");
        /**
         * 梳理封装
         * */
        if ("drap".equalsIgnoreCase(serviceType)) {
            return handleResult;
        }
        /**
         * 非梳理封装
         * */
        else {
            /**
             * 获取数据集
             * */
            String dcmId = (String) paramMap.get("dcmId");
            /**
             * 对应目录的ID
             * */

            if (null == paramMap || StringUtils.isAnyBlank(token, dcmId)) {
                handleResult.setMsg("未传入TOKEN或dcmId");
                handleResult.setState(false);
                return handleResult;
            }

            //查询Token对应的用户
            SysUser sysUserParam = new SysUser();
            sysUserParam.setToken(token);
            SysUser sysUser = sysUserMapper.selectOne(sysUserParam);

            if (null != sysUser) {
                String userName = sysUser.getUserName();
                String userId = sysUser.getId();
                paramMap.put("userName", userName);
                paramMap.put("userId", userId);
                Map<String, Object> userInfo = Maps.newHashMap();
                userInfo.put("userId", userId);
                userInfo.put("userName", userName);
                userInfo.put("userRealName", sysUser.getRealName());
                handleResult.put("userInfo", userInfo);
                /**
                 * 查询用户字段权限
                 * */
                Map<String, Object> dataseAuthorityMap = apiMapper.getDataAuthorityByUserId(paramMap);  //待完成
                String dataApplyId = null;
                if (null != dataseAuthorityMap && !dataseAuthorityMap.isEmpty()) {
                    dataApplyId = (String) dataseAuthorityMap.get("dataApplyId");
                }
                boolean status;
                try {
                    status = Boolean.valueOf((String) dataseAuthorityMap.get("status")).booleanValue();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    status = false;
                }
                paramMap.put("dataApplyId", dataApplyId);
                handleResult.put("authorityDataset", dataseAuthorityMap);
                handleResult.put("userDatasetAuthority", status);
                handleResult.setState(true);
                /**
                 * 查询数据集对应字段
                 * */
                if (status) {
                    List<Map<String, Object>> itemAuthorityList = apiMapper.getDataitemAuthorityByUserIdAndDatasetId(paramMap);
                    handleResult.put("authorityItems", itemAuthorityList);
                }

            } else {
                handleResult.setMsg("对应用户不存在");
                handleResult.setState(false);
            }
        }

        return handleResult;
    }

    @Override
    public Map<String, Object> syncDataToOpenPortal(Map<String, Object> paramMap) {
        Map<String,Object> result =  Maps.newHashMap();
        /**
         * 组织表
         * */
        List<SysDept> sysDeptList = sysDeptMapper.selectList(null);

        result.put("sysDeptList",sysDeptList);

        /**
         * 字典表
         * */
        List<SysDict> sysDictList = sysDictMapper.selectList(null);

        result.put("sysDictList",sysDictList);
        /**
         * 目录分类表
         * */
        List<DirClassify> dirClassifyList = dirClassifyMapper.selectList(null);

        result.put("dirClassifyList",dirClassifyList);

        /**
         * 部门分类关联表
         * */
        List<DirClassifyDeptMap> dirClassifyDeptMapList = dirClassifyDeptMapMapper.selectList(null);

        result.put("dirClassifyDeptMapList",dirClassifyDeptMapList);

        /**
         * 专题应用表
         * */
        List<DirSpecialApps> dirSpecialAppsList = dirSpecialAppsMapper.selectList(null);

        result.put("dirSpecialAppsList",dirSpecialAppsList);

        return result;
    }


}
