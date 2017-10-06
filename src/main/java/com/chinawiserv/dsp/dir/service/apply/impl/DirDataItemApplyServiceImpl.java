package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataItemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataItemApplyVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.DataItemStatus;
import com.chinawiserv.dsp.dir.enums.apply.SourceTypeEnum;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataItemApplyMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirDataItemApplyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class DirDataItemApplyServiceImpl extends CommonServiceImpl<DirDataItemApplyMapper, DirDataItemApply, DirDataItemApplyVo> implements IDirDataItemApplyService {

    @Autowired
    private DirDataItemApplyMapper dirDataItemApplyMapper;


    @Override
    public boolean insertVO(DirDataItemApplyVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataItemApplyVo vo) throws Exception {
        return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataItemApplyVo selectVoById(String id) throws Exception {
		return dirDataItemApplyMapper.selectVoById(id);
	}

    @Override
    public Page<DirDataItemApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDataItemApplyVo> page = getPage(paramMap);
        page.setTotal(dirDataItemApplyMapper.selectVoCount(paramMap));
        page.setRecords(dirDataItemApplyMapper.selectVoPage(page, paramMap));
        return page;
	}


    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
