package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataApplyVo;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataApplyMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirDataApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DirDataApplyServiceImpl extends CommonServiceImpl<DirDataApplyMapper, DirDataApply, DirDataApplyVo> implements IDirDataApplyService {

    @Autowired
    private DirDataApplyMapper mapper;

    @Override
    public boolean insertVO(DirDataApplyVo dirDataApplyVo) throws Exception {
        return false;
    }

    @Override
    public boolean updateVO(DirDataApplyVo dirDataApplyVo) throws Exception {
        return false;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public DirDataApplyVo selectVoById(String id) throws Exception {
        return null;
    }

    @Override
    public Page<DirDataApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDataApplyVo> page = getPage(paramMap);
        page.setOrderByField("apply_date");
        page.setAsc(false);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }
}
