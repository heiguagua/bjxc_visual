package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataset;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDataset;
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

    DirDatasetVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataset entity);

    int baseUpdate(DirDataset entity);

    int baseDelete(String id);

    List<Map<String,Object>> selectActivityByDeptId(@Param("dept_id")String dept_id);

    List<Map<String,Object>> selectDatasetByActivityId(@Param("activity_id")String activity_id);

    List<DrapDatasetItem> selectDatasetItemByDatasetId(@Param("dataset_id")String dataset_id);

    DrapDataset getDrapDatasetDetail(@Param("id") String id);
}
