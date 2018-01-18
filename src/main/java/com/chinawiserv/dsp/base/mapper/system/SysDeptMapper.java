package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 组织机构表 Mapper 接口1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    List<SysDeptVo> selectVoPage(Page<SysDeptVo> page, Map<String, Object> paramMap);

    List<SysDeptVo> selectSubVoList(Map<String, Object> paramMap);

    List<SysDeptVo> selectBaseVoPage(Page<SysDeptVo> page, Map<String, Object> paramMap);


    SysDeptVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int selectBaseVoCount(Map<String, Object> paramMap);
//    目录相关操作代码

    List<SysDeptVo> selectVoListForTreeData(Map<String, Object> paramMap);

    boolean isParentDept(String id);

    List<SysDeptVo> selectDeptListLikeTreeCode(Map<String, Object> paramMap);

    List<String> selectDeptByPrivilege(@Param("user_id") String user_id);

    Integer deleteBatchDeptByIds(List<String> ids);

    List<SysDept> listBySystemId(String systemId);

    List<SysDept> listByList(List<String> list);

    List<String> listIdsByList(List<String> list);

    long batchInsert(List<SysDept> list);

    Map<String,Object> selectBelongTypeByDept(String deptId);

    SysDeptVo selectVoByTreeCode(String treeCode);

    int updateSXDept(SysDept sysDept);

    SysDept selectSXDept(SysDept sysDept);
    //根据父部门修改子部门
    int updateDeptByfDept(SysDept sysDept);
}