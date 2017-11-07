package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementResources;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementResourcesVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapRequirementResourcesMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapRequirementResourcesService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 需求资源信息表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapRequirementResourcesServiceImpl extends CommonServiceImpl<DrapRequirementResourcesMapper, DrapRequirementResources , DrapRequirementResourcesVo> implements IDrapRequirementResourcesService {

    @Autowired
    private DrapRequirementResourcesMapper mapper;


    @Override
    public boolean insertVO(DrapRequirementResourcesVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapRequirementResourcesVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapRequirementResourcesVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public Page<DrapRequirementResourcesVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
        Page<DrapRequirementResourcesVo> page = getPage(paramMap);
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
