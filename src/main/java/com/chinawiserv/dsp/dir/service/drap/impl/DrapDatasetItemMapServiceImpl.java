package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetItemMapVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetItemMapMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetItemMapService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据集数据项关联表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDatasetItemMapServiceImpl extends CommonServiceImpl<DrapDatasetItemMapMapper, DrapDatasetItemMap , DrapDatasetItemMapVo> implements IDrapDatasetItemMapService {

    @Autowired
    private DrapDatasetItemMapMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetItemMapVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetItemMapVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetItemMapVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetItemMapVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
