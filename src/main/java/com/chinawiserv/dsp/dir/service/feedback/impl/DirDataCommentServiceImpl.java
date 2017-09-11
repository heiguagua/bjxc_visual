package com.chinawiserv.dsp.dir.service.feedback.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataComment;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCommentVo;
import com.chinawiserv.dsp.dir.mapper.feedback.DirDataCommentMapper;
import com.chinawiserv.dsp.dir.service.feedback.IDirDataCommentService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据集评论记录 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataCommentServiceImpl extends CommonServiceImpl<DirDataCommentMapper, DirDataComment , DirDataCommentVo> implements IDirDataCommentService {

    @Autowired
    private DirDataCommentMapper mapper;


    @Override
    public boolean insertVO(DirDataCommentVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataCommentVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataCommentVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataCommentVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
