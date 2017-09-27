package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityRelDepts;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityRelDeptsVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityRelDeptsMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivityRelDeptsService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动关联部门表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivityRelDeptsServiceImpl extends CommonServiceImpl<DrapActivityRelDeptsMapper, DrapActivityRelDepts , DrapActivityRelDeptsVo> implements IDrapActivityRelDeptsService {

    @Autowired
    private DrapActivityRelDeptsMapper mapper;


    @Override
    public boolean insertVO(DrapActivityRelDeptsVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivityRelDeptsVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivityRelDeptsVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivityRelDeptsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
