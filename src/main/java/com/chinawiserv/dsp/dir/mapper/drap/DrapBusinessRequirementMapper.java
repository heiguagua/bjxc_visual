package com.chinawiserv.dsp.dir.mapper.drap;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementDatasetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementResourcesVo;


/**
 * <p>
  * 业务资源需求表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapBusinessRequirementMapper extends BaseMapper<DrapBusinessRequirement> {

    List<DrapBusinessRequirementVo> selectVoPage(Page<DrapBusinessRequirementVo> page, Map<String, Object> paramMap);

    DrapBusinessRequirementVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapBusinessRequirement entity);

    int baseUpdate(DrapBusinessRequirement entity);

    int baseDelete(String id);
    /**
	 * 物理删除数据集关联中间表
	 * 
	 * @param paramMap
	 */
	void deleteBusinessRequireDataset(Map<String, String> paramMap);
	
	/**
	 * 物理删除需求子表数据
	 * 
	 * @param paramMap
	 */
	void deleteRequirementResource(Map<String, String> paramMap);
	
	
	/**
	 * 新增需求子表数据
	 * 
	 * @param resourceLst
	 */
	void addRequirementResource(List<DrapRequirementResourcesVo> resourceLst);
	
	/**
	 * 需求主表数据新增
	 * 
	 * @param businessRequirement
	 */
	void addBusinessRequirement(DrapBusinessRequirement businessRequirement);
	
	
	
	/**
	 * 新增需求 新增资源 中间表
	 * 
	 * @param datasetMap
	 */
	void addBusinessRequirementDataset(List<DrapRequirementDatasetMap> datasetMap);
    
}