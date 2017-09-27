package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityPreRelation;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityPreRelationVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityPreRelationMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivityPreRelationService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动前置关系表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivityPreRelationServiceImpl extends CommonServiceImpl<DrapActivityPreRelationMapper, DrapActivityPreRelation , DrapActivityPreRelationVo> implements IDrapActivityPreRelationService {

    @Autowired
    private DrapActivityPreRelationMapper mapper;


    @Override
    public boolean insertVO(DrapActivityPreRelationVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivityPreRelationVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivityPreRelationVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivityPreRelationVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
