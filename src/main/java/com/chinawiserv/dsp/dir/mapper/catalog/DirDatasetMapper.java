package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集（信息资源） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetMapper extends BaseMapper<DirDataset> {

    List<DirDatasetVo> selectVoPage(Page<DirDatasetVo> page, Map<String, Object> paramMap);

    List<DirDatasetVo> selectInfoPage(Page<DirDatasetVo> page, Map<String, Object> paramMap);

    DirDatasetVo selectVoById(String id);

    DirDatasetVo selectDatasetInfoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataset entity);

    int baseUpdate(DirDataset entity);

    int baseDelete(Map<String,Object> param);

    int flagDelete(Map<String,Object> param);

    int extInsert(DirDatasetExtFormat entity);

    int extUpdate(DirDatasetExtFormat format);

    //用户梳理系统的查询
    List<Map<String,Object>> selectActivityByDeptId(@Param("dept_id")String dept_id);
    //用户梳理系统的查询
    List<Map<String,Object>> selectDatasetByActivityId(@Param("activity_id")String activity_id);
    //用户梳理系统的查询
    List<DrapDatasetItem> selectDatasetItemByDatasetId(@Param("dataset_id")String dataset_id);
    //用户梳理系统的查询
    List<DrapDatasetItem> selectDatasetItemByIds(@Param("list")List<String> list);
    //用户梳理系统的查询
    DrapDataset getDrapDatasetDetail(@Param("id") String id);

    List<ExportDatasetExcel> selectExportLists(@Param("tree_codes")String [] tree_codes, @Param("dataset_name")String dataset_name,@Param("region_code")String region_code);
}
