package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapItemRequiredDept;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapItemRequiredDeptVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapItemRequiredDeptMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapItemRequiredDeptService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务数据项关联需求部门(NO) 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapItemRequiredDeptServiceImpl extends CommonServiceImpl<DrapItemRequiredDeptMapper, DrapItemRequiredDept , DrapItemRequiredDeptVo> implements IDrapItemRequiredDeptService {

    @Autowired
    private DrapItemRequiredDeptMapper mapper;


    @Override
    public boolean insertVO(DrapItemRequiredDeptVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapItemRequiredDeptVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapItemRequiredDeptVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapItemRequiredDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
