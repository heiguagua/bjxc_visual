package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;

import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetAttachment;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetAttachmentVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetAttachmentMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tx
 * @since 2017-11-28
 */
@Service
public class DirDatasetAttachmentServiceImpl extends CommonServiceImpl<DirDatasetAttachmentMapper, DirDatasetAttachment, DirDatasetAttachmentVo> implements IDirDatasetAttachmentService {

    @Autowired
    private DirDatasetAttachmentMapper mapper;


    @Override
    public boolean insertVO(DirDatasetAttachmentVo vo) throws Exception {
        int insertResult = mapper.baseInsert(vo);
		return insertResult>0;
    }

    @Override
    public boolean batchInsertVo(List<DirDatasetAttachmentVo> voList) throws Exception{
        int insertResult = mapper.insertListItem(voList);
        return insertResult>0;
    }

    @Override
    public boolean updateVO(DirDatasetAttachmentVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDatasetAttachmentVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDatasetAttachmentVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDatasetAttachmentVo> page = getPage(paramMap);
        page.setOrderByField("upload_time");
        page.setAsc(false);
        List<DirDatasetAttachmentVo> dirDatasetAttachmentVoList = mapper.selectVoPage(page, paramMap);
        page.setRecords(dirDatasetAttachmentVoList);
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
