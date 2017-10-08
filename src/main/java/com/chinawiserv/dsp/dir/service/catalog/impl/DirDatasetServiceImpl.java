package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.vo.catalog.*;
import com.chinawiserv.dsp.dir.enums.apply.SourceTypeEnum;
import com.chinawiserv.dsp.dir.enums.catalog.Dataset;
import com.chinawiserv.dsp.dir.mapper.catalog.*;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * <p>
 * 数据集（信息资源） 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDatasetServiceImpl extends CommonServiceImpl<DirDatasetMapper, DirDataset , DirDatasetVo> implements IDirDatasetService {

    @Autowired
    private DirDatasetMapper mapper;

    @Autowired
    private DirDataitemMapper itemMapper;

    @Autowired
    private DirDatasetClassifyMapMapper dirDatasetClassifyMapMapper;

    @Autowired
    private DirDataRegisteMapper registeMapper;

    @Autowired
    private DirDataAuditMapper auditMapper;

    @Autowired
    private DirDataPublishMapper releaseMapper;

    @Autowired
    private DirDataOfflineMapper offlineMapper;

    @Autowired
    private IDirClassifyService dirClassifyService;

    @Autowired
    private DirDataitemSourceInfoMapper sourceInfoMapper;

    @Autowired
    private DirDatasetSurveyMapper surveyMapper;

    @Override
    public boolean insertVO(DirDatasetVo vo) throws Exception {
        boolean insertResult = false;
        int classifyMapResult = 0;
        int itemResult = 0;
        SysUserVo logionUser = ShiroUtils.getLoginUser();
        String datasetId = UUID.randomUUID().toString();
        Date createTime = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
        vo.setId(datasetId);
        vo.setRegionCode(logionUser.getRegionCode());
        vo.setSourceType(SourceTypeEnum.DATA_1.getDbValue());
        vo.setStatus("0");
        vo.setCreateUserId(logionUser.getId());
        vo.setCreateTime(createTime);
        int datasetResult = mapper.baseInsert(vo);
        if(datasetResult>0){
            //插入信息资源格式
            DirDatasetExtFormat ext = vo.getExt();
            ext.setId(UUID.randomUUID().toString());
            ext.setDatasetId(vo.getId());
            mapper.extInsert(ext);
            //大普查
            DirDatasetSurvey survey = vo.getSurvey();
            if(survey!=null){
                survey.setId(UUID.randomUUID().toString());
                survey.setDatasetId(datasetId);
                surveyMapper.baseInsert(survey);
            }
            //数据集插入成功后，插入数据集与目录类别中间表的数据
            String classifyIds = vo.getClassifyIds();
            if(!StringUtils.isEmpty(classifyIds)){
                List<DirDatasetClassifyMapVo> classifyMapVoList = new ArrayList<>();
                String [] classifyIdArray = classifyIds.split(",");
                for(String classifyId : classifyIdArray){
                    DirDatasetClassifyMapVo classifyMapVo = new DirDatasetClassifyMapVo();
                    String classifyMapId = UUID.randomUUID().toString();
                    classifyMapVo.setId(classifyMapId);
                    classifyMapVo.setDatasetId(datasetId);
                    classifyMapVo.setClassifyId(classifyId);
                    classifyMapVo.setStatus("0");
                    classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(classifyId));
                    classifyMapVoList.add(classifyMapVo);
                }
                classifyMapResult = dirDatasetClassifyMapMapper.insertListItem(classifyMapVoList);
            }
            //数据项来源
            //List<DirDataitemSourceInfo> sourceInf
            // os = vo.getSourceInfos();
            //数据集插入成功后，插入该数据集的数据项的数据
            List<DirDataitemVo> dirDataitemVoList = vo.getItems();
            if(!ObjectUtils.isEmpty(dirDataitemVoList)){
                //int i=0;
                //List<DirDataitemSourceInfo> insertSourceInfos=new ArrayList<>();
                //DirDataitemSourceInfo sourceInfo=null;
                for(DirDataitemVo item : dirDataitemVoList){
                    String itemId = UUID.randomUUID().toString();
                    item.setId(itemId);
                    item.setDatasetId(datasetId);
                    item.setStatus("0");
                    item.setCreateUserId(logionUser.getId());
                    item.setCreateTime(createTime);
                    //数据项来源
                    /*if(!ObjectUtils.isEmpty(sourceInfos)){
                        sourceInfo = sourceInfos.get(i);
                        sourceInfo.setId(itemId);
                        sourceInfo.setItemId(itemId);
                        insertSourceInfos.add(sourceInfo);
                        i++;
                    }*/
                }
                itemResult = itemMapper.insertListItem(dirDataitemVoList);
                /*if(insertSourceInfos!=null&&insertSourceInfos.size()>0){
                    sourceInfoMapper.insertList(insertSourceInfos);
                }*/
            }

        }
        if(classifyMapResult > 0){
            if(!ObjectUtils.isEmpty(vo.getItems())){
                if(itemResult > 0){
                    insertResult = true;
                }
            }else{
                insertResult = true;
            }
        }
		return insertResult;
    }

    @Override
    public boolean updateVO(DirDatasetVo vo) throws Exception{
        String datasetId = vo.getId();
        SysUserVo logionUser = ShiroUtils.getLoginUser();
        Date updateTime = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
        String updateUserId = logionUser.getId();
        vo.setUpdateUserId(updateUserId);
        vo.setUpdateTime(updateTime);
        int datasetResult = mapper.baseUpdate(vo);
        if(datasetResult>=0){
            //修改信息资源格式
            DirDatasetExtFormat ext = vo.getExt();
            ext.setDatasetId(datasetId);
            List<Map<String,Object>> extList = mapper.extSelect(datasetId);
            if(!ObjectUtils.isEmpty(extList)){
                mapper.extUpdate(ext);
            }else{
                ext.setId(UUID.randomUUID().toString());
                mapper.extInsert(ext);
            }
            //修改大普查信息
            DirDatasetSurvey survey = vo.getSurvey();
            survey.setDatasetId(datasetId);
            Map<String,Object> surveyParam = new HashMap<>();
            surveyParam.put("datasetId",datasetId);
            List<DirDatasetSurveyVo> surveyVoList= surveyMapper.baseSelect(surveyParam);
            if(!ObjectUtils.isEmpty(surveyVoList)){
                surveyMapper.baseUpdate(survey);
            }else{
                survey.setId(UUID.randomUUID().toString());
                surveyMapper.baseInsert(survey);
            }
            //修改数据集与目录类别中间表的数据
            updateDatasetClassifyMapInfo(vo, updateUserId, updateTime);
            //修改数据项的数据
            updateItemInfo(vo, updateUserId, updateTime);
        }
        return true;
	}

    private void updateDatasetClassifyMapInfo(DirDatasetVo vo, String updateUserId, Date updateTime) throws Exception{
        String classifyIds = vo.getClassifyIds();
        String datasetId = vo.getId();
        if(!StringUtils.isEmpty(classifyIds)){
            Map<String,Object> mapParam = new HashMap<>();
            mapParam.put("datasetId",datasetId);
            List<DirDatasetClassifyMapVo> oldClassifyMapVoList = dirDatasetClassifyMapMapper.baseSelect(mapParam);
            String [] classifyIdArray = classifyIds.split(",");
            //由于需要保留历史数据，所以中间表的数据只能逻辑删除
            //由于有多个值，并能修改，所以不知道是原有的哪个类别改成了现在的哪个类别，只能做新增和删除(逻辑删除)
            List<String> needAddClassifyList = new ArrayList<>();
            List<String> needDeleteClassifyList = new ArrayList<>();
            if(!ObjectUtils.isEmpty(oldClassifyMapVoList)){ //【由于目录类别是必填项，所以没写如果空后面的逻辑】
                //先比较哪些是新增的目录类别
                for(String classifyId : classifyIdArray){
                    boolean hasThisClassifyid = false;
                    for(DirDatasetClassifyMapVo oldVo : oldClassifyMapVoList){
                        String oldClassifyId = oldVo.getClassifyId();
                        if(classifyId.equals(oldClassifyId)){
                            hasThisClassifyid = true;
                            break;
                        }
                    }
                    if(!hasThisClassifyid){
                        needAddClassifyList.add(classifyId);
                    }
                }
                //反过来比较哪些是删除的目录类别
                for(DirDatasetClassifyMapVo oldVo : oldClassifyMapVoList){
                    boolean hasThisClassifyid = false;
                    String oldClassifyId = oldVo.getClassifyId();
                    String oldClassifyMapId = oldVo.getId();
                    for(String classifyId : classifyIdArray){
                        if(oldClassifyId.equals(classifyId)){
                            hasThisClassifyid = true;
                            break;
                        }
                    }
                    if(!hasThisClassifyid){
                        needDeleteClassifyList.add(oldClassifyMapId);
                    }
                }
                //插入新增的目录类别到中间表
                if(needAddClassifyList.size()>0){
                    List<DirDatasetClassifyMapVo> addClassifyMapVoList = new ArrayList<>();
                    for(String addClassifyId : needAddClassifyList){
                        DirDatasetClassifyMapVo classifyMapVo = new DirDatasetClassifyMapVo();
                        String classifyMapId = UUID.randomUUID().toString();
                        classifyMapVo.setId(classifyMapId);
                        classifyMapVo.setDatasetId(datasetId);
                        classifyMapVo.setClassifyId(addClassifyId);
                        classifyMapVo.setStatus("0");
                        classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(addClassifyId));
                        classifyMapVo.setUpdateUserId(updateUserId);
                        classifyMapVo.setUpdateTime(updateTime);
                        addClassifyMapVoList.add(classifyMapVo);
                    }
                    dirDatasetClassifyMapMapper.insertListItem(addClassifyMapVoList);
                }
                //将该删除的中间表的数据的删除标识改为1
                if(needDeleteClassifyList.size()>0){
                    Map<String,Object> deleteParam = new HashMap<>();
                    deleteParam.put("deleteFlag",1);
                    deleteParam.put("ids",needDeleteClassifyList);
                    deleteParam.put("updateUserId",updateUserId);
                    deleteParam.put("updateTime",updateTime);
                    dirDatasetClassifyMapMapper.batchUpdateStatus(deleteParam);
                }
            }
        }
    }

    private void updateItemInfo(DirDatasetVo vo, String updateUserId, Date updateTime)throws Exception{
        //数据集插入成功后，插入该数据集的数据项的数据
        String datasetId = vo.getId();
        List<DirDataitemVo> newItemVoList = vo.getItems();
        Map<String,Object> itemParam = new HashMap<>();
        itemParam.put("datasetId",datasetId);
        List<DirDataitemVo> oldItemVoList = itemMapper.selectInfoList(itemParam);
        //同数据集与目录类别的中间表的处理方式一样，对比增加和删除的，但是如果存在的对象，则需要修改
        if(!ObjectUtils.isEmpty(newItemVoList)){
            List<DirDataitemVo> needUpdateItemList = new ArrayList<>();
            List<DirDataitemVo> needAddItemList = new ArrayList<>();
            List<DirDataitemVo> needDeleteItemList = new ArrayList<>();
            if(!ObjectUtils.isEmpty(oldItemVoList)){
                //先比较哪些是新增的数据项
                for(DirDataitemVo newItemVo : newItemVoList){
                    boolean hasThisItem = false;
                    String newItemId = newItemVo.getId();
                    if(StringUtils.isEmpty(newItemId)){
                        newItemId = UUID.randomUUID().toString();
                        newItemVo.setId(newItemId);
                    }
                    for(DirDataitemVo oldItemVo : oldItemVoList){
                        String oldItemId = oldItemVo.getId();
                        if(newItemId.equals(oldItemId)){
                            hasThisItem = true;
                            needUpdateItemList.add(newItemVo);
                            break;
                        }
                    }
                    if(!hasThisItem){
                        needAddItemList.add(newItemVo);
                    }
                }
                //反过来比较哪些是删除的目录类别
                for(DirDataitemVo oldItemVo : oldItemVoList){
                    boolean hasThisItem = false;
                    String oldItemId = oldItemVo.getId();
                    for(DirDataitemVo newItemVo : newItemVoList){
                        String newItemId = newItemVo.getId();
                        if(newItemId.equals(oldItemId)){
                            hasThisItem = true;
                            break;
                        }
                    }
                    if(!hasThisItem){
                        needDeleteItemList.add(oldItemVo);
                    }
                }
                //插入新增的数据项
                if(needAddItemList.size()>0){
                    for(DirDataitemVo addItemVo : needAddItemList){
                        addItemVo.setId(UUID.randomUUID().toString());
                        addItemVo.setDatasetId(datasetId);
                        addItemVo.setStatus("0");
                        addItemVo.setCreateUserId(updateUserId);
                        addItemVo.setCreateTime(updateTime);
                    }
                    itemMapper.insertListItem(needAddItemList);
                }
                //修改已有的数据项
                if(needUpdateItemList.size()>0){
                    for(DirDataitemVo updateItemVo : needUpdateItemList){
                        updateItemVo.setDatasetId(datasetId);
                        updateItemVo.setUpdateUserId(updateUserId);
                        updateItemVo.setUpdateTime(updateTime);
                    }
                    itemMapper.batchUpdate(needUpdateItemList);
                }
                //将该删除的中间表的数据的删除标识改为1
                if(needDeleteItemList.size()>0){
                    for(DirDataitemVo deleteItemVo : needDeleteItemList){
                        deleteItemVo.setDeleteFlag(1);
                        deleteItemVo.setUpdateUserId(updateUserId);
                        deleteItemVo.setUpdateTime(updateTime);
                    }
                    itemMapper.batchUpdate(needDeleteItemList);
                }
            }else{//如果表里该数据集没有任何数据项，则全部新增
                for(DirDataitemVo addItemVo : newItemVoList){
                    addItemVo.setId(UUID.randomUUID().toString());
                    addItemVo.setDatasetId(datasetId);
                    addItemVo.setStatus("0");
                    addItemVo.setCreateUserId(updateUserId);
                    addItemVo.setCreateTime(updateTime);
                }
                itemMapper.insertListItem(newItemVoList);
            }
        }else{ //如果当前值为空，则把数据库中有的数据项的删除标识改为1
            if(!ObjectUtils.isEmpty(oldItemVoList)){
                for(DirDataitemVo deleteItemVo : oldItemVoList){
                    deleteItemVo.setDeleteFlag(1);
                    deleteItemVo.setUpdateUserId(updateUserId);
                    deleteItemVo.setUpdateTime(updateTime);
                }
                itemMapper.batchUpdate(oldItemVoList);
            }
        }
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
	}

    @Override
    public boolean deleteById(String id){
        boolean deleteResult = false;
        if(!StringUtils.isEmpty(id)) {
            String[] idArray = id.split(",");
            Map<String,Object> itemParams = new HashMap<>();
            itemParams.put("datasetIds", idArray);
            int itemDeleteNum = itemMapper.flagDelete(itemParams);
            if(itemDeleteNum >=0){
                Map<String,Object> datasetParams = new HashMap<>();
                datasetParams.put("ids", idArray);
                int deleteNum = mapper.flagDelete(datasetParams);
                if(deleteNum == idArray.length){
                    deleteResult = true;
                }
            }
        }
        return deleteResult;
    }

    @Override
    public DirDatasetVo selectVoById(String id) throws Exception {
        DirDatasetVo dirDatasetVo = mapper.selectDatasetInfoById(id);
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("datasetId",id);
        List<DirDataitemVo> itemVoList = itemMapper.selectInfoList(mapParam);
        if(!ObjectUtils.isEmpty(itemVoList)){
            dirDatasetVo.setItems(itemVoList);
        }
        List<DirDatasetClassifyMapVo> classifyMapVoList = dirDatasetClassifyMapMapper.selectVoPage(new Page<>(), mapParam);
        if(!ObjectUtils.isEmpty(classifyMapVoList)){
            String classifyIds = "";
            String classifyName = "";
            for(int i=0,ii=classifyMapVoList.size();i<ii;i++){
                String classifyId = classifyMapVoList.get(i).getClassifyId();
                String classifyStructureName = classifyMapVoList.get(i).getClassifyStructureName();
                classifyIds += i==0?classifyId:","+classifyId;
                classifyName += i==0?classifyStructureName:","+classifyStructureName;
            }
            dirDatasetVo.setClassifyIds(classifyIds);
            dirDatasetVo.setClassifyName(classifyName);
        }
		return dirDatasetVo;
	}

    @Override
    public Page<DirDatasetVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDatasetVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirDatasetVo> dirDatasetClassifyMapVoList = mapper.selectInfoPage(page, paramMap);
        page.setRecords(dirDatasetClassifyMapVoList);
        page.setTotal(dirDatasetClassifyMapMapper.selectVoCount(paramMap));
        return page;
	}

    @Override
    public Page<DirDatasetClassifyMapVo> selectClassifyMapVoPage(Map<String, Object> paramMap){
        Page<DirDatasetClassifyMapVo> page = getPage(paramMap);
        page.setOrderByField("update_time");
        page.setAsc(false);
        List<DirDatasetClassifyMapVo> dirDatasetClassifyMapVoList = dirDatasetClassifyMapMapper.selectVoPage(page, paramMap);
        page.setRecords(dirDatasetClassifyMapVoList);
        page.setTotal(dirDatasetClassifyMapMapper.selectVoCount(paramMap));
        return page;
    }

    @Override
    public Page<DirDatasetClassifyMapVo> selectReleasedClassifyMapVoPage(Map<String, Object> paramMap){
        Page<DirDatasetClassifyMapVo> page = getPage(paramMap);
        page.setOrderByField("update_time");
        page.setAsc(false);
        List<DirDatasetClassifyMapVo> dirDatasetClassifyMapVoList = dirDatasetClassifyMapMapper.selectVoPageForReleased(page, paramMap);
        page.setRecords(dirDatasetClassifyMapVoList);
        page.setTotal(dirDatasetClassifyMapMapper.selectVoCount(paramMap));
        return page;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<Map<String, Object>> selectActivityByDeptId(String dept_id) {
        return mapper.selectActivityByDeptId(dept_id);
    }

    @Override
    public List<Map<String, Object>> selectDatasetByActivityId(String activity_id) {
        return mapper.selectDatasetByActivityId(activity_id);
    }

    @Override
    public List<DrapDatasetItem> selectDatasetItemByDatasetId(String dataset_id) {
        return mapper.selectDatasetItemByDatasetId(dataset_id);
    }

    @Override
    public DrapDataset getDrapDatasetDetail(String id) {
        return mapper.getDrapDatasetDetail(id);
    }

    @Override
    public boolean checkDatasetName(String datasetName, String classifyIds){
        boolean hasThisName = false;
        String ids = "";
        String classifyIdArray [] = classifyIds.split(",");
        for(int i=0;i<classifyIdArray.length;i++){
            ids += i==0?"'"+classifyIdArray[i]+"'":",'"+classifyIdArray[i]+"'";
        }
        List<DirDatasetClassifyMapVo> resultList = dirDatasetClassifyMapMapper.checkDatasetName(datasetName, ids);
        if(!ObjectUtils.isEmpty(resultList)){
            hasThisName = true;
        }
        return hasThisName;
    }

    @Override
    public boolean registe(String dcmIds) {
        boolean result = false;
        if(!StringUtils.isEmpty(dcmIds)){
            Map<String,Object> params = new HashMap<>();
            String [] dcmIdArray = dcmIds.split(",");
            Date now = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
            params.put("ids",dcmIdArray);
            params.put("status","1");//状态改为待审核
            params.put("updateUserId",ShiroUtils.getLoginUserId());
            params.put("updateTime",now);
            int updateResult = dirDatasetClassifyMapMapper.batchUpdateStatus(params);
            if(updateResult >= 0){
                Map<String, Object> updateFlagParams = new HashMap<>();
                updateFlagParams.put("activeFlag",0);
                updateFlagParams.put("ids",dcmIdArray);
                registeMapper.batchUpdateActiveFlag(updateFlagParams);
                List<DirDataRegisteVo> dataRegisteList = new ArrayList<>();
                for(String dcmId : dcmIdArray){
                    DirDataRegisteVo dataRegiste = new DirDataRegisteVo();
                    dataRegiste.setId(UUID.randomUUID().toString());
                    dataRegiste.setDcmId(dcmId);
                    dataRegiste.setRegisterId(ShiroUtils.getLoginUserId());
                    dataRegiste.setRegisteDate(now);
                    dataRegiste.setActiveFlag(1);
                    dataRegisteList.add(dataRegiste);
                }
                int insertResult = registeMapper.insertListData(dataRegisteList);
                if(insertResult == dcmIdArray.length){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean audit(Map<String , Object> paramMap) {
        boolean result = false;
        String dcmIds = (String)paramMap.get("id");
        String auditStatus = (String)paramMap.get("status");
        String auditOpinion = (String)paramMap.get("opinion");
        if(!StringUtils.isEmpty(dcmIds) && !StringUtils.isEmpty(auditStatus)){
            Map<String,Object> params = new HashMap<>();
            String [] dcmIdArray = dcmIds.split(",");
            Date now = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
            params.put("ids",dcmIdArray);
            params.put("status",auditStatus);//状态改为待审核
            params.put("updateUserId",ShiroUtils.getLoginUserId());
            params.put("updateTime",now);
            int updateResult = dirDatasetClassifyMapMapper.batchUpdateStatus(params);
            if(updateResult >= 0){
                Map<String, Object> updateFlagParams = new HashMap<>();
                updateFlagParams.put("activeFlag",0);
                updateFlagParams.put("ids",dcmIdArray);
                auditMapper.batchUpdateActiveFlag(updateFlagParams);
                List<DirDataAuditVo> dataAuditList = new ArrayList<>();
                for(String dcmId : dcmIdArray){
                    DirDataAuditVo dataAudit = new DirDataAuditVo();
                    dataAudit.setId(UUID.randomUUID().toString());
                    dataAudit.setDcmId(dcmId);
                    dataAudit.setAuditStatus(auditStatus);
                    dataAudit.setAuditorId(ShiroUtils.getLoginUserId());
                    dataAudit.setAuditDate(now);
                    dataAudit.setAuditOpinion(auditOpinion);
                    dataAudit.setActiveFlag(1);
                    dataAuditList.add(dataAudit);
                }
                int insertResult = auditMapper.insertListData(dataAuditList);
                if(insertResult == dcmIdArray.length){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean release(Map<String , Object> paramMap) {
        boolean result = false;
        String dcmIds = (String)paramMap.get("dcmId");
        String publishType = (String)paramMap.get("publishType");
        if(!StringUtils.isEmpty(dcmIds) && !StringUtils.isEmpty(publishType)) {
            Map<String, Object> params = new HashMap<>();
            String[] dcmIdArray = dcmIds.split(",");
            Date now = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
            params.put("ids", dcmIdArray);
            params.put("status", "5");//状态改为已发布
            params.put("updateUserId", ShiroUtils.getLoginUserId());
            params.put("updateTime", now);
            int updateResult = dirDatasetClassifyMapMapper.batchUpdateStatus(params);
            if (updateResult >= 0) {
                Map<String, Object> updateFlagParams = new HashMap<>();
                updateFlagParams.put("activeFlag",0);
                updateFlagParams.put("ids",dcmIdArray);
                releaseMapper.batchUpdateActiveFlag(updateFlagParams);
                List<DirDataPublishVo> dataPublishList = new ArrayList<>();
                for (String dcmId : dcmIdArray) {
                    DirDataPublishVo dataPublish = new DirDataPublishVo();
                    dataPublish.setId(UUID.randomUUID().toString());
                    dataPublish.setDcmId(dcmId);
                    dataPublish.setPublisherId(ShiroUtils.getLoginUserId());
                    dataPublish.setPublishDate(now);
                    dataPublish.setPublishType(publishType);
                    dataPublish.setActiveFlag(1);
                    dataPublishList.add(dataPublish);
                }
                int insertResult = releaseMapper.insertListData(dataPublishList);
                if (insertResult == dcmIdArray.length) {
                    result = true;
                    //todo 调用门户的接口，同步数据到互联网门户的数据库
                }
            }
        }
        return result;
    }

    @Override
    public boolean auditReject(String dcmIds) {
        boolean result = false;
        if(!StringUtils.isEmpty(dcmIds)){
            Map<String,Object> params = new HashMap<>();
            String [] dcmIdArray = dcmIds.split(",");
            Date now = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
            params.put("ids",dcmIdArray);
            params.put("status","4");//状态改为审核驳回
            params.put("updateUserId",ShiroUtils.getLoginUserId());
            params.put("updateTime",now);
            int updateResult = dirDatasetClassifyMapMapper.batchUpdateStatus(params);
            if(updateResult >= 0){
                Map<String, Object> updateFlagParams = new HashMap<>();
                updateFlagParams.put("activeFlag",0);
                updateFlagParams.put("ids",dcmIdArray);
                auditMapper.batchUpdateActiveFlag(updateFlagParams);
                List<DirDataAuditVo> dataAuditList = new ArrayList<>();
                for(String dcmId : dcmIdArray){
                    DirDataAuditVo dataAudit = new DirDataAuditVo();
                    dataAudit.setId(UUID.randomUUID().toString());
                    dataAudit.setDcmId(dcmId);
                    dataAudit.setAuditStatus("4");
                    dataAudit.setAuditorId(ShiroUtils.getLoginUserId());
                    dataAudit.setAuditDate(now);
                    dataAudit.setActiveFlag(1);
                    dataAuditList.add(dataAudit);
                }
                int insertResult = auditMapper.insertListData(dataAuditList);
                if(insertResult == dcmIdArray.length){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean offline(String dcmIds) {
        boolean result = false;
        if(!StringUtils.isEmpty(dcmIds)){
            Map<String,Object> params = new HashMap<>();
            String [] dcmIdArray = dcmIds.split(",");
            Date now = DateTimeUtils.stringToDate(DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date()));
            params.put("ids",dcmIdArray);
            params.put("status","6");//状态改为已下架
            params.put("updateUserId",ShiroUtils.getLoginUserId());
            params.put("updateTime",now);
            int updateResult = dirDatasetClassifyMapMapper.batchUpdateStatus(params);
            if(updateResult >= 0){
                Map<String, Object> updateFlagParams = new HashMap<>();
                updateFlagParams.put("activeFlag",0);
                updateFlagParams.put("ids",dcmIdArray);
                offlineMapper.batchUpdateActiveFlag(updateFlagParams);
                List<DirDataOfflineVo> dataOfflineList = new ArrayList<>();
                for(String dcmId : dcmIdArray){
                    DirDataOfflineVo dataOffline = new DirDataOfflineVo();
                    dataOffline.setId(UUID.randomUUID().toString());
                    dataOffline.setDcmId(dcmId);
                    dataOffline.setOfflineUserId(ShiroUtils.getLoginUserId());
                    dataOffline.setOfflineTime(now);
                    dataOffline.setActiveFlag(1);
                    dataOfflineList.add(dataOffline);
                }
                int insertResult = offlineMapper.insertListData(dataOfflineList);
                if(insertResult == dcmIdArray.length){
                    result = true;
                }
            }
        }
        return result;
    }


    @Override
    public List<DrapDatasetItem> selectDatasetItemByIds(List<String> list) {
        List<DrapDatasetItem> items=null;
        if(list!=null && list.size()>0){
            items= mapper.selectDatasetItemByIds(list);
        }
        return items;
    }

    @Override
    public List<ExportDatasetExcel> selectExportLists(String [] tree_code, String dataset_name, String region_code) {
        return mapper.selectExportLists(tree_code,dataset_name,region_code);
    }
}
