package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataset;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源（数据集） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDatasetMapper extends BaseMapper<DrapDataset> {

    List<DrapDatasetVo> selectVoPage(Page<DrapDatasetVo> page, Map<String, Object> paramMap);

    DrapDatasetVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDataset entity);

    int baseUpdate(DrapDataset entity);

    int baseDelete(String id);

    void batchInsert(List<DrapDataset> drapDatasetList);
}