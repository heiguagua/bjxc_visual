package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirDevelopApisMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirDevelopApisService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 开发者工具 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDevelopApisServiceImpl extends CommonServiceImpl<DirDevelopApisMapper, DirDevelopApis , DirDevelopApisVo> implements IDirDevelopApisService {

    @Autowired
    private DirDevelopApisMapper mapper;


    @Override
    public boolean insertVO(DirDevelopApisVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDevelopApisVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDevelopApisVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDevelopApisVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
