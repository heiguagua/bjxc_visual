package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbColumnUpdateRecord;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbColumnUpdateRecordVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbColumnUpdateRecordMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbColumnUpdateRecordService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据库字段更新记录 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbColumnUpdateRecordServiceImpl extends CommonServiceImpl<DrapDbColumnUpdateRecordMapper, DrapDbColumnUpdateRecord , DrapDbColumnUpdateRecordVo> implements IDrapDbColumnUpdateRecordService {

    @Autowired
    private DrapDbColumnUpdateRecordMapper mapper;


    @Override
    public boolean insertVO(DrapDbColumnUpdateRecordVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbColumnUpdateRecordVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbColumnUpdateRecordVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbColumnUpdateRecordVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
