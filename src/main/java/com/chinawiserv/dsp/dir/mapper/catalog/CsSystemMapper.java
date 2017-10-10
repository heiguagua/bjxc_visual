package com.chinawiserv.dsp.dir.mapper.catalog;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lianrongfa on 2017/10/3.
 */
public interface CsSystemMapper {
    List<String> selectProjectList();

    List<String> selectSourceByProName(@Param("project_name")String project_name);

    List<Map<String,Object>> selectTablesBySourceName(@Param("source_name")String source_name);

    List<Map<String,Object>> selectColumnsByTableId(@Param("table_id")String table_id);
}
