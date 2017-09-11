package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 目录分类表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirClassifyMapper extends BaseMapper<DirClassify> {

    List<DirClassifyVo> selectVoPage(Page<DirClassifyVo> page, Map<String, Object> paramMap);

    DirClassifyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirClassify entity);

    int baseUpdate(DirClassify entity);

    int baseDelete(String id);
}