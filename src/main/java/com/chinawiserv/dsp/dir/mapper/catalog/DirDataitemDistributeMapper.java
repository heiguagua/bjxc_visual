package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitemDistribute;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemDistributeVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据项权限分配表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataitemDistributeMapper extends BaseMapper<DirDataitemDistribute> {

    List<DirDataitemDistributeVo> selectVoPage(Page<DirDataitemDistributeVo> page, Map<String, Object> paramMap);

    DirDataitemDistributeVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataitemDistribute entity);

    int baseUpdate(DirDataitemDistribute entity);

    int baseDelete(String id);
}