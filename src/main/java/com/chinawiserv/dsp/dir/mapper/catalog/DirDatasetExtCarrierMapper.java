package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtCarrier;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetExtCarrierVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【川】基本载体） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDatasetExtCarrierMapper extends BaseMapper<DirDatasetExtCarrier> {

    List<DirDatasetExtCarrierVo> selectVoPage(Page<DirDatasetExtCarrierVo> page, Map<String, Object> paramMap);

    DirDatasetExtCarrierVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtCarrier entity);

    int baseUpdate(DirDatasetExtCarrier entity);

    int baseDelete(String id);
}