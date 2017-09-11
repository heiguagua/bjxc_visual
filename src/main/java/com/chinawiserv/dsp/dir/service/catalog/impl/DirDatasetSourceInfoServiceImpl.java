package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceInfo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSourceInfoVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetSourceInfoMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetSourceInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 信息资源来源信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDatasetSourceInfoServiceImpl extends CommonServiceImpl<DirDatasetSourceInfoMapper, DirDatasetSourceInfo , DirDatasetSourceInfoVo> implements IDirDatasetSourceInfoService {

    @Autowired
    private DirDatasetSourceInfoMapper mapper;


    @Override
    public boolean insertVO(DirDatasetSourceInfoVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDatasetSourceInfoVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDatasetSourceInfoVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDatasetSourceInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
