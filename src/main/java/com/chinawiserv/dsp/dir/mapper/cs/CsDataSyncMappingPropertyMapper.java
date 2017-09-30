package com.chinawiserv.dsp.dir.mapper.cs;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.cs.CsDataSyncMappingProperty;

import java.util.List;

public interface CsDataSyncMappingPropertyMapper extends BaseMapper<CsDataSyncMappingProperty> {
    /**
     * 获得一个CsDataSyncMappingProperty对象,以参数CsDataSyncMappingProperty对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    CsDataSyncMappingProperty selectCsDataSyncMappingPropertyByObj(CsDataSyncMappingProperty obj);

    /**
     * 通过CsDataSyncMappingProperty的id获得CsDataSyncMappingProperty对象
     *
     * @param id
     * @return
     */
    CsDataSyncMappingProperty selectCsDataSyncMappingPropertyById(String id);

    /**
     * 插入CsDataSyncMappingProperty到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertCsDataSyncMappingProperty(CsDataSyncMappingProperty value);

    /**
     * 插入CsDataSyncMappingProperty中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyCsDataSyncMappingProperty(CsDataSyncMappingProperty value);


    /**
     * 通过CsDataSyncMappingProperty的id更新CsDataSyncMappingProperty中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateCsDataSyncMappingPropertyById(CsDataSyncMappingProperty enti);

    /**
     * 通过CsDataSyncMappingProperty的id更新CsDataSyncMappingProperty中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyCsDataSyncMappingPropertyById(CsDataSyncMappingProperty enti);
}