package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetItemVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务数据项【国】 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDatasetItemMapper extends BaseMapper<DrapDatasetItem> {

    List<DrapDatasetItemVo> selectVoPage(Page<DrapDatasetItemVo> page, Map<String, Object> paramMap);

    DrapDatasetItemVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetItem entity);

    int baseUpdate(DrapDatasetItem entity);

    int baseDelete(String id);
}