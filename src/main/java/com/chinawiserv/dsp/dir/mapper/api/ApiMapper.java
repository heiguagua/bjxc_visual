package com.chinawiserv.dsp.dir.mapper.api;

import com.chinawiserv.dsp.base.entity.po.system.*;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;

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

    List<Map<String, Object>> getTableInfoByDatasetId(Map<String, Object> paramMap);

    List<Map<String, Object>> getColumnInfoByTableId(Map<String, Object> paramMap);

    List<DirClassify> syncClassifyData();

    List<SysDept> syncDeptData();

    List<SysUser> syncUserData();

    List<SysDict> syncSysDictData();

    List<SysRegion> syncSysRegionData();

    List<SysRegionLevel> syncSysRegionLevelData();

    List<SysDeptAuthority> syncSysDeptAuthorityData();

    List<SysDeptAuthorityApply> syncSysDeptAuthorityApplyData();

    List<Map<String, Object>> getDbInfoBySystemId(Map<String, Object> paramMap);

    List<Map<String,Object>> getSystemInfoByDeptId(Map<String,Object> paramMap);

    /**
     * 查询服务
     * */
    List<Map<String, Object>> getServiceInfoByServiceNoOrId(Map<String, Object> paramMap);

    /**
     * 下架服务
     * */
    boolean unReleaseService(Map<String, Object> paramMap);

    /**
     * 查询用户的数据集权限
     * */
    Map<String,Object> getDataAuthorityByUserId(Map<String,Object> paramMap);

    /**
     * 查询用户申请的数据集拥有的数据项
     * */
    List<Map<String,Object>> getDataitemAuthorityByUserIdAndDatasetId(Map<String,Object> paramMap);

    DrapDbTableInfo getTableInfoBySystemIdAndDbId(Map<String,Object> paramMap);

    List<Map<String,Object>> getTableInfoWithoutRelationByDatasetId(Map<String,Object> paramMap);

}
