package com.chinawiserv.dsp.base.service.system;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysDeptService extends ICommonService<SysDept, SysDeptVo> {

    String synUrl="/system/dept/provideData";

    Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    List<SysDeptVo> selectVoList(Map<String, Object> paramMap) throws Exception;

    Page<SysDeptVo> selectBaseVoPage(Map<String, Object> paramMap) throws Exception;

    SysDeptVo selectVoById(String id) throws Exception;

    JSONObject checkDeptName(String deptName, String fname, String deptId) throws Exception;

    List<SysDeptVo> getDeptSelectDataList(Map<String, Object> paramMap) throws Exception;
	//TODO pacong
	JSONArray getDeptSelectDataList() throws Exception;
	
    boolean deleteDeptById(String id) throws Exception;

//    List<SysDeptVo> selectVoList(Map<String, Object> paramMap);

    Map<String, Object> getDeptCondition(String regionCode, boolean excludeTreeCodeCondition);

    Map<String, Object> getDeptCondition(String regionCode);

    boolean isParentDept(String id);
    
//    String insertIntoDir(Map<String, Object> paramMap);

    List<SysDeptVo> selectDeptListLikeTreeCode(Map<String, Object> params);

    List<String> selectDeptByPrivilege(String user_id);
    //检查是否有关联数据，有则不可删除。不可删返回id，可删返回null
    String checkDeleteProperty(String id);

    boolean deleteBatchDeptByIds(List<String> ids) throws Exception;

    List<SysDept> listBySystemId(String systemId);

    boolean insertOrUpdate(List<SysDept> list);

    Map<String,Object> getBelongTypeByDept(String deptId);

    String getRootDeptId(String drapDeptId);

    boolean updateSXDept(SysDept sysDept);

    SysDept selectSXDept(SysDept sysDept);
}
