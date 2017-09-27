package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemUseInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapSystemUseInfoMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemUseInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 信息系统使用信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapSystemUseInfoServiceImpl extends CommonServiceImpl<DrapSystemUseInfoMapper, DrapSystemUseInfo , DrapSystemUseInfoVo> implements IDrapSystemUseInfoService {

    @Autowired
    private DrapSystemUseInfoMapper mapper;


    @Override
    public boolean insertVO(DrapSystemUseInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapSystemUseInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapSystemUseInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapSystemUseInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
