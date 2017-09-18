package com.chinawiserv.dsp.dir.service.feedback.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirSuggestion;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirSuggestionVo;
import com.chinawiserv.dsp.dir.mapper.feedback.DirSuggestionMapper;
import com.chinawiserv.dsp.dir.service.feedback.IDirSuggestionService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 咨询建议表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirSuggestionServiceImpl extends CommonServiceImpl<DirSuggestionMapper, DirSuggestion , DirSuggestionVo> implements IDirSuggestionService {

    @Autowired
    private DirSuggestionMapper mapper;


    @Override
    public boolean insertVO(DirSuggestionVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirSuggestionVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirSuggestionVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirSuggestionVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirSuggestionVo> page = getPage(paramMap);
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public int baseDeleteById(String id) {
        return mapper.baseDelete(id);
    }
}
