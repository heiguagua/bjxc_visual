package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableColumn;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableColumnVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbTableColumnMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbTableColumnService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据表字段信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbTableColumnServiceImpl extends CommonServiceImpl<DrapDbTableColumnMapper, DrapDbTableColumn , DrapDbTableColumnVo> implements IDrapDbTableColumnService {

    @Autowired
    private DrapDbTableColumnMapper mapper;


    @Override
    public boolean insertVO(DrapDbTableColumnVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDbTableColumnVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDbTableColumnVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDbTableColumnVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
