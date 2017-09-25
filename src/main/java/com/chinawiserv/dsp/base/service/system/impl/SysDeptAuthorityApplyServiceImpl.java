package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityApplyVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptAuthorityApplyMapper;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityApplyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据权限申请表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@Service
public class SysDeptAuthorityApplyServiceImpl extends CommonServiceImpl<SysDeptAuthorityApplyMapper, SysDeptAuthorityApply , SysDeptAuthorityApplyVo> implements ISysDeptAuthorityApplyService {

    @Autowired
    private SysDeptAuthorityApplyMapper mapper;


    @Override
    public boolean insertVO(SysDeptAuthorityApplyVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysDeptAuthorityApplyVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysDeptAuthorityApplyVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDeptAuthorityApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
