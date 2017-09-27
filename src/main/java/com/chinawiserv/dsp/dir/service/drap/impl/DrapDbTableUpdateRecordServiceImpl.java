package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableUpdateRecord;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableUpdateRecordVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbTableUpdateRecordMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbTableUpdateRecordService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据库表更新记录表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbTableUpdateRecordServiceImpl extends CommonServiceImpl<DrapDbTableUpdateRecordMapper, DrapDbTableUpdateRecord , DrapDbTableUpdateRecordVo> implements IDrapDbTableUpdateRecordService {

    @Autowired
    private DrapDbTableUpdateRecordMapper mapper;


    @Override
    public boolean insertVO(DrapDbTableUpdateRecordVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbTableUpdateRecordVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbTableUpdateRecordVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbTableUpdateRecordVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
