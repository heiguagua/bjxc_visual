package com.chinawiserv.dsp.dir.mapper.cs;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncCollect;

import java.util.List;

public interface CsDataSyncCollectMapper extends BaseMapper<CsDataSyncCollect> {

    /**
     * 获得一个CsDataSyncCollect对象,以参数CsDataSyncCollect对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncCollect selectCsDataSyncCollectByObj(CsDataSyncCollect obj);

    /**
     * 通过CsDataSyncCollect的id获得CsDataSyncCollect对象
     *
     * @param id
     * @return
     */
    CsDataSyncCollect selectCsDataSyncCollectById(String id);

    /**
     * 插入CsDataSyncCollect到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncCollect(CsDataSyncCollect value);

    /**
     * 插入CsDataSyncCollect中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncCollect(CsDataSyncCollect value);

    /**
     * 通过CsDataSyncCollect的id更新CsDataSyncCollect中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncCollectById(CsDataSyncCollect enti);

    /**
     * 通过CsDataSyncCollect的id更新CsDataSyncCollect中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncCollectById(CsDataSyncCollect enti);
}