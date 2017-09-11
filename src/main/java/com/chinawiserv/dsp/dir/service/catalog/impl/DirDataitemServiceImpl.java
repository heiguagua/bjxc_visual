package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataitemMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataitemService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据集对应数据项表【国】 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataitemServiceImpl extends CommonServiceImpl<DirDataitemMapper, DirDataitem , DirDataitemVo> implements IDirDataitemService {

    @Autowired
    private DirDataitemMapper mapper;


    @Override
    public boolean insertVO(DirDataitemVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataitemVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataitemVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataitemVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
