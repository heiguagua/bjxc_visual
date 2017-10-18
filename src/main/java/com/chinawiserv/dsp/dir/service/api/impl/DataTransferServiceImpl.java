package com.chinawiserv.dsp.dir.service.api.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DataTransferVo;
import com.chinawiserv.dsp.dir.mapper.api.DirServiceInfoMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.*;
import com.chinawiserv.dsp.dir.service.api.IDataTransferService;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/10/14
 * Time:19:22
 * Chinawiserv Technologies Co., Ltd.
 */
@Service
public class DataTransferServiceImpl implements IDataTransferService {
    /**
     * 解析上报数据
     */
    @Resource
    PlatformTransactionManager platformTransactionManager;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DirDatasetClassifyMapMapper dirDatasetClassifyMapMapper;
    @Autowired
    private DirDatasetMapper dirDatasetMapper;
    @Autowired
    private DirClassifyMapper dirClassifyMapper;
    @Autowired
    private DirDataitemMapper dirDataitemMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private DirServiceInfoMapper dirServiceInfoMapper;
    @Autowired
    private DirDatasetServiceMapMapper dirDatasetServiceMapMapper;
    @Autowired
    private DirDataTransferMapper dirDataTransferMapper;
    @Autowired
    private DirDatasetExtCarrierMapper dirDatasetExtCarrierMapper;
    @Autowired
    private DirDatasetExtFormatMapper dirDatasetExtFormatMapper;
    @Autowired
    private DirDatasetExtServiceTargetMapper dirDatasetExtServiceTargetMapper;
    @Autowired
    private DirDatasetExtShareConsultMapper dirDatasetExtShareConsultMapper;
    @Autowired
    private DirDatasetExtSeviceFieldMapper dirDatasetExtSeviceFieldMapper;
    @Autowired
    private DirDatasetExtSourceMapper dirDatasetExtSourceMapper;

    /**
     * 封装上报数据
     */
    @Override
    public Map<String, Object> getReportDataByDataset(Map<String, Object> paramMap) {
        Map resultMap = Maps.newHashMap();
        String dcmId = (String) paramMap.get("dcmId");
        if (StringUtils.isBlank(dcmId)) {
            return resultMap;
        }
        /**
         * 获取DCM关系表数据
         * */
        DirDatasetClassifyMap dirDatasetClassifyMap = dirDatasetClassifyMapMapper.selectById(dcmId);
        resultMap.put("dirDatasetClassifyMap", dirDatasetClassifyMap);
        if (null == dirDatasetClassifyMap) {
            return resultMap;
        }

        /**
         * 获取资源目录上报信息
         * */
        List<DirDataTransfer> dirDataTransferList = dirDataTransferMapper.selectList(new EntityWrapper<DirDataTransfer>().eq("dcm_id", dcmId));

        resultMap.put("dirDataTransferList", dirDataTransferList);

        /**
         * 获取数据集信息
         * */
        DirDataset dirDataset = dirDatasetMapper.selectById(dirDatasetClassifyMap.getDatasetId());
        resultMap.put("dirDataset", dirDataset);

        /**
         * 获取目录信息
         * */
        DirClassify dirClassify = dirClassifyMapper.selectById(dirDatasetClassifyMap.getClassifyId());
        resultMap.put("dirClassify", dirClassify);
        /**
         * 获取数据项信息
         * */
        List<DirDataitem> dirDataitemList = dirDataitemMapper.selectList(new EntityWrapper<DirDataitem>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDataitemList", dirDataitemList);
        /**
         * 获取资源提供部门信息
         * */
        SysDept sysDept = sysDeptMapper.selectById(dirDataset.getBelongDeptId());
        resultMap.put("dysDept", sysDept);
        /**
         * 获取封装的服务信息
         * */
        List<DirDatasetServiceMap> dirDatasetServiceMapList = dirDatasetServiceMapMapper.selectList(new EntityWrapper<DirDatasetServiceMap>().eq("obj_id", dcmId));
        resultMap.put("dirDatasetServiceMapList", dirDatasetServiceMapList);

        Set serviceIdList = Sets.newHashSet();
        if (null != dirDatasetServiceMapList && !dirDatasetServiceMapList.isEmpty()) {
            for (DirDatasetServiceMap dirDatasetServiceMap : dirDatasetServiceMapList) {
                serviceIdList.add(dirDatasetServiceMap.getServiceId());
            }
        }
        List<DirServiceInfo> dirServiceInfoList = dirServiceInfoMapper.selectList(new EntityWrapper<DirServiceInfo>().in("id", serviceIdList));
        resultMap.put("dirServiceInfoList", dirServiceInfoList);

        /**
         * 获取数据集扩展信息
         * */
        /**
         * 数据集扩展信息（【川】基本载体）dir_dataset_ext_carrier
         * */

        List<DirDatasetExtCarrier> dirDatasetExtCarrierList = dirDatasetExtCarrierMapper.selectList(new EntityWrapper<DirDatasetExtCarrier>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtCarrierList", dirDatasetExtCarrierList);
        /**
         * 数据集扩展信息（【国】资源格式）dir_dataset_ext_format
         * */
        List<DirDatasetExtFormat> dirDatasetExtFormatList = dirDatasetExtFormatMapper.selectList(new EntityWrapper<DirDatasetExtFormat>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtFormatList", dirDatasetExtFormatList);

        /**
         * 数据集扩展信息（【川】服务对象）dir_dataset_ext_service_target
         * */
        List<DirDatasetExtServiceTarget> dirDatasetExtServiceTargetList = dirDatasetExtServiceTargetMapper.selectList(new EntityWrapper<DirDatasetExtServiceTarget>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtServiceTargetList", dirDatasetExtServiceTargetList);
        /**
         * 数据集扩展信息（【川】服务领域）dir_dataset_ext_sevice_field
         * */
        List<DirDatasetExtSeviceField> dirDatasetExtSeviceFieldList = dirDatasetExtSeviceFieldMapper.selectList(new EntityWrapper<DirDatasetExtSeviceField>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtSeviceFieldList", dirDatasetExtSeviceFieldList);
        /**
         * 数据集扩展信息（【川】共享咨询）dir_dataset_ext_share_consult
         * */
        List<DirDatasetExtShareConsult> dirDatasetExtShareConsultList = dirDatasetExtShareConsultMapper.selectList(new EntityWrapper<DirDatasetExtShareConsult>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtShareConsultList", dirDatasetExtShareConsultList);
        /**
         * 数据集扩展信息（【川】主要来源）dir_dataset_ext_source
         * */
        List<DirDatasetExtSource> dirDatasetExtSourceList = dirDatasetExtSourceMapper.selectList(new EntityWrapper<DirDatasetExtSource>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtSourceList", dirDatasetExtSourceList);

        return resultMap;
    }

    @Override
    public Map<String, Object> analysisReportData(String dataSource) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        Map result = Maps.newHashMap();
        int countInsert = 0;
        int countUpdate = 0;
        /**
         * 解析上报数据
         * */
        JSONObject dataSourceJson = null;
        try {
            dataSourceJson = JSONObject.fromObject(dataSource);
        }catch (Exception e){
            logger.error("数据为空或者格式错误！");
            return result;
        }
        Gson gson = new Gson();
        DataTransferVo dataTransferVo = gson.fromJson(dataSourceJson.toString(), DataTransferVo.class);

        /**
         * 获取DCM关系表实体
         * */
        DirDatasetClassifyMap dirDatasetClassifyMap = dataTransferVo.getDirDatasetClassifyMap();

        /**
         * 获取数据集信息实体
         * */
        DirDataset dirDataset = dataTransferVo.getDirDataset();
        /**
         * 获取目录信息实体
         * */
        DirClassify dirClassify = dataTransferVo.getDirClassify();
        /**
         * 获取数据项信息实体的集合
         * */
        List<DirDataitem> dirDataitemList = dataTransferVo.getDirDataitemList();
        /**
         * 提供部门消息的实体
         * */
        SysDept sysDept = dataTransferVo.getSysDept();
        /**
         * 获取上报信息的实体的集合
         * */
        List<DirDataTransfer> dirDataTransferList = dataTransferVo.getDirDataTransferList();
        /**
         * 获取服务封装信息关系的实体的集合
         * */
        List<DirDatasetServiceMap> dirDatasetServiceMapList = dataTransferVo.getDirDatasetServiceMapList();
        /**
         * 获取服务封装信息的实体的集合
         * */
        List<DirServiceInfo> dirServiceInfoList = dataTransferVo.getDirServiceInfoList();
        /**
         * 获取扩展信息的实体
         * */
        /**
         * 数据集扩展信息（【川】基本载体）dir_dataset_ext_carrier
         * */
        List<DirDatasetExtCarrier> dirDatasetExtCarrierList = dataTransferVo.getDirDatasetExtCarrierList();
        /**
         * 数据集扩展信息（【国】资源格式）dir_dataset_ext_format
         * */
        List<DirDatasetExtFormat> dirDatasetExtFormatList = dataTransferVo.getDirDatasetExtFormatList();

        /**
         * 数据集扩展信息（【川】服务对象）dir_dataset_ext_service_target
         * */
        List<DirDatasetExtServiceTarget> dirDatasetExtServiceTargetList = dataTransferVo.getDirDatasetExtServiceTargetList();
        /**
         * 数据集扩展信息（【川】服务领域）dir_dataset_ext_sevice_field
         * */
        List<DirDatasetExtSeviceField> dirDatasetExtSeviceFieldList = dataTransferVo.getDirDatasetExtSeviceFieldList();
        /**
         * 数据集扩展信息（【川】共享咨询）dir_dataset_ext_share_consult
         * */
        List<DirDatasetExtShareConsult> dirDatasetExtShareConsultList = dataTransferVo.getDirDatasetExtShareConsultList();
        /**
         * 数据集扩展信息（【川】主要来源）dir_dataset_ext_source
         * */
        List<DirDatasetExtSource> dirDatasetExtSourceList = dataTransferVo.getDirDatasetExtSourceList();


        try {
            if (null != dirDatasetClassifyMap) {

                if (null == dirDatasetClassifyMapMapper.selectById(dirDatasetClassifyMap.getId())) {
                    countInsert = dirDatasetClassifyMapMapper.insert(dirDatasetClassifyMap);
                } else {
                    countUpdate = dirDatasetClassifyMapMapper.updateById(dirDatasetClassifyMap);
                }
            }
            if (null != dirDataset) {
                if (null == dirDatasetMapper.selectById(dirDataset.getId())) {
                    countInsert = dirDatasetMapper.insert(dirDataset);
                } else {
                    countUpdate = dirDatasetMapper.updateById(dirDataset);
                }
            }
            if (null != dirClassify) {
                if (null == dirClassifyMapper.selectById(dirClassify.getId())) {
                    countInsert = dirClassifyMapper.insert(dirClassify);
                } else {
                    countUpdate = dirClassifyMapper.updateById(dirClassify);
                }
            }
            if (null != dirDataitemList && !dirDataitemList.isEmpty()) {

                for (DirDataitem dirDataitem : dirDataitemList) {
                    if (null != dirDataitem) {
                        if (null == dirDataitemMapper.selectById(dirDataitem.getId())) {
                            countInsert += dirDataitemMapper.insert(dirDataitem);
                        } else {
                            countUpdate += dirDataitemMapper.updateById(dirDataitem);
                        }
                    }
                }
            }
            if (null != sysDept) {
                if (null == sysDeptMapper.selectById(sysDept.getId())) {
                    countInsert = sysDeptMapper.insert(sysDept);
                } else {
                    countUpdate = sysDeptMapper.updateById(sysDept);
                }
            }

            if (null != dirDataTransferList && !dirDataTransferList.isEmpty()) {
                for (DirDataTransfer dirDataTransfer : dirDataTransferList) {
                    if (null != dirDataTransfer) {
                        if (null == dirDataTransferMapper.selectById(dirDataTransfer.getId())) {
                            countInsert += dirDataTransferMapper.insert(dirDataTransfer);
                        } else {
                            countUpdate += dirDataTransferMapper.updateById(dirDataTransfer);
                        }
                    }
                }
            }

            if (null != dirDatasetServiceMapList && !dirDatasetServiceMapList.isEmpty()) {
                for (DirDatasetServiceMap dirDatasetServiceMap : dirDatasetServiceMapList) {
                    if (null != dirDatasetServiceMap) {
                        if (null == dirDatasetServiceMapMapper.selectById(dirDatasetServiceMap.getId())) {
                            countInsert += dirDatasetServiceMapMapper.insert(dirDatasetServiceMap);
                        } else {
                            countUpdate += dirDatasetServiceMapMapper.updateById(dirDatasetServiceMap);
                        }
                    }
                }
            }

            if (null != dirServiceInfoList && !dirServiceInfoList.isEmpty()) {
                for (DirServiceInfo dirServiceInfo : dirServiceInfoList) {
                    if (null != dirServiceInfo) {
                        if (null == dirServiceInfoMapper.selectById(dirServiceInfo.getId())) {
                            countInsert += dirServiceInfoMapper.insert(dirServiceInfo);
                        } else {
                            countUpdate += dirServiceInfoMapper.updateById(dirServiceInfo);
                        }
                    }
                }
            }

            if (null != dirDatasetExtCarrierList && !dirDatasetExtCarrierList.isEmpty()) {
                for (DirDatasetExtCarrier dirDatasetExtCarrier : dirDatasetExtCarrierList) {
                    if (null != dirDatasetExtCarrier) {
                        if (null == dirDatasetExtCarrierMapper.selectById(dirDatasetExtCarrier.getId())) {
                            countInsert += dirDatasetExtCarrierMapper.insert(dirDatasetExtCarrier);
                        } else {
                            countUpdate += dirDatasetExtCarrierMapper.updateById(dirDatasetExtCarrier);
                        }
                    }
                }
            }

            if (null != dirDatasetExtFormatList && !dirDatasetExtFormatList.isEmpty()) {
                for (DirDatasetExtFormat dirDatasetExtFormat : dirDatasetExtFormatList) {
                    if (null != dirDatasetExtFormat) {
                        if (null == dirDatasetExtFormatMapper.selectById(dirDatasetExtFormat.getId())) {
                            countInsert += dirDatasetExtFormatMapper.insert(dirDatasetExtFormat);
                        } else {
                            countUpdate += dirDatasetExtFormatMapper.updateById(dirDatasetExtFormat);
                        }
                    }
                }
            }

            if (null != dirDatasetExtServiceTargetList && !dirDatasetExtServiceTargetList.isEmpty()) {
                for (DirDatasetExtServiceTarget dirDatasetExtServiceTarget : dirDatasetExtServiceTargetList) {
                    if (null != dirDatasetExtServiceTarget) {
                        if (null == dirDatasetExtServiceTargetMapper.selectById(dirDatasetExtServiceTarget.getId())) {
                            countInsert += dirDatasetExtServiceTargetMapper.insert(dirDatasetExtServiceTarget);
                        } else {
                            countUpdate += dirDatasetExtServiceTargetMapper.updateById(dirDatasetExtServiceTarget);
                        }
                    }
                }
            }

            if (null != dirDatasetExtSeviceFieldList && !dirDatasetExtSeviceFieldList.isEmpty()) {
                for (DirDatasetExtSeviceField dirDatasetExtSeviceField : dirDatasetExtSeviceFieldList) {
                    if (null != dirDatasetExtSeviceField) {
                        if (null == dirDatasetExtSeviceFieldMapper.selectById(dirDatasetExtSeviceField.getId())) {
                            countInsert += dirDatasetExtSeviceFieldMapper.insert(dirDatasetExtSeviceField);
                        } else {
                            countUpdate += dirDatasetExtSeviceFieldMapper.updateById(dirDatasetExtSeviceField);
                        }
                    }
                }
            }

            if (null != dirDatasetExtShareConsultList && !dirDatasetExtShareConsultList.isEmpty()) {
                for (DirDatasetExtShareConsult dirDatasetExtShareConsult : dirDatasetExtShareConsultList) {
                    if (null != dirDatasetExtShareConsult) {
                        if (null == dirDatasetExtShareConsultMapper.selectById(dirDatasetExtShareConsult.getId())) {
                            countInsert += dirDatasetExtShareConsultMapper.insert(dirDatasetExtShareConsult);
                        } else {
                            countUpdate += dirDatasetExtShareConsultMapper.updateById(dirDatasetExtShareConsult);
                        }
                    }
                }
            }

            if (null != dirDatasetExtSourceList && !dirDatasetExtSourceList.isEmpty()) {
                for (DirDatasetExtSource dirDatasetExtSource : dirDatasetExtSourceList) {
                    if (null != dirDatasetExtSource) {
                        if (null == dirDatasetExtSourceMapper.selectById(dirDatasetExtSource.getId())) {
                            countInsert += dirDatasetExtSourceMapper.insert(dirDatasetExtSource);
                        } else {
                            countUpdate += dirDatasetExtSourceMapper.updateById(dirDatasetExtSource);
                        }
                    }
                }
            }
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
            logger.error(e.getMessage());
        } finally {
            platformTransactionManager.commit(status);
            /**
             * 插入条数
             * */
            result.put("insert",countInsert);
            /**
             * 更新条数
             * */
            result.put("update",countUpdate);
        }
        return result;
    }
}
