package com.chinawiserv.dsp.base.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegionDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.mapper.system.SysRegionDeptMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysRegionDeptService;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;

/**
 * <p>
 * 行政部门表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
@Service
public class SysRegionDeptServiceImpl extends CommonServiceImpl<SysRegionDeptMapper, SysRegionDept , SysRegionDeptVo> implements ISysRegionDeptService {

    @Autowired
    private SysRegionDeptMapper mapper;

    @Autowired
    private ISysRegionService sysRegionService;

    @Override
    public boolean insertVO(SysRegionDeptVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysRegionDeptVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysRegionDeptVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysRegionDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysRegionDeptVo> selectVoList(Map<String, Object> paramMap) throws Exception {
        //根据当前区域进行过滤(获取当前选择的区域的所有下属区域，以及父级区域【避免异步树显示不出过滤后的上级数据】)
        /*String regionCode = (String)paramMap.get("regionCode");
        if(!StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
            List<String> allParentCodeList = sysRegionService.getAllParentRegionCodes(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                for(String parentCode : allParentCodeList){
                    allRegionCodeBuffer.append("'").append(parentCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCode = allRegionCode.substring(0,allRegionCode.length()-1);
                    paramMap.put("allRegionCode",allRegionCode);
                    paramMap.remove("regionCode");
                }
            }
        }*/
        return mapper.selectVoListForTreeData(paramMap);
    }
}
