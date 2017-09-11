package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceRelation;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSourceRelationVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetSourceRelationMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetSourceRelationService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 信息资源来源关系表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDatasetSourceRelationServiceImpl extends CommonServiceImpl<DirDatasetSourceRelationMapper, DirDatasetSourceRelation , DirDatasetSourceRelationVo> implements IDirDatasetSourceRelationService {

    @Autowired
    private DirDatasetSourceRelationMapper mapper;


    @Override
    public boolean insertVO(DirDatasetSourceRelationVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDatasetSourceRelationVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDatasetSourceRelationVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDatasetSourceRelationVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
