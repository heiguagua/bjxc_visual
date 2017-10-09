package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetExtFormat;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetExtFormatVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 梳理数据集扩展信息（【国】资源格式） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
public interface DrapDatasetExtFormatMapper extends BaseMapper<DrapDatasetExtFormat> {

    List<DrapDatasetExtFormatVo> selectVoPage(Page<DrapDatasetExtFormatVo> page, Map<String, Object> paramMap);

    DrapDatasetExtFormatVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetExtFormat entity);

    int baseUpdate(DrapDatasetExtFormat entity);

    int baseDelete(String id);

    void batchInsert(List<DrapDatasetExtFormat> drapDatasetExtFormatList);
}