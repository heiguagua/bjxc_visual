package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessActivity;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessActivityVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessActivityMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessActivityService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessActivityServiceImpl extends CommonServiceImpl<DrapBusinessActivityMapper, DrapBusinessActivity , DrapBusinessActivityVo> implements IDrapBusinessActivityService {

    @Autowired
    private DrapBusinessActivityMapper mapper;


    @Override
    public boolean insertVO(DrapBusinessActivityVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessActivityVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessActivityVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessActivityVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
