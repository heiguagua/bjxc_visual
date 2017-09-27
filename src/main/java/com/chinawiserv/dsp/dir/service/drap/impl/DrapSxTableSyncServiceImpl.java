package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSxTableSync;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSxTableSyncVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapSxTableSyncMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapSxTableSyncService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据表同步记录(淞幸) 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapSxTableSyncServiceImpl extends CommonServiceImpl<DrapSxTableSyncMapper, DrapSxTableSync , DrapSxTableSyncVo> implements IDrapSxTableSyncService {

    @Autowired
    private DrapSxTableSyncMapper mapper;


    @Override
    public boolean insertVO(DrapSxTableSyncVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapSxTableSyncVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapSxTableSyncVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapSxTableSyncVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
