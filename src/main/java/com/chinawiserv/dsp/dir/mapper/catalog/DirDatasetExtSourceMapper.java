package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtSource;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetExtSourceVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【川】主要来源） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDatasetExtSourceMapper extends BaseMapper<DirDatasetExtSource> {

    List<DirDatasetExtSourceVo> selectVoPage(Page<DirDatasetExtSourceVo> page, Map<String, Object> paramMap);

    DirDatasetExtSourceVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtSource entity);

    int baseUpdate(DirDatasetExtSource entity);

    int baseDelete(String id);
}