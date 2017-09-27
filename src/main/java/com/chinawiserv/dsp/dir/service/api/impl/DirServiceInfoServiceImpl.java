package com.chinawiserv.dsp.dir.service.api.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;
import com.chinawiserv.dsp.dir.entity.vo.service.DirServiceInfoVo;
import com.chinawiserv.dsp.dir.mapper.api.DirServiceInfoMapper;
import com.chinawiserv.dsp.dir.service.api.IDirServiceInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 发布服务信息表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-26
 */
@Service
public class DirServiceInfoServiceImpl extends CommonServiceImpl<DirServiceInfoMapper, DirServiceInfo , DirServiceInfoVo> implements IDirServiceInfoService {

    @Autowired
    private DirServiceInfoMapper mapper;


    @Override
    public boolean insertVO(DirServiceInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirServiceInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirServiceInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirServiceInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
