package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.mapper.system.SysDeptAuthorityMapper;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门数据权限分配表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Service
public class SysDeptAuthorityServiceImpl extends CommonServiceImpl<SysDeptAuthorityMapper, SysDeptAuthority , SysDeptAuthorityVo> implements ISysDeptAuthorityService {

    @Autowired
    private SysDeptAuthorityMapper mapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public boolean insertVO(SysDeptAuthorityVo vo) throws Exception {
        String deptIds = vo.getDeptIds();
        if(StringUtils.isNotBlank(deptIds)){
            String[] deptIdArray = deptIds.split(",");
            for(String deptId : deptIdArray){
                if(StringUtils.isNotBlank(deptId)){
                    vo.setId(CommonUtil.get32UUID());
                    vo.setDeptId(deptId);
                    vo.setDistributorId(ShiroUtils.getLoginUserId());
                    vo.setDistributeDate(new Date());
                    vo.setIsFromAudit("0");
                    if(!insert(vo)){
                        throw new Exception("添加部门数据权限失败！");
                    }
                }
            }
        }
		return true;
    }

    @Override
    public boolean updateVO(SysDeptAuthorityVo vo) throws Exception {
        //删除已有权限
        mapper.deleteByVo(vo);
        String deptIds = vo.getDeptIds();
        if(StringUtils.isNotBlank(deptIds)){
            vo.setDeptIdArray(deptIds.split(","));
            return this.insertVO(vo);
        }
        return true;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		return false;
	}

    @Override
    public SysDeptAuthorityVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDeptAuthorityVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		return 0;
	}

    @Override
    public List<SysDeptAuthorityVo> selectVoList(Map<String, Object> paramMap) {
        return mapper.selectVoList(paramMap);
    }

    @Override
    public List<String> selectParentDeptAuthIds(Map<String, Object> paramMap) {
        List<String> deptIds = new ArrayList();
        String deptId = (String) paramMap.get("deptId");
        if (StringUtils.isNotBlank(deptId)) {
            SysDeptVo sysDeptVo = sysDeptMapper.selectVoById(deptId);
            Integer deptLevel = sysDeptVo.getDeptLevel();
            if (deptLevel != null && deptLevel >= 3) {
                String parentDeptId = sysDeptVo.getFid();
                if (StringUtils.isNotBlank(parentDeptId)) {
                    Map map = new HashMap();
                    map.put("authObjId", parentDeptId);
                    map.put("authObjType", AuthObjTypeEnum.DEPT.getKey());
                    List<SysDeptAuthorityVo> parentDeptAuths = mapper.selectVoList(map);
                    deptIds = parentDeptAuths.stream().map(parentDeptAuth -> parentDeptAuth.getDeptId()).collect(Collectors.toList());
                }
            }
        }
        return deptIds;
    }

    @Override
    public List<String> selectAllSuperiorIds(Map<String, Object> paramMap) {
//        List<SysDept>  sysDeptList= new ArrayList();
//        List<SysDeptAuthorityVo> vos = mapper.selectVoList(paramMap);
//        List<String>  list=vos.stream().map(vo -> vo.getDeptId()).collect(Collectors.toList());
//        while (list!=null && !list.isEmpty()){
//            List<SysDept> existList=sysDeptMapper.listByList(list);
//            sysDeptList.removeAll(existList);
//            sysDeptList.addAll(existList);
//            list=existList.stream().map(sysDept -> sysDept.getFid()).collect(Collectors.toList());
//        }
//
//        return  sysDeptList.stream().map(sysDept -> sysDept.getId()).collect(Collectors.toList());
        return mapper.getAllDeptParentNode(paramMap);
    }

    @Override
    public List<String> getSelectedNodeByCurrentNode(Map<String, Object> paramMap) {
        return mapper.getSelectedNodeByCurrentNode(paramMap);
    }
}
