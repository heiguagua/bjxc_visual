package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyDeptMapVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyDeptMapMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyDeptMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 部门分类关联表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-11-08
 */
@Service
public class DirClassifyDeptMapServiceImpl extends CommonServiceImpl<DirClassifyDeptMapMapper, DirClassifyDeptMap, DirClassifyDeptMapVo> implements IDirClassifyDeptMapService {

    @Autowired
    private DirClassifyDeptMapMapper mapper;


    @Override
    public boolean insertVO(DirClassifyDeptMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirClassifyDeptMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirClassifyDeptMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirClassifyDeptMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
