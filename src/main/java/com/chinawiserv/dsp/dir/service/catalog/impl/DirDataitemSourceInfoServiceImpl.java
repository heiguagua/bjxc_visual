package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitemSourceInfo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemSourceInfoVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataitemSourceInfoMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataitemSourceInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据项来源信息表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataitemSourceInfoServiceImpl extends CommonServiceImpl<DirDataitemSourceInfoMapper, DirDataitemSourceInfo , DirDataitemSourceInfoVo> implements IDirDataitemSourceInfoService {

    @Autowired
    private DirDataitemSourceInfoMapper mapper;


    @Override
    public boolean insertVO(DirDataitemSourceInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataitemSourceInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataitemSourceInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataitemSourceInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
