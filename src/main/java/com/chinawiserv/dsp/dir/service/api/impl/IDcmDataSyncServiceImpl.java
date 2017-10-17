package com.chinawiserv.dsp.dir.service.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.dir.mapper.dcm_sync.DcmPoolNosqlMapper;
import com.chinawiserv.dsp.dir.mapper.dcm_sync.DcmPoolRmdbMapper;
import com.chinawiserv.dsp.dir.mapper.dcm_sync.DcmTableColumnMapper;
import com.chinawiserv.dsp.dir.mapper.dcm_sync.DcmTableInfoMapper;
import com.chinawiserv.dsp.dir.service.api.IDcmDataSyncService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Created by tk on 2017/10/13.
 */
@Service
public class IDcmDataSyncServiceImpl implements IDcmDataSyncService {

    @Autowired
    DcmPoolNosqlMapper dcmPoolNosqlMapper;
    @Autowired
    DcmPoolRmdbMapper dcmPoolRmdbMapper;
    @Autowired
    DcmTableInfoMapper dcmTableInfoMapper;
    @Autowired
    DcmTableColumnMapper dcmTableColumnMapper;

    @Override
    public void synDcmDate(Map<String, Object> param) {
        Set<String> keys = param.keySet();
        for(String key :keys){
            JSONObject syncDate = null;
            JSONArray insertArray = null;
            JSONArray updateArray = null;
            if(StringUtils.equals(key,"tableInfo")){
                syncDate = JSON.parseObject(MapUtils.getString(param , "tableInfo" , ""));
                if (syncDate.containsKey("insert")){
                    insertArray = syncDate.getJSONArray("insert");
                    dcmTableInfoMapper.insertBatch(insertArray);
                }
                if (syncDate.containsKey("update")){
                    updateArray = syncDate.getJSONArray("update");
                    dcmTableInfoMapper.updateBatch(updateArray);
                }

            }if(StringUtils.equals(key,"poolRmdb")){
                syncDate = JSON.parseObject(MapUtils.getString(param , "poolRmdb" , ""));
                if (syncDate.containsKey("insert")){
                    insertArray = syncDate.getJSONArray("insert");
                    dcmPoolRmdbMapper.insertBatch(insertArray);
                }
                if (syncDate.containsKey("update")){
                    updateArray = syncDate.getJSONArray("update");
                    dcmPoolRmdbMapper.updateBatch(updateArray);
                }

            }if(StringUtils.equals(key,"poolNosql")){
                syncDate = JSON.parseObject(MapUtils.getString(param , "poolNosql" , ""));
                if (syncDate.containsKey("insert")){
                    insertArray = syncDate.getJSONArray("insert");
                    dcmPoolNosqlMapper.insertBatch(insertArray);
                }
                if (syncDate.containsKey("update")){
                    updateArray = syncDate.getJSONArray("update");
                    dcmPoolNosqlMapper.updateBatch(updateArray);
                }
            }if(StringUtils.equals(key,"tableColumn")){
                syncDate = JSON.parseObject(MapUtils.getString(param , "tableColumn" , ""));
                if (syncDate.containsKey("insert")){
                    insertArray = syncDate.getJSONArray("insert");
                    dcmTableColumnMapper.insertBatch(insertArray);
                }
                if (syncDate.containsKey("update")){
                    updateArray = syncDate.getJSONArray("update");
                    dcmTableColumnMapper.updateBatch(updateArray);
                }
            }

        }
    }
}
