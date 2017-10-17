package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtServiceTarget;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetExtServiceTargetVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【川】服务对象） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDatasetExtServiceTargetMapper extends BaseMapper<DirDatasetExtServiceTarget> {

    List<DirDatasetExtServiceTargetVo> selectVoPage(Page<DirDatasetExtServiceTargetVo> page, Map<String, Object> paramMap);

    DirDatasetExtServiceTargetVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtServiceTarget entity);

    int baseUpdate(DirDatasetExtServiceTarget entity);

    int baseDelete(String id);
}