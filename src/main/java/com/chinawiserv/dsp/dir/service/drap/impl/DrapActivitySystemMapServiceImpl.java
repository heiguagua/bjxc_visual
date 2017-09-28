package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivitySystemMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivitySystemMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivitySystemMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动关联信息系统表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivitySystemMapServiceImpl extends CommonServiceImpl<DrapActivitySystemMapMapper, DrapActivitySystemMap , DrapActivitySystemMapVo> implements IDrapActivitySystemMapService {

    @Autowired
    private DrapActivitySystemMapMapper mapper;


    @Override
    public boolean insertVO(DrapActivitySystemMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivitySystemMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivitySystemMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivitySystemMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
