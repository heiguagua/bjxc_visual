package com.chinawiserv.dsp.dir.service.feedback.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCorrection;
import com.chinawiserv.dsp.dir.mapper.feedback.DirDataCorrectionMapper;
import com.chinawiserv.dsp.dir.service.feedback.IDirDataCorrectionService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据纠错记录 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataCorrectionServiceImpl extends CommonServiceImpl<DirDataCorrectionMapper, DirDataCorrection , DirDataCorrectionVo> implements IDirDataCorrectionService {

    @Autowired
    private DirDataCorrectionMapper mapper;


    @Override
    public boolean insertVO(DirDataCorrectionVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataCorrectionVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataCorrectionVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataCorrectionVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
