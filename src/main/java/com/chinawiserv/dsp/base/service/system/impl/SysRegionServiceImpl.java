package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public boolean insertVO(SysRegionVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysRegionVo vo) throws Exception {
		//todo
		return false;
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
		//todo
		return null;
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

}
