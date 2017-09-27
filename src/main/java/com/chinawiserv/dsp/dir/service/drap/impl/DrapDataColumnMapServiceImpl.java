package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataColumnMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDataColumnMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDataColumnMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDataColumnMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据项与表字段关系梳理表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDataColumnMapServiceImpl extends CommonServiceImpl<DrapDataColumnMapMapper, DrapDataColumnMap , DrapDataColumnMapVo> implements IDrapDataColumnMapService {

    @Autowired
    private DrapDataColumnMapMapper mapper;


    @Override
    public boolean insertVO(DrapDataColumnMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDataColumnMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDataColumnMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDataColumnMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
