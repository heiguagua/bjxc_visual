package com.chinawiserv.dsp.dir.service.drap.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.po.drap.*;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataset;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.dir.enums.catalog.Dataset;
import com.chinawiserv.dsp.dir.mapper.catalog.*;
import com.chinawiserv.dsp.dir.mapper.drap.*;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetService;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetTableRelationService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	private DirDatasetClassifyMapMapper dirDatasetClassifyMapMapper;

	@Autowired
	private DirDeptMapMapper dirClassifyDeptMapMapper;

	@Autowired
	private DirClassifyMapper dirClassifyMapper;

	@Autowired
	private DirDatasetSourceInfoMapper dirDatasetSourceInfoMapper;

	@Autowired
	private DirDatasetMapper dirDatasetMapper;

	@Autowired
	private DirDataitemMapper dirDataitemMapper;

	@Autowired
	private DirDataitemSourceInfoMapper dirDataitemSourceInfoMapper;



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
		final String drapDatasetPosStr = MapUtils.getString(dataObj, "datasetVoList");
		final List<DrapDatasetVo> drapDatasetList = JSON.parseArray(drapDatasetPosStr, DrapDatasetVo.class);
		this.drapDatasetMapper.batchInsert(drapDatasetList);
		//更新关系
		service.insertTableRelation(drapDatasetList);

		if(dataObj.containsKey("datasetSystemMapList")){
			final String datasetSystemMapPosStr = MapUtils.getString(dataObj, "datasetSystemMapList");
			final List<DrapDatasetSystemMap> drapDatasetSystemMapList = JSON.parseArray(datasetSystemMapPosStr, DrapDatasetSystemMap.class);
			this.drapDatasetSystemMapMapper.batchInsert(drapDatasetSystemMapList);
		}
		if(dataObj.containsKey("activitySetMapList")){
			final String activitySetMapPosStr = MapUtils.getString(dataObj, "activitySetMapList");
			final List<DrapActivitySetMap> drapActivitySetMapList = JSON.parseArray(activitySetMapPosStr, DrapActivitySetMap.class);
			this.drapActivitySetMapMapper.batchInsert(drapActivitySetMapList);
		}
		if(dataObj.containsKey("datasetExtFormatList")){
			final String drapDatasetExtFormatPosStr = MapUtils.getString(dataObj, "datasetExtFormatList");
			final List<DrapDatasetExtFormat> drapDatasetExtFormatList = JSON.parseArray(drapDatasetExtFormatPosStr, DrapDatasetExtFormat.class);
			this.drapDatasetExtFormatMapper.batchInsert(drapDatasetExtFormatList);
		}
		if(dataObj.containsKey("datasetSurveyList")){
			final String drapDatasetSurveyPosStr = MapUtils.getString(dataObj, "datasetSurveyList");
			final List<DrapDatasetSurvey> drapDatasetSurveyList = JSON.parseArray(drapDatasetSurveyPosStr, DrapDatasetSurvey.class);
			this.drapDatasetSurveyMapper.batchInsert(drapDatasetSurveyList);
		}

		List<DrapDatasetItem> drapDatasetItemList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemVoList")){
			String drapDatasetItemPosStr = MapUtils.getString(dataObj, "datasetItemVoList");
			drapDatasetItemList = JSON.parseArray(drapDatasetItemPosStr, DrapDatasetItem.class);
			this.drapDatasetItemMapper.batchInsert(drapDatasetItemList);
		}

		List<DrapDatasetItemMap> drapDatasetItemMapList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemMapList")){
			final String drapDatasetItemMapPosStr = MapUtils.getString(dataObj, "datasetItemMapList");
			drapDatasetItemMapList = JSON.parseArray(drapDatasetItemMapPosStr, DrapDatasetItemMap.class);
			this.drapDatasetItemMapMapper.batchInsert(drapDatasetItemMapList);
		}

		final List<DirDataset> dirDatasetList = new ArrayList<>();
		final List<DirDatasetSourceInfo> dirDatasetSourceInfoList = new ArrayList<>();
		for (DrapDatasetVo drapDatasetVo :drapDatasetList){
			final String classifyId = dirClassifyDeptMapMapper.selectByDeptId(drapDatasetVo.getBelongDeptId());
			if(classifyId != null && !"".equals(classifyId)) {
				final DirClassify dirClassify = dirClassifyMapper.selectFclassify(classifyId);
				DirDatasetClassifyMap dirDatasetClassifyMap = new DirDatasetClassifyMap();
				dirDatasetClassifyMap.setId(CommonUtil.get32UUID());
				dirDatasetClassifyMap.setDatasetId(drapDatasetVo.getId());
				dirDatasetClassifyMap.setClassifyId(classifyId);
				dirDatasetClassifyMap.setInfoResourceCode(dirClassify.getClassifyCode() + "/" + (dirClassify.getDcmIndex() + 1));
				dirDatasetClassifyMap.setStatus(Dataset.DatasetStatus.UnRegister.getKey());
				dirDatasetClassifyMap.setDeleteFlag(0);
				dirDatasetClassifyMapMapper.baseInsert(dirDatasetClassifyMap);
				dirClassifyMapper.updateClassifyIndexbyFid(classifyId);
			}

			final DirDataset dirDataset = getDirDataset(drapDatasetVo);
			dirDatasetList.add(dirDataset);
			final DirDatasetSourceInfo dirDatasetSourceInfo = new DirDatasetSourceInfo();
			dirDatasetSourceInfo.setId(CommonUtil.get32UUID());
			dirDatasetSourceInfo.setDatasetId(dirDataset.getId());
			dirDatasetSourceInfo.setSourceObjId(drapDatasetVo.getId());
			dirDatasetSourceInfoList.add(dirDatasetSourceInfo);
		}
		dirDatasetMapper.batchInsert(dirDatasetList);
		dirDatasetSourceInfoMapper.batchInsert(dirDatasetSourceInfoList);

		final List<DirDataitem> dirDataitemList = new ArrayList<>();
		final List<DirDataitemSourceInfo> dirDataitemSourceInfoList = new ArrayList<>();
		for (DrapDatasetItem drapDatasetItem : drapDatasetItemList){
			final DirDataitem dirDataitem = getDirDataitem(drapDatasetItem,drapDatasetItemMapList);
			dirDataitemList.add(dirDataitem);
			final DirDataitemSourceInfo dirDataitemSourceInfo = new DirDataitemSourceInfo();
			dirDataitemSourceInfo.setId(CommonUtil.get32UUID());
			dirDataitemSourceInfo.setItemId(dirDataitem.getId());
			dirDataitemSourceInfo.setSourceObjId(drapDatasetItem.getId());
			dirDataitemSourceInfoList.add(dirDataitemSourceInfo);
		}
		if(!dirDataitemList.isEmpty()) {
			dirDataitemMapper.batchInsert(dirDataitemList);
		}
		dirDataitemSourceInfoMapper.batchInsert(dirDataitemSourceInfoList);
	}
	
	private static DirDataset getDirDataset(DrapDatasetVo drapDatasetVo){
		final DirDataset dirDataset = new DirDataset();
		dirDataset.setId(drapDatasetVo.getId());
		dirDataset.setRegionCode(drapDatasetVo.getRegionCode());
		dirDataset.setDatasetCode(drapDatasetVo.getDatasetCode());
		dirDataset.setDatasetName(drapDatasetVo.getDatasetName());
		dirDataset.setBelongDeptId(drapDatasetVo.getBelongDeptId());
		dirDataset.setBelongDeptType(drapDatasetVo.getBelongDeptType());
		dirDataset.setDatasetDesc(drapDatasetVo.getDatasetDesc());
		dirDataset.setShareType(drapDatasetVo.getShareType());
		dirDataset.setShareCondition(drapDatasetVo.getShareConditionDesc());
		dirDataset.setShareMethodCategory(drapDatasetVo.getShareMethodCategory());
		dirDataset.setShareMethod(drapDatasetVo.getShareMethod());
		dirDataset.setShareMethodDesc(drapDatasetVo.getShareMethodDesc());
		dirDataset.setIsOpen(drapDatasetVo.getIsOpen());
		dirDataset.setOpenCondition(drapDatasetVo.getOpenCondition());
		dirDataset.setUpdateFrequency(drapDatasetVo.getUpdateFrequency());
		dirDataset.setRelDatasetCode(drapDatasetVo.getRelDatasetCode());
		dirDataset.setStorageMedium(drapDatasetVo.getStoreMedia());
		dirDataset.setStorageLocation(drapDatasetVo.getPhysicsStoreLocation());
		dirDataset.setDataLevel(drapDatasetVo.getDataLevel());
		dirDataset.setDataIndexSystem(drapDatasetVo.getDataIndexSystem());
		dirDataset.setSecretFlag(drapDatasetVo.getIsSecret());
		dirDataset.setSourceType(drapDatasetVo.getSourceType());
		dirDataset.setStatus(drapDatasetVo.getStatus().toString());
		dirDataset.setCreateUserId(drapDatasetVo.getCreateUser());
		dirDataset.setCreateTime(drapDatasetVo.getCreateTime());
		dirDataset.setUpdateUserId(drapDatasetVo.getUpdateUser());
		dirDataset.setUpdateTime(drapDatasetVo.getUpdateTime());
		dirDataset.setDeleteFlag(drapDatasetVo.getDeleteFlag());
		return dirDataset;
	}

	private static DirDataitem getDirDataitem(DrapDatasetItem drapDatasetItem,List<DrapDatasetItemMap> drapDatasetItemMapList){
		final DirDataitem dirDataitem = new DirDataitem();
		dirDataitem.setId(drapDatasetItem.getId());
		dirDataitem.setDatasetId(getDatasetIdFromItemMap(drapDatasetItemMapList, drapDatasetItem.getId()));
		dirDataitem.setItemCode(drapDatasetItem.getItemCode());
		dirDataitem.setItemName(drapDatasetItem.getItemName());
		dirDataitem.setItemType(drapDatasetItem.getItemType());
		dirDataitem.setItemDesc(drapDatasetItem.getItemDesc());
		dirDataitem.setItemLength(drapDatasetItem.getItemLength());
		dirDataitem.setBelongDeptId(drapDatasetItem.getBelongDept());
		dirDataitem.setShareType(drapDatasetItem.getShareType());
		dirDataitem.setShareCondition(drapDatasetItem.getShareConditionDesc());
		dirDataitem.setShareMethodCategory(drapDatasetItem.getShareMethodCategory());
		dirDataitem.setShareMethod(drapDatasetItem.getShareMethod());
		dirDataitem.setIsOpen(drapDatasetItem.getIsOpen());
		dirDataitem.setOpenCondition(drapDatasetItem.getOpenCondition());
		dirDataitem.setUpdateFrequency(drapDatasetItem.getUpdateFrequency());
		dirDataitem.setFormatCategory(drapDatasetItem.getFormatCategory());
		dirDataitem.setFormatInfo(drapDatasetItem.getFormatInfo());
		dirDataitem.setFormatType(drapDatasetItem.getFormatType());
		dirDataitem.setStorageMedium(drapDatasetItem.getStoreMedia());
		dirDataitem.setStorageLocation(drapDatasetItem.getPhysicsStoreLocation());
		dirDataitem.setCreateUserId(drapDatasetItem.getCreateUser());
		dirDataitem.setCreateTime(drapDatasetItem.getCreateTime());
		dirDataitem.setUpdateUserId(drapDatasetItem.getUpdateUser());
		dirDataitem.setUpdateTime(drapDatasetItem.getUpdateTime());
		dirDataitem.setDeleteFlag(drapDatasetItem.getDeleteFlag());
		return dirDataitem;
	}

	private static String getDatasetIdFromItemMap(List<DrapDatasetItemMap> drapDatasetItemMapList, String itemId) {
		for (DrapDatasetItemMap drapDatasetItemMap : drapDatasetItemMapList){
			if(Objects.equals(drapDatasetItemMap.getItemId(),itemId)){
				return drapDatasetItemMap.getDatasetId();
			}
		}
		return null;
	}
}
