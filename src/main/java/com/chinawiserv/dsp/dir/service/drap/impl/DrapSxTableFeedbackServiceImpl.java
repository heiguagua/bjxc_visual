package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSxTableFeedback;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSxTableFeedbackVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapSxTableFeedbackMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapSxTableFeedbackService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据表反馈记录(淞幸) 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapSxTableFeedbackServiceImpl extends CommonServiceImpl<DrapSxTableFeedbackMapper, DrapSxTableFeedback , DrapSxTableFeedbackVo> implements IDrapSxTableFeedbackService {

    @Autowired
    private DrapSxTableFeedbackMapper mapper;


    @Override
    public boolean insertVO(DrapSxTableFeedbackVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapSxTableFeedbackVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapSxTableFeedbackVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapSxTableFeedbackVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
