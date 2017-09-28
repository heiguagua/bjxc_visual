package com.chinawiserv.dsp.dir.mapper.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDbTableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lianrongfa on 2017/9/27.
 */
public interface DrapDbMapper {
    List<Map<String,Object>>selectDbByDeptId(@Param("dept_id")String dept_id);
    List<Map<String,Object>>selectTableByDbId(@Param("db_id")String db_id);
    List<Map<String,Object>>selectFieldByTableId(@Param("table_id")String table_id);

    List<DrapDbTableColumn> selectFieldByIds(@Param("list") String [] list );
}
