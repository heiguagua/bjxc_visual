package com.chinawiserv.dsp.dir.mapper.catalog;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtFormat;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【国】资源格式） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-13
 */
public interface DirDatasetExtFormatMapper extends BaseMapper<DirDatasetExtFormat> {

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtFormat entity);

    int baseUpdate(DirDatasetExtFormat entity);

    int baseDelete(String id);

    void batchInsert(List<DirDatasetExtFormat> dirDatasetExtFormatList);
}