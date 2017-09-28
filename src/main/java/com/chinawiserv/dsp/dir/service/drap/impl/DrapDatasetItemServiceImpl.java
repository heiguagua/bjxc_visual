package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetItemVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetItemMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetItemService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 业务数据项【国】 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDatasetItemServiceImpl extends CommonServiceImpl<DrapDatasetItemMapper, DrapDatasetItem , DrapDatasetItemVo> implements IDrapDatasetItemService {

    @Autowired
    private DrapDatasetItemMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetItemVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetItemVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetItemVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetItemVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
