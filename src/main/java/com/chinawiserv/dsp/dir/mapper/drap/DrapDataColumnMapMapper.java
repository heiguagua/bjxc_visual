package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataColumnMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDataColumnMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据项与表字段关系梳理表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDataColumnMapMapper extends BaseMapper<DrapDataColumnMap> {

    List<DrapDataColumnMapVo> selectVoPage(Page<DrapDataColumnMapVo> page, Map<String, Object> paramMap);

    DrapDataColumnMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDataColumnMap entity);

    int baseUpdate(DrapDataColumnMap entity);

    int baseDelete(String id);
}