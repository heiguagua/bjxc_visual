package com.chinawiserv.dsp.dir.service.feedback.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCollection;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCollectionVo;
import com.chinawiserv.dsp.dir.mapper.feedback.DirDataCollectionMapper;
import com.chinawiserv.dsp.dir.service.feedback.IDirDataCollectionService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 数据集收藏记录 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataCollectionServiceImpl extends CommonServiceImpl<DirDataCollectionMapper, DirDataCollection , DirDataCollectionVo> implements IDirDataCollectionService {

    @Autowired
    private DirDataCollectionMapper mapper;


    @Override
    public boolean insertVO(DirDataCollectionVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataCollectionVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataCollectionVo selectVoById(String id) throws Exception {
		return null;
	}
    /**
     * 分页查询收藏列表
     * */
    @Override
    public Page<DirDataCollectionVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDataCollectionVo> page = getPage(paramMap);
        if (!paramMap.containsKey("sortName")) {
            page.setOrderByField("collect_date");
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
