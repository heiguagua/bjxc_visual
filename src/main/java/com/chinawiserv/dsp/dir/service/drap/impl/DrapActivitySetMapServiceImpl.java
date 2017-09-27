package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivitySetMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivitySetMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivitySetMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 信息资源关联业务表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivitySetMapServiceImpl extends CommonServiceImpl<DrapActivitySetMapMapper, DrapActivitySetMap , DrapActivitySetMapVo> implements IDrapActivitySetMapService {

    @Autowired
    private DrapActivitySetMapMapper mapper;


    @Override
    public boolean insertVO(DrapActivitySetMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivitySetMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivitySetMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivitySetMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
