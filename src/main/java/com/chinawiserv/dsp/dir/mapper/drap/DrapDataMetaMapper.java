package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataMeta;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDataMetaVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据元表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDataMetaMapper extends BaseMapper<DrapDataMeta> {

    List<DrapDataMetaVo> selectVoPage(Page<DrapDataMetaVo> page, Map<String, Object> paramMap);

    DrapDataMetaVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDataMeta entity);

    int baseUpdate(DrapDataMeta entity);

    int baseDelete(String id);
}