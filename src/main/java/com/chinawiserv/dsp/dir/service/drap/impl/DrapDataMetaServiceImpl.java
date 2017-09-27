package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataMeta;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDataMetaVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDataMetaMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDataMetaService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据元表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDataMetaServiceImpl extends CommonServiceImpl<DrapDataMetaMapper, DrapDataMeta , DrapDataMetaVo> implements IDrapDataMetaService {

    @Autowired
    private DrapDataMetaMapper mapper;


    @Override
    public boolean insertVO(DrapDataMetaVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDataMetaVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDataMetaVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDataMetaVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
