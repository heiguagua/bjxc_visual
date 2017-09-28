package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceRelation;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSourceRelationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源来源关系表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetSourceRelationMapper extends BaseMapper<DirDatasetSourceRelation> {

    List<DirDatasetSourceRelationVo> selectVoPage(Page<DirDatasetSourceRelationVo> page, Map<String, Object> paramMap);

    DirDatasetSourceRelationVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetSourceRelation entity);

    int baseUpdate(DirDatasetSourceRelation entity);

    int deleteByParams(Map<String, Object> paramMap);

    int insertDatasetListRelation(@Param("list") List<DirDatasetSourceRelation> list);

    List<DirDatasetSourceRelation> selectRelationsByDatasetId(@Param("dataset_id")String dataset_id);
}