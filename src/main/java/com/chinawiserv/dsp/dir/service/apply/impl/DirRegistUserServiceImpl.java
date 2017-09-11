package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirRegistUser;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirRegistUserVo;
import com.chinawiserv.dsp.dir.mapper.apply.DirRegistUserMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirRegistUserService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 用户注册表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirRegistUserServiceImpl extends CommonServiceImpl<DirRegistUserMapper, DirRegistUser , DirRegistUserVo> implements IDirRegistUserService {

    @Autowired
    private DirRegistUserMapper mapper;


    @Override
    public boolean insertVO(DirRegistUserVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirRegistUserVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirRegistUserVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirRegistUserVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
