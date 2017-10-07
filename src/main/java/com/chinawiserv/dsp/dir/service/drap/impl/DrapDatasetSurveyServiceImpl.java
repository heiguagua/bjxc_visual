package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetSurvey;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetSurveyVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetSurveyMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetSurveyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 梳理信息资源大普查信息表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
@Service
public class DrapDatasetSurveyServiceImpl extends CommonServiceImpl<DrapDatasetSurveyMapper, DrapDatasetSurvey , DrapDatasetSurveyVo> implements IDrapDatasetSurveyService {

    @Autowired
    private DrapDatasetSurveyMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetSurveyVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetSurveyVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetSurveyVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetSurveyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
