package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbSystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbSystemMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbSystemMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbSystemMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据库业务系统关系表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbSystemMapServiceImpl extends CommonServiceImpl<DrapDbSystemMapMapper, DrapDbSystemMap , DrapDbSystemMapVo> implements IDrapDbSystemMapService {

    @Autowired
    private DrapDbSystemMapMapper mapper;


    @Override
    public boolean insertVO(DrapDbSystemMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbSystemMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbSystemMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbSystemMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
