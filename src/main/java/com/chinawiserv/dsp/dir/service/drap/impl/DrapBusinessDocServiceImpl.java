package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessDoc;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessDocVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessDocMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessDocService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动资料 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessDocServiceImpl extends CommonServiceImpl<DrapBusinessDocMapper, DrapBusinessDoc , DrapBusinessDocVo> implements IDrapBusinessDocService {

    @Autowired
    private DrapBusinessDocMapper mapper;


    @Override
    public boolean insertVO(DrapBusinessDocVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessDocVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessDocVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessDocVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
