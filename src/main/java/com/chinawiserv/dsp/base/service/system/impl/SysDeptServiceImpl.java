package com.chinawiserv.dsp.base.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysDeptServiceImpl extends CommonServiceImpl<SysDeptMapper, SysDept, SysDeptVo> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRegionMapper sysRegionMapper;

    @Override
    public Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> param = this.getDeptCondition(null);
        if(!param.isEmpty()){
            paramMap.putAll(param);
            Page<SysDeptVo> page = getPage(paramMap);
            page.setOrderByField("tree_code");
            page.setAsc(true);
            List<SysDeptVo> sysDeptVos = sysDeptMapper.selectVoPage(page, paramMap);
            page.setTotal(sysDeptMapper.selectVoCount(paramMap));
            page.setRecords(sysDeptVos);
            return page;
        }
        return getPage(paramMap);
    }

    @Override
    public SysDeptVo selectVoById(String id) throws Exception {
        return sysDeptMapper.selectVoById(id);
    }

    @Override
    public JSONObject checkDeptName(String deptName, String deptId) {
        List<SysDept> list;
        JSONObject result = new JSONObject();
        if (StringUtils.isNotBlank(deptId)) {
            list = selectList(new EntityWrapper<SysDept>().where("dept_name = {0}", deptName).and("id != {0}", deptId).and("delete_flag = {0}", "0"));
        } else {
            list = selectList(new EntityWrapper<SysDept>().addFilter("dept_name = {0}", deptName).and("delete_flag = {0}", "0"));
        }
        if (list != null && !list.isEmpty()) {
            result.put("error", "该组织机构名称已存在");
        }
        return result;
    }

    @Override
    public List<SysDeptVo> getDeptSelectDataList(Map<String, Object> paramMap) throws Exception {
        if(paramMap == null) paramMap = new HashMap();
        String regionCode = (String) paramMap.get("regionCode");
        Boolean onlyRoot = (Boolean) paramMap.get("onlyRoot");
        Boolean excludeRoot = (Boolean) paramMap.get("excludeRoot");
        Boolean checkIsLeaf = (Boolean) paramMap.get("checkIsLeaf");
        if(onlyRoot == null){
            onlyRoot = false;
        }
        if(excludeRoot == null){
            excludeRoot = true;
        }
        if(checkIsLeaf == null){
            checkIsLeaf = true;
        }
        List<SysDeptVo> list = new ArrayList();
        Map<String, Object> param = this.getDeptCondition(regionCode);
        if(!param.isEmpty()){
            if(onlyRoot){
                param.put("onlyRoot", onlyRoot);
            }else if(excludeRoot){
                param.put("excludeRoot", excludeRoot);
            }
            list.addAll(this.selectVoList(param));
            if(checkIsLeaf){
                for(SysDeptVo sysDeptVo : list){
                    sysDeptVo.setIsLeaf(this.isLeafDept(sysDeptVo.getDeptCode()));
                }
            }
        }
        return list;
    }

    @Override
    public boolean deleteDeptById(String id) throws Exception {
        SysDeptVo sysDeptVo = sysDeptMapper.selectVoById(id);
        if(sysDeptVo != null){
            if(sysDeptMapper.isLeafDept(sysDeptVo.getDeptCode())){
                int count = sysUserMapper.selectUsersCountByDeptId(id);
                if(count == 0){
                    SysDept sysDept = new SysDept();
                    sysDept.setId(id);
                    sysDept.setDeleteFlag(1);
                    return this.updateById(sysDept);
                }
            }
        }
        return false;
    }

    @Override
    public List<SysDeptVo> selectVoList(Map<String, Object> paramMap) {
        return sysDeptMapper.selectVoList(paramMap);
    }

    @Override
    public boolean insertVO(SysDeptVo sysDeptVo) throws Exception {
        sysDeptVo.setId(CommonUtil.get32UUID());
        sysDeptVo.setStatus(1);
        sysDeptVo.setCreateUserId(ShiroUtils.getLoginUserId());
        sysDeptVo.setCreateTime(new Date());
        return insert(sysDeptVo);
    }

    @Override
    public boolean updateVO(SysDeptVo sysDeptVo) throws Exception {
        sysDeptVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysDeptVo.setUpdateTime(new Date());
        return updateById(sysDeptVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysDeptMapper.selectVoCount(paramMap);
    }

    @Override
    public Map<String, Object> getDeptCondition(String regionCode){
        Map<String, Object> paramMap = new HashMap();
        SysUserVo loginUser = ShiroUtils.getLoginUser();
        String deptTreeCode = loginUser.getDeptTreeCode();
        if (StringUtils.isNotBlank(deptTreeCode)) {
            paramMap.put("deptTreeCodeCondition", deptTreeCode);
        }
        if(StringUtils.isBlank(regionCode)){
            regionCode = ShiroUtils.getLoginUser().getRegionCode();
        }
        if (StringUtils.isNotBlank(regionCode)) {
            SysRegionVo sysRegionVo = sysRegionMapper.selectVoByRegionCode(regionCode);
            if(sysRegionVo != null){
                paramMap.put("regionCodeCondition", this.getRegionCodeCondition(regionCode, sysRegionVo.getRegionLevel()));
            }
        }
        return paramMap;
    }

    @Override
    public boolean isLeafDept(String deptCode) {
        if(StringUtils.isBlank(deptCode)){
            return true;
        }else{
            return sysDeptMapper.isLeafDept(deptCode);
        }
    }

}
