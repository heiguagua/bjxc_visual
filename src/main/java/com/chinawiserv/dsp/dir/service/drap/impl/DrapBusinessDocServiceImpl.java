package com.chinawiserv.dsp.dir.service.drap.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocItem;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityRelDepts;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySystemMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessActivity;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessDoc;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessDocVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapActivityDocItemMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessDocMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessDocService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.google.common.collect.Lists;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务活动资料 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessDocServiceImpl extends CommonServiceImpl<DrapBusinessDocMapper, DrapBusinessDoc , DrapBusinessDocVo> implements IDrapBusinessDocService {

    @Autowired
    private DrapBusinessDocMapper drapBusinessDocMapper;
    
    @Autowired
    DrapActivityDocItemMapper drapActivityDocItemMapper;


    @Override
    public boolean insertVO(DrapBusinessDocVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessDocVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessDocVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessDocVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
    
    @Override
	public void updateBusinessDocData(Map<String, Object> dataObj) throws Exception{
		
		if(dataObj.containsKey("drapBusinessDocPos")){
			String drapBusinessDocPosStr = MapUtils.getString(dataObj, "drapBusinessDocPos");
			List<DrapBusinessDoc> drapBusinessDocPos = JSON.parseArray(drapBusinessDocPosStr,DrapBusinessDoc.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapBusinessDocPos.size() ; i++){
				idList.add(drapBusinessDocPos.get(i).getId());
			}
			this.drapBusinessDocMapper.deleteBatchIds(idList);
			this.drapBusinessDocMapper.batchInsertPO(drapBusinessDocPos);
		}
		if(dataObj.containsKey("drapActivityDocItemPos")){
			String drapActivityDocItemPosStr = MapUtils.getString(dataObj, "drapActivityDocItemPos");
			List<DrapActivityDocItem> drapActivityDocItemPos = JSON.parseArray(drapActivityDocItemPosStr,DrapActivityDocItem.class);
			List<String> idList = Lists.newArrayList();
			for(int i = 0 ; i < drapActivityDocItemPos.size() ; i++){
				idList.add(drapActivityDocItemPos.get(i).getId());
			}
			this.drapActivityDocItemMapper.deleteBatchIds(idList);
			this.drapActivityDocItemMapper.batchInsertPO(drapActivityDocItemPos);
		}
	}
}
