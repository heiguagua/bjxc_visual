package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataAudit;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataAuditVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataAuditMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataAuditService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据审核情况表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataAuditServiceImpl extends CommonServiceImpl<DirDataAuditMapper, DirDataAudit , DirDataAuditVo> implements IDirDataAuditService {

    @Autowired
    private DirDataAuditMapper mapper;


    @Override
    public boolean insertVO(DirDataAuditVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataAuditVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataAuditVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataAuditVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
