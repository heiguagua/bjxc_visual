package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityDocItemVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityDocItemMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapActivityDocItemService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务活动资料数据项表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapActivityDocItemServiceImpl extends CommonServiceImpl<DrapActivityDocItemMapper, DrapActivityDocItem , DrapActivityDocItemVo> implements IDrapActivityDocItemService {

    @Autowired
    private DrapActivityDocItemMapper mapper;


    @Override
    public boolean insertVO(DrapActivityDocItemVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapActivityDocItemVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapActivityDocItemVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapActivityDocItemVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
