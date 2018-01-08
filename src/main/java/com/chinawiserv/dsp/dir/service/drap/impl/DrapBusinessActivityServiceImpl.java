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
import com.google.common.collect.Lists;

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
		updateOrDeleteData(dataObj,true);
	}

	@Override
	public void deleteBusinessData(Map<String, Object> dataObj) throws Exception {
		updateOrDeleteData(dataObj,false);
	}

	@Override
	public void updateBusinessStatus(Map<String, Object> param) throws Exception {
		this.drapBusinessActivityMapper.updateBusinessStatus(param);
	}

	/*
	 * @param dataObj 数据
	 * @param isInsert 是否插入
	 */
	private void updateOrDeleteData(Map<String, Object> dataObj,boolean isInsert){
		if(dataObj.containsKey("drapBusinessActivityPos")){
			String drapBusinessActivityPosStr = MapUtils.getString(dataObj, "drapBusinessActivityPos");
			List<DrapBusinessActivity> drapBusinessActivityPos = JSON.parseArray(drapBusinessActivityPosStr,DrapBusinessActivity.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapBusinessActivityPos.size() ; i++){
				idList.add(drapBusinessActivityPos.get(i).getId());
			}
			this.drapBusinessActivityMapper.deleteBatchIds(idList);
			if(isInsert) this.drapBusinessActivityMapper.batchInsertPO(drapBusinessActivityPos);
		}
		if(dataObj.containsKey("drapActivityRelDeptsPos")){
			String drapActivityRelDeptsPosStr = MapUtils.getString(dataObj, "drapActivityRelDeptsPos");
			List<DrapActivityRelDepts> drapActivityRelDeptsPos = JSON.parseArray(drapActivityRelDeptsPosStr,DrapActivityRelDepts.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapActivityRelDeptsPos.size() ; i++){
				idList.add(drapActivityRelDeptsPos.get(i).getId());
			}
			this.drapActivityRelDeptsMapper.deleteBatchIds(idList);
			if(isInsert) this.drapActivityRelDeptsMapper.batchInsertPO(drapActivityRelDeptsPos);
		}
		if(dataObj.containsKey("drapActivityDocMapPos")){
			String drapActivityDocMapPosStr = MapUtils.getString(dataObj, "drapActivityDocMapPos");
			List<DrapActivityDocMap> drapActivityDocMapPos = JSON.parseArray(drapActivityDocMapPosStr,DrapActivityDocMap.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapActivityDocMapPos.size() ; i++){
				idList.add(drapActivityDocMapPos.get(i).getId());
			}
			this.drapActivityDocMapMapper.deleteBatchIds(idList);
			if(isInsert) this.drapActivityDocMapMapper.batchInsertPO(drapActivityDocMapPos);
		}
		if(dataObj.containsKey("drapBusinessDocPos")){
			String drapBusinessDocPosStr = MapUtils.getString(dataObj, "drapBusinessDocPos");
			List<DrapBusinessDoc> drapBusinessDocPos = JSON.parseArray(drapBusinessDocPosStr,DrapBusinessDoc.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapBusinessDocPos.size() ; i++){
				idList.add(drapBusinessDocPos.get(i).getId());
			}
			this.drapBusinessDocMapper.deleteBatchIds(idList);
			if(isInsert) this.drapBusinessDocMapper.batchInsertPO(drapBusinessDocPos);
		}
		if(dataObj.containsKey("drapActivityDocItemPos")){
			String drapActivityDocItemPosStr = MapUtils.getString(dataObj, "drapActivityDocItemPos");
			List<DrapActivityDocItem> drapActivityDocItemPos = JSON.parseArray(drapActivityDocItemPosStr,DrapActivityDocItem.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapActivityDocItemPos.size() ; i++){
				idList.add(drapActivityDocItemPos.get(i).getId());
			}
			this.drapActivityDocItemMapper.deleteBatchIds(idList);
			if(isInsert) this.drapActivityDocItemMapper.batchInsertPO(drapActivityDocItemPos);
		}
		if(dataObj.containsKey("drapActivitySystemMapPos")){
			String drapActivitySystemMapPosStr = MapUtils.getString(dataObj, "drapActivitySystemMapPos");
			List<DrapActivitySystemMap> drapActivitySystemMapPos = JSON.parseArray(drapActivitySystemMapPosStr,DrapActivitySystemMap.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapActivitySystemMapPos.size() ; i++){
				idList.add(drapActivitySystemMapPos.get(i).getId());
			}
			this.drapActivitySystemMapMapper.deleteBatchIds(idList);
			if(isInsert) this.drapActivitySystemMapMapper.batchInsertPO(drapActivitySystemMapPos);
		}
	}
    
    
}
