package com.chinawiserv.dsp.dir.service.drap.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.mapper.system.SysDictMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.po.drap.*;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataset;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.AuditEntity;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.dir.enums.catalog.Dataset;
import com.chinawiserv.dsp.dir.mapper.catalog.*;
import com.chinawiserv.dsp.dir.mapper.drap.*;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetService;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetTableRelationService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

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
	private DirDatasetExtFormatMapper dirDatasetExtFormatMapper;

	@Autowired
	private DirDatasetSurveyMapper dirDatasetSurveyMapper;

	@Autowired
	private DirDataitemMapper dirDataitemMapper;

	@Autowired
	private DirDataitemSourceInfoMapper dirDataitemSourceInfoMapper;

	@Autowired
	private SysDictMapper sysDictMapper;

	@Autowired
	private ISysDeptService sysDeptService;



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
	public void insertDataset(Map<String, Object> dataObj) throws Exception {
		final String drapDatasetPosStr = MapUtils.getString(dataObj, "datasetVoList");
		final List<DrapDatasetVo> drapDatasetList = JSON.parseArray(drapDatasetPosStr, DrapDatasetVo.class);
		List<String> datasetIds = getIdList(drapDatasetList);
		//查询更新的数据集id
		Set<String> updateDatasetIdArray = drapDatasetMapper.selectIdsBydDatasetIds(datasetIds);
		//查询更新的数据集下的数据项id
		Set<String> updateItemIdArray = drapDatasetItemMapMapper.selectItemIdsByDatasetIds(datasetIds);
		drapDatasetMapper.deleteBatchIds(datasetIds);
		this.drapDatasetMapper.batchInsert(drapDatasetList);
		//更新关系
		service.insertTableRelation(drapDatasetList);

		if(dataObj.containsKey("datasetSystemMapList")){
			final String datasetSystemMapPosStr = MapUtils.getString(dataObj, "datasetSystemMapList");
			final List<DrapDatasetSystemMap> drapDatasetSystemMapList = JSON.parseArray(datasetSystemMapPosStr, DrapDatasetSystemMap.class);
			drapDatasetSystemMapMapper.deleteBatchIds(getIdList(drapDatasetSystemMapList));
			this.drapDatasetSystemMapMapper.batchInsert(drapDatasetSystemMapList);
		}
		if(dataObj.containsKey("activitySetMapList")){
			final String activitySetMapPosStr = MapUtils.getString(dataObj, "activitySetMapList");
			final List<DrapActivitySetMap> drapActivitySetMapList = JSON.parseArray(activitySetMapPosStr, DrapActivitySetMap.class);
			drapActivitySetMapMapper.deleteBatchIds(getIdList(drapActivitySetMapList));
			this.drapActivitySetMapMapper.batchInsert(drapActivitySetMapList);
		}
		if(dataObj.containsKey("datasetExtFormatList")){
			final String drapDatasetExtFormatPosStr = MapUtils.getString(dataObj, "datasetExtFormatList");
			final List<DrapDatasetExtFormat> drapDatasetExtFormatList = JSON.parseArray(drapDatasetExtFormatPosStr, DrapDatasetExtFormat.class);
			drapDatasetExtFormatMapper.deleteBatchIds(getIdList(drapDatasetExtFormatList));
			this.drapDatasetExtFormatMapper.batchInsert(drapDatasetExtFormatList);

			final List<DirDatasetExtFormat> dirDatasetExtFormatList = JSON.parseArray(drapDatasetExtFormatPosStr, DirDatasetExtFormat.class);
			List<DirDatasetExtFormat> dirDatasetExtFormatArray = Lists.newArrayList();
			for( int i=0 ,size = dirDatasetExtFormatList.size() ; i<size; i++){
				DirDatasetExtFormat dirDatasetExtFormat = dirDatasetExtFormatList.get(i);
				if(updateDatasetIdArray != null && !updateDatasetIdArray.contains(dirDatasetExtFormat.getDatasetId())){
					dirDatasetExtFormatArray.add(dirDatasetExtFormat);
				}
			}
			if(dirDatasetExtFormatArray.size() > 0)
			this.dirDatasetExtFormatMapper.batchInsert(dirDatasetExtFormatArray);
		}
		if(dataObj.containsKey("datasetSurveyList")){
			final String drapDatasetSurveyPosStr = MapUtils.getString(dataObj, "datasetSurveyList");
			final List<DrapDatasetSurvey> drapDatasetSurveyList = JSON.parseArray(drapDatasetSurveyPosStr, DrapDatasetSurvey.class);
			drapDatasetSurveyMapper.deleteBatchIds(getIdList(drapDatasetSurveyList));
			this.drapDatasetSurveyMapper.batchInsert(drapDatasetSurveyList);

			final List<DirDatasetSurvey> dirDatasetSurveyList = JSON.parseArray(drapDatasetSurveyPosStr, DirDatasetSurvey.class);
			List<DirDatasetSurvey> dirDatasetSurveyArray = Lists.newArrayList();
			for(int i=0 ,size = dirDatasetSurveyList.size() ; i<size; i++){
				DirDatasetSurvey dirDatasetSurvey = dirDatasetSurveyList.get(i);
				if(updateDatasetIdArray != null && !updateDatasetIdArray.contains(dirDatasetSurvey.getDatasetId())){
					dirDatasetSurveyArray.add(dirDatasetSurvey);
				}
			}
			if(dirDatasetSurveyArray.size() > 0)
			this.dirDatasetSurveyMapper.batchInsert(dirDatasetSurveyArray);
		}

		List<DrapDatasetItem> drapDatasetItemList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemVoList")){
			String drapDatasetItemPosStr = MapUtils.getString(dataObj, "datasetItemVoList");
			drapDatasetItemList = JSON.parseArray(drapDatasetItemPosStr, DrapDatasetItem.class);
			drapDatasetItemMapper.deleteBatchIds(getIdList(drapDatasetItemList));
			this.drapDatasetItemMapper.batchInsert(drapDatasetItemList);
		}

		List<DrapDatasetItemMap> drapDatasetItemMapList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemMapList")){
			final String drapDatasetItemMapPosStr = MapUtils.getString(dataObj, "datasetItemMapList");
			drapDatasetItemMapList = JSON.parseArray(drapDatasetItemMapPosStr, DrapDatasetItemMap.class);
			drapDatasetItemMapMapper.deleteBatchIds(getIdList(drapDatasetItemMapList));
			this.drapDatasetItemMapMapper.batchInsert(drapDatasetItemMapList);
		}

		final List<DirDataset> dirDatasetList = new ArrayList<>();
		final List<DirDatasetSourceInfo> dirDatasetSourceInfoList = new ArrayList<>();
		final String dataSetSourceType = "8";	//直接将类型写死	// sysDictMapper.selectDictcodeByCategoryAndName("资源梳理添加", "dataSetSourceType");
		for (DrapDatasetVo drapDatasetVo :drapDatasetList){
			final String datasetId = drapDatasetVo.getId();
			if(updateDatasetIdArray != null && updateDatasetIdArray.contains(datasetId)){
				continue;
			}
			String classifyId = dirClassifyDeptMapMapper.selectByDeptId(drapDatasetVo.getBelongDeptId());
			if(classifyId == null || "".equals(classifyId)){
				classifyId = dirClassifyDeptMapMapper.selectByDeptFId(drapDatasetVo.getBelongDeptId());
			}
			if(classifyId != null && !"".equals(classifyId)) {
				final DirClassify dirClassify = dirClassifyMapper.selectFclassify(classifyId);
				DirDatasetClassifyMap dirDatasetClassifyMap = new DirDatasetClassifyMap();
				dirDatasetClassifyMap.setId(CommonUtil.get32UUID());
				dirDatasetClassifyMap.setDatasetId(datasetId);
				dirDatasetClassifyMap.setClassifyId(classifyId);
				dirDatasetClassifyMap.setInfoResourceCode(dirClassify.getClassifyCode() + "/" + (dirClassify.getDcmIndex() + 1));
				dirDatasetClassifyMap.setStatus(Dataset.DatasetStatus.UnRegister.getKey());
				dirDatasetClassifyMap.setDeleteFlag(0);
				dirDatasetClassifyMapMapper.baseInsert(dirDatasetClassifyMap);
				dirClassifyMapper.updateDcmIndexbyId(classifyId);
			}else{
				throw new RuntimeException("查询不到id为"+drapDatasetVo.getId()+"的信息资源的classifyId");
			}

			final DirDataset dirDataset = getDirDataset(drapDatasetVo,dataSetSourceType);
			dirDatasetList.add(dirDataset);
			final DirDatasetSourceInfo dirDatasetSourceInfo = new DirDatasetSourceInfo();
			dirDatasetSourceInfo.setId(CommonUtil.get32UUID());
			dirDatasetSourceInfo.setDatasetId(dirDataset.getId());
			dirDatasetSourceInfo.setSourceObjId(drapDatasetVo.getId());
			dirDatasetSourceInfoList.add(dirDatasetSourceInfo);
		}
		if(dirDatasetList.size() > 0)
		dirDatasetMapper.batchInsert(dirDatasetList);
		if(dirDatasetSourceInfoList.size() > 0)
		dirDatasetSourceInfoMapper.batchInsert(dirDatasetSourceInfoList);

		final List<DirDataitem> dirDataitemList = new ArrayList<>();
		final List<DirDataitemSourceInfo> dirDataitemSourceInfoList = new ArrayList<>();

		for (DrapDatasetItem drapDatasetItem : drapDatasetItemList){
			final String itemId = drapDatasetItem.getId();
			if(updateItemIdArray != null && updateItemIdArray.contains(itemId)){
				continue;
			}
			final DirDataitem dirDataitem = getDirDataitem(drapDatasetItem,drapDatasetItemMapList);
			dirDataitemList.add(dirDataitem);
			final DirDataitemSourceInfo dirDataitemSourceInfo = new DirDataitemSourceInfo();
			dirDataitemSourceInfo.setId(CommonUtil.get32UUID());
			dirDataitemSourceInfo.setItemId(dirDataitem.getId());
			dirDataitemSourceInfo.setSourceObjType("8");
			dirDataitemSourceInfo.setSourceObjId(drapDatasetItem.getId());
			dirDataitemSourceInfoList.add(dirDataitemSourceInfo);
		}
		if(!dirDataitemList.isEmpty()) {
			dirDataitemMapper.batchInsert(dirDataitemList);
		}
		if(!dirDataitemSourceInfoList.isEmpty()) {
			dirDataitemSourceInfoMapper.batchInsert(dirDataitemSourceInfoList);
		}
	}
	
	@Autowired
	DrapDatasetTableRelationMapper drapDatasetTableRelationMapper;
	@Override
	public void deleteDataset(Map<String, Object> dataObj) throws Exception {
		final String drapDatasetPosStr = MapUtils.getString(dataObj, "datasetVoList");
		final List<DrapDatasetVo> drapDatasetList = JSON.parseArray(drapDatasetPosStr, DrapDatasetVo.class);
		List<String> datasetIds = getIdList(drapDatasetList);
		drapDatasetMapper.deleteBatchIds(datasetIds);
		//删除关系
		drapDatasetTableRelationMapper.deleteTableRelationBySetIds(datasetIds);;

		if(dataObj.containsKey("datasetSystemMapList")){
			final String datasetSystemMapPosStr = MapUtils.getString(dataObj, "datasetSystemMapList");
			final List<DrapDatasetSystemMap> drapDatasetSystemMapList = JSON.parseArray(datasetSystemMapPosStr, DrapDatasetSystemMap.class);
			drapDatasetSystemMapMapper.deleteBatchIds(getIdList(drapDatasetSystemMapList));
		}
		if(dataObj.containsKey("activitySetMapList")){
			final String activitySetMapPosStr = MapUtils.getString(dataObj, "activitySetMapList");
			final List<DrapActivitySetMap> drapActivitySetMapList = JSON.parseArray(activitySetMapPosStr, DrapActivitySetMap.class);
			drapActivitySetMapMapper.deleteBatchIds(getIdList(drapActivitySetMapList));
		}
		if(dataObj.containsKey("datasetExtFormatList")){
			final String drapDatasetExtFormatPosStr = MapUtils.getString(dataObj, "datasetExtFormatList");
			final List<DrapDatasetExtFormat> drapDatasetExtFormatList = JSON.parseArray(drapDatasetExtFormatPosStr, DrapDatasetExtFormat.class);
			drapDatasetExtFormatMapper.deleteBatchIds(getIdList(drapDatasetExtFormatList));
		}
		if(dataObj.containsKey("datasetSurveyList")){
			final String drapDatasetSurveyPosStr = MapUtils.getString(dataObj, "datasetSurveyList");
			final List<DrapDatasetSurvey> drapDatasetSurveyList = JSON.parseArray(drapDatasetSurveyPosStr, DrapDatasetSurvey.class);
			drapDatasetSurveyMapper.deleteBatchIds(getIdList(drapDatasetSurveyList));
		}

		List<DrapDatasetItem> drapDatasetItemList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemVoList")){
			String drapDatasetItemPosStr = MapUtils.getString(dataObj, "datasetItemVoList");
			drapDatasetItemList = JSON.parseArray(drapDatasetItemPosStr, DrapDatasetItem.class);
			drapDatasetItemMapper.deleteBatchIds(getIdList(drapDatasetItemList));
		}

		List<DrapDatasetItemMap> drapDatasetItemMapList = new ArrayList<>();
		if(dataObj.containsKey("datasetItemMapList")){
			final String drapDatasetItemMapPosStr = MapUtils.getString(dataObj, "datasetItemMapList");
			drapDatasetItemMapList = JSON.parseArray(drapDatasetItemMapPosStr, DrapDatasetItemMap.class);
			drapDatasetItemMapMapper.deleteBatchIds(getIdList(drapDatasetItemMapList));
		}
	}

	@Override
	public void updateDatasetStatus(AuditEntity auditEntity) throws Exception {
		drapDatasetMapper.updateDatasetStatus(auditEntity);
	}

	private List<String> getIdList(List<?> pos)throws Exception {
		List<String> idList = Lists.newArrayList();
		for(int i = 0 ; i < pos.size() ; i++){
			Object po = pos.get(i);
			idList.add(reflect("id", po));
		}
		return idList;
	}
	
	/** 
	 * 根据属性名获取属性值 
	 * */ 
	 private String reflect(String fieldName, Object o)throws Exception {  
           String firstLetter = fieldName.substring(0, 1).toUpperCase();    
           String getter = "get" + firstLetter + fieldName.substring(1);    
           Method method = o.getClass().getMethod(getter, new Class[] {});    
           Object value = method.invoke(o, new Object[] {});    
           return value == null ? null : value.toString();
	}  
	 
	
	private DirDataset getDirDataset(DrapDatasetVo drapDatasetVo, String dataSetSourceType){
		final DirDataset dirDataset = new DirDataset();
		dirDataset.setId(drapDatasetVo.getId());
		dirDataset.setRegionCode(drapDatasetVo.getRegionCode());
		dirDataset.setDatasetCode(drapDatasetVo.getDatasetCode());
		dirDataset.setDatasetName(drapDatasetVo.getDatasetName());

		final String drapDeptId = drapDatasetVo.getBelongDeptId();
		String dirDeptId = sysDeptService.getRootDeptId(drapDeptId);
		if(Objects.equals(drapDeptId,dirDeptId)){
			dirDataset.setBelongDeptType(dirDeptId);
		}else{
			dirDataset.setBelongDeptType(dirDeptId);
			dirDataset.setBelongDeptId(drapDeptId);
		}
		dirDataset.setChargeDeptId(drapDeptId);

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
		dirDataset.setSourceType(dataSetSourceType);
		dirDataset.setStatus(drapDatasetVo.getStatus().toString());
		dirDataset.setCreateUserId(drapDatasetVo.getCreateUser());
		dirDataset.setCreateTime(drapDatasetVo.getCreateTime());
		dirDataset.setUpdateUserId(drapDatasetVo.getUpdateUser());
		dirDataset.setUpdateTime(drapDatasetVo.getUpdateTime());
		dirDataset.setDeleteFlag(drapDatasetVo.getDeleteFlag());
		return dirDataset;
	}

	private DirDataitem getDirDataitem(DrapDatasetItem drapDatasetItem,List<DrapDatasetItemMap> drapDatasetItemMapList){
		final String datasetId = getDatasetIdFromItemMap(drapDatasetItemMapList, drapDatasetItem.getId());
		final DirDataitem dirDataitem = new DirDataitem();
		dirDataitem.setId(drapDatasetItem.getId());
		dirDataitem.setDatasetId(datasetId);
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
