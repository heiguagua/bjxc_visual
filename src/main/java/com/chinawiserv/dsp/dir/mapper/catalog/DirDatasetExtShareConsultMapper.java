package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtShareConsult;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetExtShareConsultVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【川】共享咨询） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDatasetExtShareConsultMapper extends BaseMapper<DirDatasetExtShareConsult> {

    List<DirDatasetExtShareConsultVo> selectVoPage(Page<DirDatasetExtShareConsultVo> page, Map<String, Object> paramMap);

    DirDatasetExtShareConsultVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtShareConsult entity);

    int baseUpdate(DirDatasetExtShareConsult entity);

    int baseDelete(String id);
}