package com.chinawiserv.dsp.dir.mapper.cs;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncCollectDb;

import java.util.List;

public interface CsDataSyncCollectDbMapper extends BaseMapper<CsDataSyncCollectDb> {


    /**
     * 获得一个CsDataSyncCollectDb对象,以参数CsDataSyncCollectDb对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncCollectDb selectCsDataSyncCollectDbByObj(CsDataSyncCollectDb obj);

    /**
     * 通过CsDataSyncCollectDb的id获得CsDataSyncCollectDb对象
     *
     * @param id
     * @return
     */
    CsDataSyncCollectDb selectCsDataSyncCollectDbById(String id);

    /**
     * 插入CsDataSyncCollectDb到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncCollectDb(CsDataSyncCollectDb value);

    /**
     * 插入CsDataSyncCollectDb中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncCollectDb(CsDataSyncCollectDb value);


    /**
     * 通过CsDataSyncCollectDb的id更新CsDataSyncCollectDb中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncCollectDbById(CsDataSyncCollectDb enti);

    /**
     * 通过CsDataSyncCollectDb的id更新CsDataSyncCollectDb中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncCollectDbById(CsDataSyncCollectDb enti);
}