package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityDocMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityDocMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivityDocMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动关联资料表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivityDocMapServiceImpl extends CommonServiceImpl<DrapActivityDocMapMapper, DrapActivityDocMap , DrapActivityDocMapVo> implements IDrapActivityDocMapService {

    @Autowired
    private DrapActivityDocMapMapper mapper;


    @Override
    public boolean insertVO(DrapActivityDocMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivityDocMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivityDocMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivityDocMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
