package com.chinawiserv.dsp.dir.service.drap.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.*;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.dir.mapper.drap.*;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetService;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetTableRelationService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息资源（数据集） 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDatasetServiceImpl extends CommonServiceImpl<DrapDatasetMapper, DrapDataset , DrapDatasetVo> implements IDrapDatasetService {

    @Autowired
    private DrapDatasetMapper drapDatasetMapper;

	@Autowired
	private DrapDatasetSystemMapMapper drapDatasetSystemMapMapper;

	@Autowired
	private DrapActivitySetMapMapper drapActivitySetMapMapper;

	@Autowired
	private DrapDatasetExtFormatMapper drapDatasetExtFormatMapper;

	@Autowired
	private DrapDatasetSurveyMapper drapDatasetSurveyMapper;

	@Autowired
	private DrapDatasetItemMapper drapDatasetItemMapper;

	@Autowired
	private DrapDatasetItemMapMapper drapDatasetItemMapMapper;

    @Autowired
    private IDrapDatasetTableRelationService service;
    @Override
    public boolean insertVO(DrapDatasetVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

	@Override
	public void insertDataset(Map<String, Object> dataObj) {
		if(dataObj.containsKey("datasetVoList")){
			String drapDatasetPosStr = MapUtils.getString(dataObj, "datasetVoList");
			List<DrapDatasetVo> drapDatasetList = JSON.parseArray(drapDatasetPosStr, DrapDatasetVo.class);
			this.drapDatasetMapper.batchInsert(drapDatasetList);
			//更新关系
			service.insertTableRelation(drapDatasetList);
		}
		if(dataObj.containsKey("datasetSystemMapList")){
			String datasetSystemMapPosStr = MapUtils.getString(dataObj, "datasetSystemMapList");
			List<DrapDatasetSystemMap> drapDatasetSystemMapList = JSON.parseArray(datasetSystemMapPosStr, DrapDatasetSystemMap.class);
			this.drapDatasetSystemMapMapper.batchInsert(drapDatasetSystemMapList);
		}
		if(dataObj.containsKey("activitySetMapList")){
			String activitySetMapPosStr = MapUtils.getString(dataObj, "activitySetMapList");
			List<DrapActivitySetMap> drapActivitySetMapList = JSON.parseArray(activitySetMapPosStr, DrapActivitySetMap.class);
			this.drapActivitySetMapMapper.batchInsert(drapActivitySetMapList);
		}
		if(dataObj.containsKey("datasetExtFormatList")){
			String drapDatasetExtFormatPosStr = MapUtils.getString(dataObj, "datasetExtFormatList");
			List<DrapDatasetExtFormat> drapDatasetExtFormatList = JSON.parseArray(drapDatasetExtFormatPosStr, DrapDatasetExtFormat.class);
			this.drapDatasetExtFormatMapper.batchInsert(drapDatasetExtFormatList);
		}
		if(dataObj.containsKey("datasetSurveyList")){
			String drapDatasetSurveyPosStr = MapUtils.getString(dataObj, "datasetSurveyList");
			List<DrapDatasetSurvey> drapDatasetSurveyList = JSON.parseArray(drapDatasetSurveyPosStr, DrapDatasetSurvey.class);
			this.drapDatasetSurveyMapper.batchInsert(drapDatasetSurveyList);
		}
		if(dataObj.containsKey("datasetItemVoList")){
			String drapDatasetItemPosStr = MapUtils.getString(dataObj, "datasetItemVoList");
			List<DrapDatasetItem> drapDatasetItemList = JSON.parseArray(drapDatasetItemPosStr, DrapDatasetItem.class);
			this.drapDatasetItemMapper.batchInsert(drapDatasetItemList);
		}
		if(dataObj.containsKey("datasetItemMapList")){
			String drapDatasetItemMapPosStr = MapUtils.getString(dataObj, "datasetItemMapList");
			List<DrapDatasetItemMap> drapDatasetItemMapList = JSON.parseArray(drapDatasetItemMapPosStr, DrapDatasetItemMap.class);
			this.drapDatasetItemMapMapper.batchInsert(drapDatasetItemMapList);
		}
	}
}
