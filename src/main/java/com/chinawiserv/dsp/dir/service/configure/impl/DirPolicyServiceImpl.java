package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirPolicy;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirPolicyVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirPolicyMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirPolicyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 政策表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirPolicyServiceImpl extends CommonServiceImpl<DirPolicyMapper, DirPolicy , DirPolicyVo> implements IDirPolicyService {

    @Autowired
    private DirPolicyMapper mapper;


    @Override
    public boolean updateVO(DirPolicyVo vo) throws Exception {
        //todo
        boolean b=true;
        int i = mapper.baseUpdate(vo);
        if(i<1){
            b=false;
        }
        return b;
    }

    @Override
    public boolean insertVO(DirPolicyVo vo) throws Exception {
		//todo
        boolean b=true;
        int i = mapper.baseInsert(vo);
        if(i<1){
            b=false;
        }
        return b;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirPolicyVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public Page<DirPolicyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirPolicyVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirPolicyVo> voPage = mapper.selectVoPage(page, paramMap);
        page.setRecords(voPage);
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
