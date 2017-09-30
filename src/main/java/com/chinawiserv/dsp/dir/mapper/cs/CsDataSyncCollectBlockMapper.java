package com.chinawiserv.dsp.dir.mapper.cs;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncCollectBlock;

public interface CsDataSyncCollectBlockMapper extends BaseMapper<CsDataSyncCollectBlock> {


    /**
     * 获得一个CsDataSyncCollectBlock对象,以参数CsDataSyncCollectBlock对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncCollectBlock selectCsDataSyncCollectBlockByObj(CsDataSyncCollectBlock obj);

    /**
     * 通过CsDataSyncCollectBlock的id获得CsDataSyncCollectBlock对象
     *
     * @param id
     * @return
     */
    CsDataSyncCollectBlock selectCsDataSyncCollectBlockById(String id);

    /**
     * 插入CsDataSyncCollectBlock到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncCollectBlock(CsDataSyncCollectBlock value);

    /**
     * 插入CsDataSyncCollectBlock中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncCollectBlock(CsDataSyncCollectBlock value);


    /**
     * 通过CsDataSyncCollectBlock的id更新CsDataSyncCollectBlock中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncCollectBlockById(CsDataSyncCollectBlock enti);

    /**
     * 通过CsDataSyncCollectBlock的id更新CsDataSyncCollectBlock中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncCollectBlockById(CsDataSyncCollectBlock enti);
}