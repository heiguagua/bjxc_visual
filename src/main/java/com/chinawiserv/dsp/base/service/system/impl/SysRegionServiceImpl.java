package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 行政区域表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
@Service
public class SysRegionServiceImpl extends CommonServiceImpl<SysRegionMapper, SysRegion , SysRegionVo> implements ISysRegionService {

    @Autowired
    private SysRegionMapper mapper;

    @Autowired
    private SysDeptMapper deptMapper;

    @Autowired
    private ISysDeptService sysDeptService;

    @Override
    public boolean insertVO(SysRegionVo vo) throws Exception {
        vo.setId(CommonUtil.get32UUID());
		return insert(vo);
    }

    @Override
    public boolean  updateVO(SysRegionVo vo) throws Exception {
		return updateById(vo);
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysRegionVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public Page<SysRegionVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        if (null==paramMap.get("fcode")){
            paramMap.put("regionCode", ShiroUtils.getLoginUser().getRegionCode());
        }
        Page<SysRegionVo> page = getPage(paramMap);
        List<SysRegionVo> sysDeptVos = mapper.selectVoPage(page, paramMap);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(sysDeptVos);
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysRegionVo> selectAllRegionByRegionCode(String regionCode) {
        List<SysRegionVo> sysRegionVos = new ArrayList();
        if (StringUtils.isNotBlank(regionCode)) {
            SysRegionVo sysRegionVo = mapper.selectVoByRegionCode(regionCode);
            if(sysRegionVo != null){
                String regionCodeCondition = this.getRegionCodeCondition(regionCode, sysRegionVo.getRegionLevel());
                sysRegionVos.addAll(mapper.selectAllRegionByRegionCode(regionCodeCondition));
            }
        }
        return sysRegionVos;
    }

    @Override
    public List<SysRegionVo> selectAllRegionLikeRegionCode(String regionCodeCondition) {
        return mapper.selectAllRegionByRegionCode(regionCodeCondition);
    }

    @Override
    public String getAllSubRegionCodesWithSelf(String regionCode) {
        String allRegionCodes = "";
        if(!org.springframework.util.StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = selectAllRegionByRegionCode(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCodes = allRegionCode.substring(0,allRegionCode.length()-1);
                }
            }
        }

        return allRegionCodes;
    }

    @Override
    public List<SysRegionVo> getRegionSelectDataList(Map<String, Object> paramMap) {
        String regionCode = (String)paramMap.get("regionCode");
        if(StringUtils.isBlank(regionCode)){
            String deptId = ShiroUtils.getLoginUserDeptId();
            if(StringUtils.isNotBlank(deptId)){
                SysDeptVo sysDeptVo = deptMapper.selectVoById(deptId);
                if(sysDeptVo != null){
                    regionCode = sysDeptVo.getRegionCode();
                }
            }
            if(StringUtils.isBlank(regionCode)){
                regionCode = ShiroUtils.getLoginUser().getRegionCode();
            }
            paramMap.put("regionCode", regionCode);
        }else{
            paramMap.remove("regionCode");
            paramMap.put("fcode", regionCode);
        }
        return mapper.selectVoListForTreeData(paramMap);
    }

    @Override
    public SysRegionVo getRegionDataByCode(String regionCode) throws Exception {
        return mapper.selectVoByCode(regionCode);
    }

    @Override
    public List<String> getAllParentRegionCodes(String regionCode) throws Exception{
        List<String> allParentCodeList = new ArrayList<>();
        if(!StringUtils.isEmpty(regionCode)){
            String regionCodeCondition = regionCode.substring(0, 2);
            List<SysRegionVo> sysRegionVoList = mapper.selectAllRegionByRegionCode(regionCodeCondition);
            getAllParentCode(sysRegionVoList, regionCode, allParentCodeList);
        }
        return allParentCodeList;
    }

    private void getAllParentCode(List<SysRegionVo> sysRegionVoList, String regionCode, List<String> allParentCodeList){
        if(!ObjectUtils.isEmpty(sysRegionVoList)){
            for(SysRegionVo sysRegionVo : sysRegionVoList){
                String code = sysRegionVo.getRegionCode();
                if(regionCode.equals(code)){
                    String parentCode = sysRegionVo.getFcode();
                    if(!StringUtils.isEmpty(parentCode)){
                        allParentCodeList.add(parentCode);
                        getAllParentCode(sysRegionVoList, parentCode, allParentCodeList);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public boolean deleteBatchRegionByIds(List<String> ids) {
        return retBool(mapper.deleteBatchRegionByIds(ids));
    }

    @Override
    public void initTopDept(String id) throws ErrorInfoException{
        SysRegionVo vo = mapper.selectVoById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("regionCode",vo.getRegionCode());
        map.put("fid","root");
        int num = deptMapper.selectBaseVoCount(map);
        if(num>1){
            throw  new ErrorInfoException("已经初始化顶级部门，无需再次操作");
        }else{
            mapper.initTopDept(vo.getRegionCode());
        }
    }
}
