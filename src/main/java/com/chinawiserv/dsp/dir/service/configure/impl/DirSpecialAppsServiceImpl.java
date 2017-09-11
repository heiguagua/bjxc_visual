package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirSpecialAppsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirSpecialAppsService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 专题应用表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirSpecialAppsServiceImpl extends CommonServiceImpl<DirSpecialAppsMapper, DirSpecialApps , DirSpecialAppsVo> implements IDirSpecialAppsService {

    @Autowired
    private DirSpecialAppsMapper mapper;


    @Override
    public boolean insertVO(DirSpecialAppsVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirSpecialAppsVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirSpecialAppsVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirSpecialAppsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
