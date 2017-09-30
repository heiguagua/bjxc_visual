package com.chinawiserv.dsp.dir.mapper.cs;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncCollectColumn;

import java.util.List;

public interface CsDataSyncCollectColumnMapper extends BaseMapper<CsDataSyncCollectColumn> {


    /**
     * 获得一个CsDataSyncCollectColumn对象,以参数CsDataSyncCollectColumn对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncCollectColumn selectCsDataSyncCollectColumnByObj(CsDataSyncCollectColumn obj);

    /**
     * 通过CsDataSyncCollectColumn的id获得CsDataSyncCollectColumn对象
     *
     * @param id
     * @return
     */
    CsDataSyncCollectColumn selectCsDataSyncCollectColumnById(String id);

    /**
     * 插入CsDataSyncCollectColumn到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncCollectColumn(CsDataSyncCollectColumn value);

    /**
     * 插入CsDataSyncCollectColumn中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncCollectColumn(CsDataSyncCollectColumn value);

    /**
     * 通过CsDataSyncCollectColumn的id更新CsDataSyncCollectColumn中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncCollectColumnById(CsDataSyncCollectColumn enti);

    /**
     * 通过CsDataSyncCollectColumn的id更新CsDataSyncCollectColumn中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncCollectColumnById(CsDataSyncCollectColumn enti);
}