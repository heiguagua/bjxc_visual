package com.chinawiserv.dsp.dir.mapper.cs;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncMapping;

import java.util.List;

public interface CsDataSyncMappingMapper extends BaseMapper<CsDataSyncMapping> {

    /**
     * 获得一个CsDataSyncMapping对象,以参数CsDataSyncMapping对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncMapping selectCsDataSyncMappingByObj(CsDataSyncMapping obj);

    /**
     * 通过CsDataSyncMapping的id获得CsDataSyncMapping对象
     *
     * @param id
     * @return
     */
    CsDataSyncMapping selectCsDataSyncMappingById(String id);

    /**
     * 插入CsDataSyncMapping到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncMapping(CsDataSyncMapping value);

    /**
     * 插入CsDataSyncMapping中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncMapping(CsDataSyncMapping value);


    /**
     * 通过CsDataSyncMapping的id更新CsDataSyncMapping中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncMappingById(CsDataSyncMapping enti);

    /**
     * 通过CsDataSyncMapping的id更新CsDataSyncMapping中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncMappingById(CsDataSyncMapping enti);
}