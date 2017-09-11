package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataPublish;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataPublishVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataPublishMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataPublishService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据发布情况 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDataPublishServiceImpl extends CommonServiceImpl<DirDataPublishMapper, DirDataPublish , DirDataPublishVo> implements IDirDataPublishService {

    @Autowired
    private DirDataPublishMapper mapper;


    @Override
    public boolean insertVO(DirDataPublishVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataPublishVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataPublishVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataPublishVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
