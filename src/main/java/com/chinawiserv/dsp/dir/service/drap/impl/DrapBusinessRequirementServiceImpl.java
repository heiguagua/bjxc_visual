package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessRequirementMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessRequirementService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务资源需求表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessRequirementServiceImpl extends CommonServiceImpl<DrapBusinessRequirementMapper, DrapBusinessRequirement , DrapBusinessRequirementVo> implements IDrapBusinessRequirementService {

    @Autowired
    private DrapBusinessRequirementMapper mapper;


    @Override
    public boolean insertVO(DrapBusinessRequirementVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessRequirementVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessRequirementVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessRequirementVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
