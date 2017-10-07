package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetSystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetSystemMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源关联信息系统 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDatasetSystemMapMapper extends BaseMapper<DrapDatasetSystemMap> {

    List<DrapDatasetSystemMapVo> selectVoPage(Page<DrapDatasetSystemMapVo> page, Map<String, Object> paramMap);

    DrapDatasetSystemMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetSystemMap entity);

    int baseUpdate(DrapDatasetSystemMap entity);

    int baseDelete(String id);

    void batchInsert(List<DrapDatasetSystemMap> drapDatasetSystemMapList);
}