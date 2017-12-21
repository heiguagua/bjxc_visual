package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataColumnMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetTableRelation;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetTableRelationVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源梳理表关系记录表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDatasetTableRelationMapper extends BaseMapper<DrapDatasetTableRelation> {

    List<DrapDatasetTableRelationVo> selectVoPage(Page<DrapDatasetTableRelationVo> page, Map<String, Object> paramMap);

    DrapDatasetTableRelationVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDatasetTableRelation entity);

    int baseUpdate(DrapDatasetTableRelation entity);

    int baseDelete(String id);
    
	/**
	 * 新增数据项字段
	 * @param dataLst
	 */
	void addItemRelation(List<DrapDataColumnMap> dataLst);
	
	
	/**
	 * 新增表关系
	 * @param tableRelation
	 */
	void addTableFieldRelation(List<DrapDatasetTableRelation> tableRelation);
	
	/**
	 * 删除表关系根据数据集
	 * @param paramMap
	 */
	void deleteTableRelation(Map<String, Object> paramMap);
	
	
	/**
	 * 删除数据项关联字段根据数据集ID
	 * @param paramMap
	 */
	void deleteDataColumnMapByDatasetId(Map<String, Object> paramMap);

	void deleteTableRelationBySetIds(List<String> datasetIds);
}