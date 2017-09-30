package com.chinawiserv.dsp.dir.service.cs.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.Condition;
import com.chinawiserv.dsp.dir.entity.po.cs.*;
import com.chinawiserv.dsp.dir.mapper.cs.*;
import com.chinawiserv.dsp.dir.service.cs.ICsDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixy on 2017/9/29.
 */
@Service
public class CsDataSyncServiceImpl implements ICsDataSyncService {
    @Autowired
    private CsDataSyncCollectBlockMapper csDataSyncCollectBlockMapper;
    @Autowired
    private CsDataSyncCollectColumnMapper csDataSyncCollectColumnMapper;
    @Autowired
    private CsDataSyncCollectDbMapper csDataSyncCollectDbMapper;
    @Autowired
    private CsDataSyncCollectMapper csDataSyncCollectMapper;
    @Autowired
    private CsDataSyncMappingMapper csDataSyncMappingMapper;
    @Autowired
    private CsDataSyncMappingPropertyMapper csDataSyncMappingPropertyMapper;

    @Override
    public void syncData(String type, String jsonObj) throws Exception {
        JSONObject jsonObject = (JSONObject) JSON.parse(jsonObj);
        if ("collect".equals(type)) {
            //抓取数据
            CsDataSyncCollect csDataSyncCollect = JSON.parseObject(jsonObj, CsDataSyncCollect.class);
            if (csDataSyncCollect == null) {
                throw new Exception("CsDataSyncCollect is null");
            }
            CsDataSyncCollectDb csDataSyncCollectDb = JSON.parseObject(jsonObject.get("dbConf").toString(), CsDataSyncCollectDb.class);
            if (csDataSyncCollectDb == null) {
                throw new Exception("CsDataSyncCollect is null");
            }
            csDataSyncCollectDb.setDbType(csDataSyncCollect.getDbType());
            csDataSyncCollectDb.setId(csDataSyncCollect.getDbId());
            csDataSyncCollectDb.setDbDesc(csDataSyncCollect.getDbDesc());
            CsDataSyncCollectDb db = csDataSyncCollectDbMapper.selectCsDataSyncCollectDbById(csDataSyncCollect.getDbId());
            if (db != null) {
                csDataSyncCollectDbMapper.updateCsDataSyncCollectDbById(csDataSyncCollectDb);
            } else {
                csDataSyncCollectDbMapper.insertCsDataSyncCollectDb(csDataSyncCollectDb);
            }
            CsDataSyncCollect table = csDataSyncCollectMapper.selectCsDataSyncCollectById(csDataSyncCollect.getId());

            if (table != null) {
                csDataSyncCollectMapper.updateCsDataSyncCollectById(csDataSyncCollect);
            } else {
                csDataSyncCollectMapper.insertCsDataSyncCollect(csDataSyncCollect);
            }
            List<CsDataSyncCollectColumn> csDataSyncCollectBlockColumns = JSON.parseArray(jsonObject.get("columnDesc").toString(), CsDataSyncCollectColumn.class);
            if (csDataSyncCollectBlockColumns != null && !csDataSyncCollectBlockColumns.isEmpty()) {
                csDataSyncCollectBlockColumns.forEach(csDataSyncCollectBlockColumn -> {
                            csDataSyncCollectBlockColumn.setTableId(csDataSyncCollect.getId());
                            csDataSyncCollectColumnMapper.delete(
                                    Condition.create().where("table_id = {0}", csDataSyncCollect.getId()).and("cloumn_name = {0}", csDataSyncCollectBlockColumn.getCloumnName()));
                            csDataSyncCollectColumnMapper.insertCsDataSyncCollectColumn(csDataSyncCollectBlockColumn);
                        }
                );
            }
            List<CsDataSyncCollectBlock> csDataSyncCollectBlocks = JSON.parseArray(jsonObject.get("tableWebsitBlockList").toString(), CsDataSyncCollectBlock.class);
            if (csDataSyncCollectBlocks != null && !csDataSyncCollectBlocks.isEmpty()) {
                csDataSyncCollectBlocks.forEach(csDataSyncCollectBlock -> {
                    csDataSyncCollectBlockMapper.delete(
                            Condition.create().where("table_id = {0}", csDataSyncCollect.getId()).and("block_url = {0}", csDataSyncCollectBlock.getBlockUrl()));
                    csDataSyncCollectBlockMapper.insertCsDataSyncCollectBlock(csDataSyncCollectBlock);
                });
            }

        } else if ("mapping".equals(type)) {
            //映射数据
            CsDataSyncMapping csDataSyncMapping = JSON.parseObject(jsonObject.toString(), CsDataSyncMapping.class);
            CsDataSyncMapping dbCsDataSyncMapping = csDataSyncMappingMapper.selectCsDataSyncMappingById(csDataSyncMapping.getId());
            if (dbCsDataSyncMapping != null) {
                csDataSyncMappingMapper.updateCsDataSyncMappingById(csDataSyncMapping);
            } else {
                csDataSyncMappingMapper.insertCsDataSyncMapping(csDataSyncMapping);
            }

            List<CsDataSyncMappingProperty> csDataSyncMappingPropertys = JSON.parseArray(jsonObject.get("websitePropertyList").toString(), CsDataSyncMappingProperty.class);
            csDataSyncMappingPropertyMapper.delete(
                    Condition.create().where("conf_id = {0}", csDataSyncMapping.getId()));
            csDataSyncMappingPropertys.forEach(csDataSyncMappingProperty ->
                    csDataSyncMappingPropertyMapper.insertCsDataSyncMappingProperty(csDataSyncMappingProperty)
            );

        }


    }
}
