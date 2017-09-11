package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataitemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataitemApplyMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirDataitemApplyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据项权限申请表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataitemApplyServiceImpl extends CommonServiceImpl<DirDataitemApplyMapper, DirDataitemApply , DirDataitemApplyVo> implements IDirDataitemApplyService {

    @Autowired
    private DirDataitemApplyMapper mapper;


    @Override
    public boolean insertVO(DirDataitemApplyVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataitemApplyVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataitemApplyVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataitemApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
