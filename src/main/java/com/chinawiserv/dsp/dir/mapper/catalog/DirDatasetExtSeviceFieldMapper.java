package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtSeviceField;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetExtSeviceFieldVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集扩展信息（【川】服务领域） Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDatasetExtSeviceFieldMapper extends BaseMapper<DirDatasetExtSeviceField> {

    List<DirDatasetExtSeviceFieldVo> selectVoPage(Page<DirDatasetExtSeviceFieldVo> page, Map<String, Object> paramMap);

    DirDatasetExtSeviceFieldVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetExtSeviceField entity);

    int baseUpdate(DirDatasetExtSeviceField entity);

    int baseDelete(String id);
}