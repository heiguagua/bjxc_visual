package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		return null;
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
}
