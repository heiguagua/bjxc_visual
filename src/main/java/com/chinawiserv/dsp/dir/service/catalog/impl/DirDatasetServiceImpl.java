package com.chinawiserv.dsp.dir.service.catalog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.base.common.util.Helper;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataAuditVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataOfflineVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataPublishVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataRegisteVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSurveyVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.enums.catalog.ReportScope;
import com.chinawiserv.dsp.dir.enums.catalog.ReportStatus;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataAuditMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataOfflineMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataPublishMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataRegisteMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataitemMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDataitemSourceInfoMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetClassifyMapMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetSourceInfoMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetSurveyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;

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
    private DirDataitemSourceInfoMapper dataitemSourceInfoMapper;

    @Autowired
    private DirDatasetSurveyMapper surveyMapper;

    @Autowired
    private IDirClassifyService dirClassifyService;

    @Autowired
    private ISysRegionService sysRegionService;

    @Autowired
    private DirDatasetSourceInfoMapper datasetSourceInfoMapper;

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
        //vo.setSourceType(SourceTypeEnum.DATA_1.getDbValue());
        vo.setStatus("0");
        vo.setCreateUserId(logionUser.getId());
        vo.setCreateTime(createTime);
        int datasetResult = mapper.baseInsert(vo);
        if(datasetResult>0){
            //数据集来源
            if(!StringUtils.isEmpty(vo.getDrapDatasetId())){
                DirDatasetSourceInfo sourceInfo = new DirDatasetSourceInfo();
                sourceInfo.setId(UUID.randomUUID().toString());
                sourceInfo.setDatasetId(datasetId);
                sourceInfo.setSourceObjId(vo.getDrapDatasetId());
                datasetSourceInfoMapper.baseInsert(sourceInfo);
            }
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
            String relClassifyIds = vo.getRelDatasetCode();
            List<DirDatasetClassifyMapVo> classifyMapVoList = new ArrayList<>();
            if(!StringUtils.isEmpty(classifyIds)){//目录类别是单选
                DirDatasetClassifyMapVo classifyMapVo = new DirDatasetClassifyMapVo();
                String classifyMapId = UUID.randomUUID().toString();
                classifyMapVo.setId(classifyMapId);
                classifyMapVo.setDatasetId(datasetId);
                classifyMapVo.setClassifyId(classifyIds);
                classifyMapVo.setStatus("0");
                classifyMapVo.setRelFlag(0);
                classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(classifyIds));
                classifyMapVoList.add(classifyMapVo);
            }
            if(!StringUtils.isEmpty(relClassifyIds)){//关联目录类别是多选
                String [] relClassifyIdArray = relClassifyIds.split(",");
                for(String relClassifyId : relClassifyIdArray){
                    DirDatasetClassifyMapVo relClassifyMapVo = new DirDatasetClassifyMapVo();
                    String classifyMapId = UUID.randomUUID().toString();
                    relClassifyMapVo.setId(classifyMapId);
                    relClassifyMapVo.setDatasetId(datasetId);
                    relClassifyMapVo.setClassifyId(relClassifyId);
                    relClassifyMapVo.setStatus("0");
                    relClassifyMapVo.setRelFlag(1);
                    relClassifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(relClassifyId));
                    classifyMapVoList.add(relClassifyMapVo);
                }
            }
            classifyMapResult = dirDatasetClassifyMapMapper.insertListItem(classifyMapVoList);
            //数据项来源
            List<DirDataitemSourceInfo> sourceInfos = vo.getSourceInfos();
            //数据集插入成功后，插入该数据集的数据项的数据
            List<DirDataitemVo> dirDataitemVoList = vo.getItems();
            if(!ObjectUtils.isEmpty(dirDataitemVoList)){
                int i=0;
                List<DirDataitemSourceInfo> insertSourceInfos=new ArrayList<>();
                DirDataitemSourceInfo sourceInfo=null;
                List<DirDataitemVo> needInsertVoList = new ArrayList<>(); //用于去除空行数据
                for(DirDataitemVo item : dirDataitemVoList){
                    String itemName = item.getItemName();//用必填项名称,来验证是否是空行数据
                    if(!StringUtils.isEmpty(itemName)){
                        String itemId = UUID.randomUUID().toString();
                        item.setId(itemId);
                        item.setDatasetId(datasetId);
                        item.setStatus("0");
                        item.setCreateUserId(logionUser.getId());
                        item.setCreateTime(createTime);
                        needInsertVoList.add(item);
                        //数据项来源
                        if(!ObjectUtils.isEmpty(sourceInfos)){
                            sourceInfo = sourceInfos.get(i);
                            sourceInfo.setId(itemId);
                            sourceInfo.setItemId(itemId);
                            insertSourceInfos.add(sourceInfo);
                            i++;
                        }
                    }

                }
                itemResult = itemMapper.insertListItem(needInsertVoList);
                if(insertSourceInfos!=null&&insertSourceInfos.size()>0){
                    dataitemSourceInfoMapper.insertList(insertSourceInfos);
                }
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
                if(survey.getOpenedStorage()!=null || survey.getOpenedStructureCount()!=null
                        || survey.getSharedStorage()!=null || survey.getSharedStructureCount()!=null
                        || survey.getStructureCount()!=null || survey.getTotalStorage()!=null){
                    DirDatasetSurvey surveyObj = surveyVoList.get(0);
                    survey.setId(surveyObj.getId());
                    surveyMapper.baseUpdate(survey);
                }
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
        String relClassifyIds = vo.getRelDatasetCode();
        String datasetId = vo.getId();
        //现在选择目录类别为单选
        if(!StringUtils.isEmpty(classifyIds)){
            Map<String,Object> classifyIdParam = new HashMap<>();
            classifyIdParam.put("datasetId",datasetId);
            classifyIdParam.put("relFlag",0);//0是非关联，1是关联
            List<DirDatasetClassifyMapVo> oldClassifyMapVoList = dirDatasetClassifyMapMapper.baseSelect(classifyIdParam);
            if(!ObjectUtils.isEmpty(oldClassifyMapVoList)){
                DirDatasetClassifyMapVo oldClassifyMapVo = oldClassifyMapVoList.get(0);
                String oldClassifyId = oldClassifyMapVo.getClassifyId();
                if(!classifyIds.equals(oldClassifyId)){
                    oldClassifyMapVo.setClassifyId(classifyIds);
                    oldClassifyMapVo.setUpdateUserId(updateUserId);
                    oldClassifyMapVo.setUpdateTime(updateTime);
                    dirDatasetClassifyMapMapper.baseUpdate(oldClassifyMapVo);
                }
            }else{ //如果为空，直接插入
                DirDatasetClassifyMapVo classifyMapVo = new DirDatasetClassifyMapVo();
                String classifyMapId = UUID.randomUUID().toString();
                classifyMapVo.setId(classifyMapId);
                classifyMapVo.setDatasetId(datasetId);
                classifyMapVo.setClassifyId(classifyIds);
                classifyMapVo.setStatus("0");
                classifyMapVo.setRelFlag(0);
                classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(classifyIds));
                classifyMapVo.setUpdateUserId(updateUserId);
                classifyMapVo.setUpdateTime(updateTime);
                dirDatasetClassifyMapMapper.baseInsert(classifyMapVo);
            }
        }
        //数据集的关联的目录类别为多选
        if(!StringUtils.isEmpty(relClassifyIds)){
            Map<String,Object> relClassifyIdsParam = new HashMap<>();
            relClassifyIdsParam.put("datasetId",datasetId);
            relClassifyIdsParam.put("relFlag",1);//0是非关联，1是关联
            List<DirDatasetClassifyMapVo> oldRelClassifyMapVoList = dirDatasetClassifyMapMapper.baseSelect(relClassifyIdsParam);
            String [] relClassifyIdArray = relClassifyIds.split(",");
            //由于需要保留历史数据，所以中间表的数据只能逻辑删除
            //由于有多个值，并能修改，所以不知道是原有的哪个类别改成了现在的哪个类别，只能做新增和删除(逻辑删除)
            List<String> needAddClassifyList = new ArrayList<>();
            List<String> needDeleteClassifyList = new ArrayList<>();
            if(!ObjectUtils.isEmpty(oldRelClassifyMapVoList)){
                //先比较哪些是新增的目录类别
                for(String classifyId : relClassifyIdArray){
                    boolean hasThisClassifyid = false;
                    for(DirDatasetClassifyMapVo oldVo : oldRelClassifyMapVoList){
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
                for(DirDatasetClassifyMapVo oldVo : oldRelClassifyMapVoList){
                    boolean hasThisClassifyid = false;
                    String oldClassifyId = oldVo.getClassifyId();
                    String oldClassifyMapId = oldVo.getId();
                    for(String classifyId : relClassifyIdArray){
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
                        classifyMapVo.setRelFlag(1);
                        classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(addClassifyId));
                        classifyMapVo.setUpdateUserId(updateUserId);
                        classifyMapVo.setUpdateTime(updateTime);
                        addClassifyMapVoList.add(classifyMapVo);
                    }
                    dirDatasetClassifyMapMapper.insertListItem(addClassifyMapVoList);
                }
                //将该删除的中间表的数据的删除标识改为1
                if(needDeleteClassifyList.size()>0){
                    /*StringBuffer idsBuffer = new StringBuffer();
                    for(int i=0,ii=needDeleteClassifyList.size();i<ii;i++){
                        if(i==0){
                            idsBuffer.append("'").append(needDeleteClassifyList.get(i)).append("'");
                        }else{
                            idsBuffer.append(",'").append(needDeleteClassifyList.get(i)).append("'");
                        }
                    }*/
                    Map<String,Object> deleteParam = new HashMap<>();
                    deleteParam.put("deleteFlag",1);
                    deleteParam.put("ids",needDeleteClassifyList.toArray());
                    deleteParam.put("updateUserId",updateUserId);
                    deleteParam.put("updateTime",updateTime);
                    dirDatasetClassifyMapMapper.batchUpdateStatus(deleteParam);
                }
            }else{ //如果修改前关联目录类别为空，则把新的所有数据都直接插入
                List<DirDatasetClassifyMapVo> addClassifyMapVoList = new ArrayList<>();
                for(String addClassifyId : relClassifyIdArray){
                    DirDatasetClassifyMapVo classifyMapVo = new DirDatasetClassifyMapVo();
                    String classifyMapId = UUID.randomUUID().toString();
                    classifyMapVo.setId(classifyMapId);
                    classifyMapVo.setDatasetId(datasetId);
                    classifyMapVo.setClassifyId(addClassifyId);
                    classifyMapVo.setStatus("0");
                    classifyMapVo.setRelFlag(1);
                    classifyMapVo.setInfoResourceCode(dirClassifyService.generateDatasetCode(addClassifyId));
                    classifyMapVo.setUpdateUserId(updateUserId);
                    classifyMapVo.setUpdateTime(updateTime);
                    addClassifyMapVoList.add(classifyMapVo);
                }
                dirDatasetClassifyMapMapper.insertListItem(addClassifyMapVoList);
            }
        }else{ //如果修改后关联目录类别为空，则需要把数据库中已有的删除
            Map<String,Object> relClassifyIdsParam = new HashMap<>();
            relClassifyIdsParam.put("datasetId",datasetId);
            relClassifyIdsParam.put("relFlag",1);//0是非关联，1是关联
            List<DirDatasetClassifyMapVo> oldRelClassifyMapVoList = dirDatasetClassifyMapMapper.baseSelect(relClassifyIdsParam);
            if(!ObjectUtils.isEmpty(oldRelClassifyMapVoList)){
                List<String> needDeleteRelClassifyIdList = new ArrayList<>();
                for(DirDatasetClassifyMapVo oldVo : oldRelClassifyMapVoList){
                    String mapId = oldVo.getId();
                    needDeleteRelClassifyIdList.add(mapId);
                }
                Map<String,Object> deleteParam = new HashMap<>();
                deleteParam.put("deleteFlag",1);
                deleteParam.put("ids",needDeleteRelClassifyIdList.toArray());
                deleteParam.put("updateUserId",updateUserId);
                deleteParam.put("updateTime",updateTime);
                dirDatasetClassifyMapMapper.batchUpdateStatus(deleteParam);
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
                    String newItemName = newItemVo.getItemName();
                    //用必填项名称来验证，是否是新增后又删除了的行数据，这种数据所有值都是空
                    if(!StringUtils.isEmpty(newItemName)){
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
                }
                //反过来比较哪些是删除的目录类别
                for(DirDataitemVo oldItemVo : oldItemVoList){
                    boolean hasThisItem = false;
                    String oldItemId = oldItemVo.getId();
                    for(DirDataitemVo newItemVo : newItemVoList){
                        String newItemId = newItemVo.getId();
                        if(!StringUtils.isEmpty(newItemId) && newItemId.equals(oldItemId)){
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
                        itemMapper.baseUpdate(updateItemVo);
                    }
//                    itemMapper.batchUpdate(needUpdateItemList);
                }
                //将该删除的中间表的数据的删除标识改为1
                if(needDeleteItemList.size()>0){
                    for(DirDataitemVo deleteItemVo : needDeleteItemList){
                        deleteItemVo.setDeleteFlag(1);
                        deleteItemVo.setUpdateUserId(updateUserId);
                        deleteItemVo.setUpdateTime(updateTime);
                        itemMapper.baseUpdate(deleteItemVo);
                    }
//                    itemMapper.batchUpdate(needDeleteItemList);
                }
            }else{//如果表里该数据集没有任何数据项，则全部新增(排除掉为空的数据)
                for(DirDataitemVo addItemVo : newItemVoList){
                    String itemName = addItemVo.getItemName();
                    if(!StringUtils.isEmpty(itemName)){
                        addItemVo.setId(UUID.randomUUID().toString());
                        addItemVo.setDatasetId(datasetId);
                        addItemVo.setStatus("0");
                        addItemVo.setCreateUserId(updateUserId);
                        addItemVo.setCreateTime(updateTime);
                    }
                }
                itemMapper.insertListItem(newItemVoList);
            }
        }else{ //如果当前值为空，则把数据库中有的数据项的删除标识改为1
            if(!ObjectUtils.isEmpty(oldItemVoList)){
                for(DirDataitemVo deleteItemVo : oldItemVoList){
                    deleteItemVo.setDeleteFlag(1);
                    deleteItemVo.setUpdateUserId(updateUserId);
                    deleteItemVo.setUpdateTime(updateTime);
                    itemMapper.baseUpdate(deleteItemVo);
                }
//                itemMapper.batchUpdate(oldItemVoList);
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
        mapParam.put("datasetId", id);
        List<DirDataitemVo> itemVoList = itemMapper.selectInfoList(mapParam);
        if(!ObjectUtils.isEmpty(itemVoList)){
            dirDatasetVo.setItems(itemVoList);
        }
        List<DirDatasetClassifyMapVo> classifyMapVoList = dirDatasetClassifyMapMapper.selectVoPage(new Page<>(), mapParam);
        if(!ObjectUtils.isEmpty(classifyMapVoList)){
            String relClassifyName = "";
            for(int i=0,ii=classifyMapVoList.size();i<ii;i++){
                DirDatasetClassifyMapVo classifyMapVo = classifyMapVoList.get(i);
                int relFlag = classifyMapVo.getRelFlag();
                String classifyId = classifyMapVo.getClassifyId();
                String classifyStructureName = classifyMapVoList.get(i).getClassifyStructureName();
                String infoResourceCode = classifyMapVo.getInfoResourceCode();
                if(relFlag == 0){
                    dirDatasetVo.setClassifyIds(classifyId);
                    dirDatasetVo.setClassifyName(classifyStructureName);
                    dirDatasetVo.setInfoResourceCode(infoResourceCode);
                }else{
                    relClassifyName += classifyStructureName+",";
                }
            }
            if(!"".equals(relClassifyName)){
                relClassifyName = relClassifyName.substring(0,relClassifyName.length()-1);
            }
            dirDatasetVo.setRelClassifyName(relClassifyName);
        }
		return dirDatasetVo;
	}

    @Override
    public Page<DirDatasetVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDatasetVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        String regionCode = (String)paramMap.get("regionCode");
        if(!StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCode = allRegionCode.substring(0,allRegionCode.length()-1);
                    paramMap.put("allRegionCode",allRegionCode);
                }
            }
        }
        //获取当前登录用户的最大权限角色(-1：超级管理员,0:区域管理员)
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("loginUserIdForAuthority",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
        List<DirDatasetVo> dirDatasetClassifyMapVoList = mapper.selectInfoPage(page, paramMap);
        page.setRecords(dirDatasetClassifyMapVoList);
//        page.setTotal(dirDatasetClassifyMapMapper.selectVoCount(paramMap));
        return page;
	}

    @Override
    public Page<DirDatasetVo> selectDirTransferPage(Map<String, Object> paramMap) {
        Page<DirDatasetVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        String regionCode = (String)paramMap.get("regionCode");
        if(!StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCode = allRegionCode.substring(0,allRegionCode.length()-1);
                    paramMap.put("allRegionCode",allRegionCode);
                }
            }
        }
        //获取当前登录用户的最大权限角色(-1：超级管理员,0:区域管理员)
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("loginUserIdForAuthority",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
        List<DirDatasetVo> dirDatasetClassifyMapVoList = mapper.selectDirReportPage(page,paramMap);
        page.setRecords(dirDatasetClassifyMapVoList);
    	return page;
    }
    
    @Override
    public HandleResult updateDirReport(Map<String,Object> paramMap) {
    	//TODO
    	HandleResult result = new HandleResult();
    
    	if (!Helper.checkParam(paramMap.get("scmId")))
    	{
    		result.error("上报目录失败，当前目录参数为空。");
    		return result;
    	}
    	
    	if (!Helper.checkParam(paramMap.get("scope")))
    	{
    		result.error("上报目录失败，上报内容不能为空。");
    		return result;
    	}
//    	if (!Helper.checkParam(paramMap.get("uploadAddr")))
//    	{
//    		result.error("上报目录失败，上级接口地址不能为空。");
//    		return result;
//    	}
    	String[] scmIdArr=String.valueOf(paramMap.get("scmId")).split(",");
    	DirDataTransfer transfer = new DirDataTransfer();
    	Integer num = null;
    	Map<String,Object> param = new HashMap<String, Object>(1);
    	for (String scmId:scmIdArr){
    		transfer = new DirDataTransfer();
    		transfer.setId(Helper.getUUID());
    		//TODO上报远程服务器
    		transfer.setDcmId(scmId);
    		param.put("transferId", scmId);
    		num=mapper.getServiceNum(param);
    		if (!Helper.checkParam(num) || num==0)
    		{
        		transfer.setTrasnferScope(ReportScope.SOURCE_DIR.getKey());
    		}else{
        		transfer.setTrasnferScope(String.valueOf(paramMap.get("scope")));
    		}
    		transfer.setTransferStatus(ReportStatus.REPORT_SUCCESS.getKey());
    		transfer.setTransferTime(new Date());
    		transfer.setTransferUserId(ShiroUtils.getLoginUserId());
    		transfer.setTransferUserName(ShiroUtils.getLoginUserName());
    		mapper.insertDirTransfer(transfer);
    	}
    	result.success("上报成功");
    	return result;
    }
    @Override
    public Page<DirDatasetClassifyMapVo> selectClassifyMapVoPage(Map<String, Object> paramMap){
        Page<DirDatasetClassifyMapVo> page = getPage(paramMap);
        page.setOrderByField("update_time");
        page.setAsc(false);
        //查找出当前区域及所有子区域的code，用于过滤数据集
        String regionCode = (String)paramMap.get("regionCode");
        if(!StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCode = allRegionCode.substring(0,allRegionCode.length()-1);
                    paramMap.put("allRegionCode",allRegionCode);
                }
            }
        }
        //获取当前登录用户的最大权限角色(-1：超级管理员,0:区域管理员)
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("loginUserIdForAuthority",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
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
        //查找出当前区域及所有子区域的code，用于过滤数据集
        String regionCode = (String)paramMap.get("regionCode");
        if(!StringUtils.isEmpty(regionCode)){
            StringBuffer allRegionCodeBuffer = new StringBuffer();
            List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
            if(!ObjectUtils.isEmpty(SysRegionVoList)){
                for(SysRegionVo vo : SysRegionVoList){
                    String subRegionCode = vo.getRegionCode();
                    allRegionCodeBuffer.append("'").append(subRegionCode).append("',");
                }
                if(allRegionCodeBuffer.length()>0){
                    String allRegionCode = allRegionCodeBuffer.toString();
                    allRegionCode = allRegionCode.substring(0,allRegionCode.length()-1);
                    paramMap.put("allRegionCode",allRegionCode);
                }
            }
        }
        //获取当前登录用户的最大权限角色(-1：超级管理员,0:区域管理员)
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("loginUserIdForAuthority",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
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

    /**
     * 获取梳理大普查
     * @param id
     * @return
     */
    @Override
    public DirDatasetSurvey selectDrapSurveyByDatasetId(String id) {
        return surveyMapper.selectDrapSurveyByDatasetId(id);
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

    @Override
    public int insertListDataset(List<DirDataset> list) {
        int i=0;
        if(list!=null&&list.size()>0){
           i=mapper.insertListDataset(list);
        }
        return i;
    }

    @Override
    public DirDataset selectDatasetByNameAndClassifyId(String datasetName, String classifyId) {
        DirDataset dirDataset=null;
        if(!StringUtils.isEmpty(datasetName)&&!StringUtils.isEmpty(classifyId)){
            dirDataset=mapper.selectDatasetByNameAndClassifyId(datasetName,classifyId);
        }
        return dirDataset;
    }
}
