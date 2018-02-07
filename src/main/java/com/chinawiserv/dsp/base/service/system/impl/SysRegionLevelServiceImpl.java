package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegionLevel;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionLevelVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.mapper.system.SysRegionLevelMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.service.system.ISysRegionLevelService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 行政级别表 服务实现类
 * </p>
 *
 * @author tx123
 * @since 2018-02-07
 */
@Service
public class SysRegionLevelServiceImpl extends CommonServiceImpl<SysRegionLevelMapper, SysRegionLevel , SysRegionLevelVo> implements ISysRegionLevelService {

    @Autowired
    private SysRegionLevelMapper mapper;

    @Autowired
    private SysRegionMapper regionMapper;


    @Override
    public boolean insertVO(SysRegionLevelVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysRegionLevelVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysRegionLevelVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysRegionLevelVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysRegionLevelVo> findByRegionLevelValueGreaterThan(String regionCode) {
        SysRegionVo sysRegionVo = regionMapper.selectVoByRegionCode(regionCode);

        return mapper.findByRegionLevelValueGreaterThan(mapper.selectVoById(sysRegionVo.getRegionLevelCode()).getRegionLevelValue());
    }
}
