package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementDatasetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementDatasetMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapRequirementDatasetMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapRequirementDatasetMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 需求和数据集关联表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapRequirementDatasetMapServiceImpl extends CommonServiceImpl<DrapRequirementDatasetMapMapper, DrapRequirementDatasetMap , DrapRequirementDatasetMapVo> implements IDrapRequirementDatasetMapService {

    @Autowired
    private DrapRequirementDatasetMapMapper mapper;


    @Override
    public boolean insertVO(DrapRequirementDatasetMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapRequirementDatasetMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapRequirementDatasetMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapRequirementDatasetMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
