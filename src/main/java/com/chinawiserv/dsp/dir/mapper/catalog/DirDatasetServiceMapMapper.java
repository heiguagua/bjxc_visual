package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetServiceMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetServiceMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集对应接口服务表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetServiceMapMapper extends BaseMapper<DirDatasetServiceMap> {

    List<DirDatasetServiceMapVo> selectVoPage(Page<DirDatasetServiceMapVo> page, Map<String, Object> paramMap);

    DirDatasetServiceMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetServiceMap entity);

    int baseUpdate(DirDatasetServiceMap entity);

    int baseDelete(String id);
}