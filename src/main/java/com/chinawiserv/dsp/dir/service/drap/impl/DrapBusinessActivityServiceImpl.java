package com.chinawiserv.dsp.dir.service.drap.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocItem;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityRelDepts;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySystemMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessActivity;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessDoc;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessActivityVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityDocItemMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityDocMapMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityRelDeptsMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivitySystemMapMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessActivityMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessDocMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessActivityService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务活动表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessActivityServiceImpl extends CommonServiceImpl<DrapBusinessActivityMapper, DrapBusinessActivity , DrapBusinessActivityVo> implements IDrapBusinessActivityService {

    @Autowired
    private DrapBusinessActivityMapper drapBusinessActivityMapper;
    
    @Autowired
    DrapActivityRelDeptsMapper drapActivityRelDeptsMapper;
    
    @Autowired
    DrapActivityDocMapMapper drapActivityDocMapMapper;
    
    @Autowired
    DrapBusinessDocMapper drapBusinessDocMapper;
    
    @Autowired
    DrapActivityDocItemMapper drapActivityDocItemMapper;
    
    @Autowired
    DrapActivitySystemMapMapper drapActivitySystemMapMapper;


    @Override
    public boolean insertVO(DrapBusinessActivityVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessActivityVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessActivityVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessActivityVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

	@Override
	public void updateBusinessData(Map<String, Object> dataObj) throws Exception{
		
		if(dataObj.containsKey("drapBusinessActivityPos")){
			String drapBusinessActivityPosStr = MapUtils.getString(dataObj, "drapBusinessActivityPos");
			List<DrapBusinessActivity> drapBusinessActivityPos = JSON.parseArray(drapBusinessActivityPosStr,DrapBusinessActivity.class);
			this.drapBusinessActivityMapper.batchInsertPO(drapBusinessActivityPos);
		}
		if(dataObj.containsKey("drapActivityRelDeptsPos")){
			String drapActivityRelDeptsPosStr = MapUtils.getString(dataObj, "drapActivityRelDeptsPos");
			List<DrapActivityRelDepts> drapActivityRelDeptsPos = JSON.parseArray(drapActivityRelDeptsPosStr,DrapActivityRelDepts.class);
			this.drapActivityRelDeptsMapper.batchInsertPO(drapActivityRelDeptsPos);
		}
		if(dataObj.containsKey("drapActivityDocMapPos")){
			String drapActivityDocMapPosStr = MapUtils.getString(dataObj, "drapActivityDocMapPos");
			List<DrapActivityDocMap> drapActivityDocMapPos = JSON.parseArray(drapActivityDocMapPosStr,DrapActivityDocMap.class);
			this.drapActivityDocMapMapper.batchInsertPO(drapActivityDocMapPos);
		}
		if(dataObj.containsKey("drapBusinessDocPos")){
			String drapBusinessDocPosStr = MapUtils.getString(dataObj, "drapBusinessDocPos");
			List<DrapBusinessDoc> drapBusinessDocPos = JSON.parseArray(drapBusinessDocPosStr,DrapBusinessDoc.class);
			this.drapBusinessDocMapper.batchInsertPO(drapBusinessDocPos);
		}
		if(dataObj.containsKey("drapActivityDocItemPos")){
			String drapActivityDocItemPosStr = MapUtils.getString(dataObj, "drapActivityDocItemPos");
			List<DrapActivityDocItem> drapActivityDocItemPos = JSON.parseArray(drapActivityDocItemPosStr,DrapActivityDocItem.class);
			this.drapActivityDocItemMapper.batchInsertPO(drapActivityDocItemPos);
		}
		if(dataObj.containsKey("drapActivitySystemMapPos")){
			String drapActivitySystemMapPosStr = MapUtils.getString(dataObj, "drapActivitySystemMapPos");
			List<DrapActivitySystemMap> drapActivitySystemMapPos = JSON.parseArray(drapActivitySystemMapPosStr,DrapActivitySystemMap.class);
			this.drapActivitySystemMapMapper.batchInsertPO(drapActivitySystemMapPos);
		}
	}
    
    
}
