package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集目录类别关系表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetClassifyMapMapper extends BaseMapper<DirDatasetClassifyMap> {

    List<DirDatasetClassifyMapVo> selectVoPage(Page<DirDatasetClassifyMapVo> page, Map<String, Object> paramMap);

    DirDatasetClassifyMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetClassifyMap entity);

    int baseUpdate(DirDatasetClassifyMap entity);

    int baseDelete(String id);
}