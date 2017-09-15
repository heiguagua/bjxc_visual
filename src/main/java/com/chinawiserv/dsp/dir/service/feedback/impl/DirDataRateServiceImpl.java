package com.chinawiserv.dsp.dir.service.feedback.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataRate;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataRateVo;
import com.chinawiserv.dsp.dir.mapper.feedback.DirDataRateMapper;
import com.chinawiserv.dsp.dir.service.feedback.IDirDataRateService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据集评分记录 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataRateServiceImpl extends CommonServiceImpl<DirDataRateMapper, DirDataRate , DirDataRateVo> implements IDirDataRateService {

    @Autowired
    private DirDataRateMapper mapper;


    @Override
    public boolean insertVO(DirDataRateVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataRateVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataRateVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataRateVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDataRateVo> page = getPage(paramMap);
        if (!paramMap.containsKey("sortName")) {
            page.setOrderByField("rate_date");
            page.setAsc(false);
        }
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
