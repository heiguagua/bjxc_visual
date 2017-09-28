package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbTableInfoMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbTableInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据表信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbTableInfoServiceImpl extends CommonServiceImpl<DrapDbTableInfoMapper, DrapDbTableInfo , DrapDbTableInfoVo> implements IDrapDbTableInfoService {

    @Autowired
    private DrapDbTableInfoMapper mapper;


    @Override
    public boolean insertVO(DrapDbTableInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbTableInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbTableInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbTableInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
