package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemService;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemServiceVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapSystemServiceMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemServiceService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 系统服务表(NO) 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapSystemServiceServiceImpl extends CommonServiceImpl<DrapSystemServiceMapper, DrapSystemService , DrapSystemServiceVo> implements IDrapSystemServiceService {

    @Autowired
    private DrapSystemServiceMapper mapper;


    @Override
    public boolean insertVO(DrapSystemServiceVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapSystemServiceVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapSystemServiceVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapSystemServiceVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
