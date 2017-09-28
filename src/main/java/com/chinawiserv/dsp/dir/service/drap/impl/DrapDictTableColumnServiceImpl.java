package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableColumn;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableColumnVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDictTableColumnMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDictTableColumnService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 字典导入数据表字段信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDictTableColumnServiceImpl extends CommonServiceImpl<DrapDictTableColumnMapper, DrapDictTableColumn , DrapDictTableColumnVo> implements IDrapDictTableColumnService {

    @Autowired
    private DrapDictTableColumnMapper mapper;


    @Override
    public boolean insertVO(DrapDictTableColumnVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDictTableColumnVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDictTableColumnVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDictTableColumnVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
