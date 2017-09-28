package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetSystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetSystemMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetSystemMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetSystemMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 信息资源关联信息系统 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDatasetSystemMapServiceImpl extends CommonServiceImpl<DrapDatasetSystemMapMapper, DrapDatasetSystemMap , DrapDatasetSystemMapVo> implements IDrapDatasetSystemMapService {

    @Autowired
    private DrapDatasetSystemMapMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetSystemMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetSystemMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetSystemMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetSystemMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
