package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyAuthorityMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyAuthorityService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 目录类别控制权限表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirClassifyAuthorityServiceImpl extends CommonServiceImpl<DirClassifyAuthorityMapper, DirClassifyAuthority , DirClassifyAuthorityVo> implements IDirClassifyAuthorityService {

    @Autowired
    private DirClassifyAuthorityMapper mapper;


    @Override
    public boolean insertVO(DirClassifyAuthorityVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirClassifyAuthorityVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirClassifyAuthorityVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirClassifyAuthorityVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
