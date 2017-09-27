package com.chinawiserv.dsp.dir.service.api;


import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:46
 * Chinawiserv Technologies Co., Ltd.
 */
public interface IApiService {

    List<Map<String,Object>> test(Map<String,Object> paramMap);

    List<Map<String,Object>> getSubDirectoryById(Map<String,Object> paramMap);

    List<Map<String,Object>> getSubDataItemById(Map<String,Object> paramMap);

    List<Map<String,Object>> getDatasetByClassifyId(Map<String,Object> paramMap);

    List<Map<String,Object>> getDbInfoByDatasetId(Map<String,Object> paramMap);

    Map<String,Object> getServiceInfoByDatasetId(Map<String, Object> paramMap);

    HandleResult releaseService(Map<String, Object> paramMap);

    HandleResult unReleaseService(Map<String, Object> paramMap);

    Map<String,Object> syncUserInfo(List<SysUser> userList);

    List<DirClassify> syncClassifyData();

    List<SysDept> syncDeptData();

    List<SysUser> syncUserData();

    List<Map<String,Object>> getDbInfoBySystemId(Map<String,Object> paramMap);

    List<Map<String,Object>> getSystemInfoByDeptId(Map<String,Object> paramMap);


}
