package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitemDistribute;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemDistributeVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataitemDistributeMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataitemDistributeService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据项权限分配表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataitemDistributeServiceImpl extends CommonServiceImpl<DirDataitemDistributeMapper, DirDataitemDistribute , DirDataitemDistributeVo> implements IDirDataitemDistributeService {

    @Autowired
    private DirDataitemDistributeMapper mapper;


    @Override
    public boolean insertVO(DirDataitemDistributeVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataitemDistributeVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataitemDistributeVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataitemDistributeVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
