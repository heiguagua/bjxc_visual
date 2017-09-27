package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDictTableInfoMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDictTableInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 字典导入数据表信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDictTableInfoServiceImpl extends CommonServiceImpl<DrapDictTableInfoMapper, DrapDictTableInfo , DrapDictTableInfoVo> implements IDrapDictTableInfoService {

    @Autowired
    private DrapDictTableInfoMapper mapper;


    @Override
    public boolean insertVO(DrapDictTableInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDictTableInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDictTableInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDictTableInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
