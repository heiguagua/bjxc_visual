package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetExtFormat;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetExtFormatVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetExtFormatMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetExtFormatService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 梳理数据集扩展信息（【国】资源格式） 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
@Service
public class DrapDatasetExtFormatServiceImpl extends CommonServiceImpl<DrapDatasetExtFormatMapper, DrapDatasetExtFormat , DrapDatasetExtFormatVo> implements IDrapDatasetExtFormatService {

    @Autowired
    private DrapDatasetExtFormatMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetExtFormatVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetExtFormatVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetExtFormatVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetExtFormatVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
