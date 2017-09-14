package com.chinawiserv.dsp.base.service.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysDeptService extends ICommonService<SysDept, SysDeptVo> {

    Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    SysDeptVo selectVoById(String id) throws Exception;

    JSONObject checkDeptName(String deptName, String deptId) throws Exception;

    JSONArray getDeptSelectDataList(String regionCode) throws Exception;

    boolean deleteDeptById(String id) throws Exception;

    List<SysDeptVo> selectVoList(Map<String, Object> paramMap);

    Map<String, Object> getDeptCondition(String regionCode);
}
