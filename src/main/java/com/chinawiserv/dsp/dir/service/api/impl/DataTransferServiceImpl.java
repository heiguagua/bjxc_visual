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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 解析上报数据
     */
    @Resource
    PlatformTransactionManager platformTransactionManager;
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

        resultMap.put("dirDataTransfer", dirDataTransferList);

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
        List<DirDataitem> dirDataitemList = dirDataitemMapper.selectList(new EntityWrapper<DirDataitem>().eq("dataset_id",dirDataset.getId()));
        resultMap.put("dirDataitemList", dirDataitemList);
        /**
         * 获取资源提供部门信息
         * */
        SysDept sysDept = sysDeptMapper.selectById(dirDataset.getBelongDeptId());
        resultMap.put("dysDept",sysDept);
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
        resultMap.put("dirDatasetExtCarrier", dirDatasetExtCarrierList);
        /**
         * 数据集扩展信息（【国】资源格式）dir_dataset_ext_format
         * */
        List<DirDatasetExtFormat> dirDatasetExtFormatList = dirDatasetExtFormatMapper.selectList(new EntityWrapper<DirDatasetExtFormat>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtFormat", dirDatasetExtFormatList);

        /**
         * 数据集扩展信息（【川】服务对象）dir_dataset_ext_service_target
         * */
        List<DirDatasetExtServiceTarget> dirDatasetExtServiceTargetList = dirDatasetExtServiceTargetMapper.selectList(new EntityWrapper<DirDatasetExtServiceTarget>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtServiceTarget", dirDatasetExtServiceTargetList);
        /**
         * 数据集扩展信息（【川】服务领域）dir_dataset_ext_sevice_field
         * */
        List<DirDatasetExtSeviceField> dirDatasetExtSeviceFieldList = dirDatasetExtSeviceFieldMapper.selectList(new EntityWrapper<DirDatasetExtSeviceField>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtSeviceField", dirDatasetExtSeviceFieldList);
        /**
         * 数据集扩展信息（【川】共享咨询）dir_dataset_ext_share_consult
         * */
        List<DirDatasetExtShareConsult> dirDatasetExtShareConsultList = dirDatasetExtShareConsultMapper.selectList(new EntityWrapper<DirDatasetExtShareConsult>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtShareConsult", dirDatasetExtShareConsultList);
        /**
         * 数据集扩展信息（【川】主要来源）dir_dataset_ext_source
         * */
        List<DirDatasetExtSource> dirDatasetExtSourceList = dirDatasetExtSourceMapper.selectList(new EntityWrapper<DirDatasetExtSource>().eq("dataset_id", dirDataset.getId()));
        resultMap.put("dirDatasetExtSource", dirDatasetExtSourceList);

        return resultMap;
    }

    @Override
    public Map<String, Object> analysisReportData(Map<String, Object> paramMap) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        /**
         * 解析上报数据
         * */
        String dataSource = (String)paramMap.get("dataSource");
        if(StringUtils.isBlank(dataSource)&&!dataSource.startsWith("{")&&!dataSource.endsWith("}")){
            logger.error("数据为空或非JSON格式");
            return null;
        }
        JSONObject dataSourceJson = JSONObject.fromObject(dataSource);
        if(null == dataSourceJson || dataSourceJson.isEmpty()){
            logger.error("数据为空");
            return null;
        }
        Gson gson = new Gson();
        DataTransferVo dataTransferVo = gson.fromJson(dataSourceJson.toString(),DataTransferVo.class);

        DirClassify dirClassify = dataTransferVo.getDirClassify();

        System.out.println(dirClassify.getClassifyCode());

        try{


        }catch (Exception e){
            platformTransactionManager.rollback(status);
            logger.error(e.getMessage());
        }finally {
            platformTransactionManager.commit(status);
        }

        return null;
    }
}
