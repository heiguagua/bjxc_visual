package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirNews;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirNewsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirNewsService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 新闻表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirNewsServiceImpl extends CommonServiceImpl<DirNewsMapper, DirNews , DirNewsVo> implements IDirNewsService {

    @Autowired
    private DirNewsMapper mapper;


    @Override
    public boolean insertVO(DirNewsVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirNewsVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirNewsVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirNewsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
