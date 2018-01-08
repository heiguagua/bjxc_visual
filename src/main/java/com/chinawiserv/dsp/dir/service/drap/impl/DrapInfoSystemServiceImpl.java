package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapInfoSystem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapInfoSystemVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapInfoSystemMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapInfoSystemService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息系统表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapInfoSystemServiceImpl extends CommonServiceImpl<DrapInfoSystemMapper, DrapInfoSystem , DrapInfoSystemVo> implements IDrapInfoSystemService {

    @Autowired
    private DrapInfoSystemMapper mapper;


    @Override
    public boolean insertVO(DrapInfoSystemVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapInfoSystemVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapInfoSystemVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapInfoSystemVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
	@Override
	public void updateAuditRebut(List<String> ids){
        mapper.updateAuditRebut(ids);
    }
}
