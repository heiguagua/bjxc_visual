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
            ext.setDataset_id(vo.getId());
            mapper.extInsert(ext);
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
            //数据集插入成功后，插入该数据集的数据项的数据
            List<DirDataitemVo> dirDataitemVoList = vo.getItems();
            if(!ObjectUtils.isEmpty(dirDataitemVoList)){
                for(DirDataitemVo item : dirDataitemVoList){
                    String itemId = UUID.randomUUID().toString();
                    item.setId(itemId);
                    item.setDatasetId(datasetId);
                    item.setStatus("0");
                    item.setCreateUserId(logionUser.getId());
                    item.setCreateTime(createTime);
                }
                itemResult = itemMapper.insertListItem(dirDataitemVoList);
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
    public boolean updateVO(DirDatasetVo vo) {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDatasetVo selectVoById(String id) throws Exception {
		return null;
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
}
