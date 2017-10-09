package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetItemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetItemMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集数据项关联表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDatasetItemMapMapper extends BaseMapper<DrapDatasetItemMap> {

    List<DrapDatasetItemMapVo> selectVoPage(Page<DrapDatasetItemMapVo> page, Map<String, Object> paramMap);

    DrapDatasetItemMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetItemMap entity);

    int baseUpdate(DrapDatasetItemMap entity);

    int baseDelete(String id);

    void batchInsert(List<DrapDatasetItemMap> drapDatasetItemMapList);
}