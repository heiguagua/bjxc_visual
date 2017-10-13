package com.chinawiserv.dsp.dir.service.cs.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.cs.*;
import com.chinawiserv.dsp.dir.mapper.cs.*;
import com.chinawiserv.dsp.dir.service.cs.ICsDataSyncService;
import org.apache.commons.lang3.StringUtils;
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
    public int syncData(String type, String jsonObj) throws Exception {
        JSONObject jsonObject = (JSONObject) JSON.parse(jsonObj);
        if ("collect".equals(type)) {
            //抓取数据
            CsDataSyncCollect csDataSyncCollect = JSON.parseObject(jsonObj, CsDataSyncCollect.class);
            if (csDataSyncCollect == null) {
                return 0;
                // throw new Exception("抓取数据序列化出错!");
            }
            CsDataSyncCollectDb csDataSyncCollectDb = JSON.parseObject(jsonObject.get("dbConf").toString(), CsDataSyncCollectDb.class);
            if (csDataSyncCollectDb == null) {
                return 0;
                // throw new Exception("抓取数据序列化出错!");
            }
            csDataSyncCollectDb.setDbType(csDataSyncCollect.getDbType());
            csDataSyncCollectDb.setId(csDataSyncCollect.getDbId());
            csDataSyncCollectDb.setDbDesc(csDataSyncCollect.getDbDesc());
            CsDataSyncCollectDb db = csDataSyncCollectDbMapper.selectById(csDataSyncCollect.getDbId());

            if (db != null) {
                csDataSyncCollectDbMapper.updateById(csDataSyncCollectDb);
            } else {
                csDataSyncCollectDbMapper.insert(csDataSyncCollectDb);
            }
            CsDataSyncCollect table = csDataSyncCollectMapper.selectById(csDataSyncCollect.getId());
            if (table != null) {
                csDataSyncCollectMapper.updateById(csDataSyncCollect);
            } else {
                csDataSyncCollectMapper.insert(csDataSyncCollect);
            }

            List<CsDataSyncCollectColumn> csDataSyncCollectBlockColumns = JSON.parseArray(jsonObject.get("columnDesc").toString(), CsDataSyncCollectColumn.class);
            if (csDataSyncCollectBlockColumns != null && !csDataSyncCollectBlockColumns.isEmpty()) {
                csDataSyncCollectBlockColumns.forEach(csDataSyncCollectBlockColumn -> {
                            csDataSyncCollectBlockColumn.setTableId(csDataSyncCollect.getId());
                            csDataSyncCollectColumnMapper.delete(
                                    Condition.create().where("table_id = {0}", csDataSyncCollect.getId()).and("cloumn_name = {0}", csDataSyncCollectBlockColumn.getCloumnName()));
                            csDataSyncCollectColumnMapper.insert(csDataSyncCollectBlockColumn);
                        }
                );
            }

            List<CsDataSyncCollectBlock> csDataSyncCollectBlocks = JSON.parseArray(jsonObject.get("tableWebsitBlockList").toString(), CsDataSyncCollectBlock.class);
            if (csDataSyncCollectBlocks != null && !csDataSyncCollectBlocks.isEmpty()) {
                csDataSyncCollectBlocks.forEach(csDataSyncCollectBlock -> {
                    csDataSyncCollectBlockMapper.delete(
                            Condition.create().where("table_id = {0}", csDataSyncCollect.getId()).and("block_url = {0}", csDataSyncCollectBlock.getBlockUrl()));
                    csDataSyncCollectBlockMapper.insert(csDataSyncCollectBlock);
                });
            }

        } else if ("mapping".equals(type)) {
            //映射数据
            CsDataSyncMapping csDataSyncMapping = JSON.parseObject(jsonObject.toString(), CsDataSyncMapping.class);
            if (csDataSyncMapping != null && StringUtils.isNotEmpty(csDataSyncMapping.getDeleteId())) {
                //处理映射数据删除
                CsDataSyncMapping dbCsDataSyncMapping = csDataSyncMappingMapper.selectById(csDataSyncMapping.getDeleteId());
                if (dbCsDataSyncMapping != null) {
                    dbCsDataSyncMapping.setDeleted(1);
                    csDataSyncMappingMapper.updateById(dbCsDataSyncMapping);
                } else {
                    return -1;
                    //throw new Exception("数据不存在!");
                }
            } else {
                //处理映射数据新增或修改
                CsDataSyncMapping dbCsDataSyncMapping = csDataSyncMappingMapper.selectById(csDataSyncMapping.getId());
                if (dbCsDataSyncMapping != null) {
                    csDataSyncMappingMapper.updateById(csDataSyncMapping);
                } else {
                    csDataSyncMappingMapper.insert(csDataSyncMapping);
                }
            }

            List<CsDataSyncMappingProperty> csDataSyncMappingPropertys = JSON.parseArray(jsonObject.get("websitePropertyList").toString(), CsDataSyncMappingProperty.class);
            csDataSyncMappingPropertyMapper.delete(
                    Condition.create().where("conf_id = {0}", csDataSyncMapping.getId()));
            csDataSyncMappingPropertys.forEach(csDataSyncMappingProperty ->
                    csDataSyncMappingPropertyMapper.insert(csDataSyncMappingProperty)
            );

        }
        return 1;
    }
}
