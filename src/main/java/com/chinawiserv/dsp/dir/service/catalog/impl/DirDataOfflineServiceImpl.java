package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataOffline;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataOfflineVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataOfflineMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataOfflineService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据下架情况 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataOfflineServiceImpl extends CommonServiceImpl<DirDataOfflineMapper, DirDataOffline , DirDataOfflineVo> implements IDirDataOfflineService {

    @Autowired
    private DirDataOfflineMapper mapper;


    @Override
    public boolean insertVO(DirDataOfflineVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataOfflineVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataOfflineVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataOfflineVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
