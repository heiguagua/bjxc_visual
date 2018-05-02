package com.chinawiserv.dsp.vm.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.vm.entity.po.ClassifyIndictorMap;
import com.chinawiserv.dsp.vm.entity.vo.ClassifyIndictorMapVo;

/**
 * <p>
 * 图表分类与指标关系表 Mapper 接口
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface ClassifyIndictorMapMapper extends BaseMapper<ClassifyIndictorMap> {

	List<ClassifyIndictorMapVo> selectVoPage(Page<ClassifyIndictorMapVo> page, Map<String, Object> paramMap);

	ClassifyIndictorMapVo selectVoById(String id);

	int selectVoCount(Map<String, Object> paramMap);

	int baseInsert(ClassifyIndictorMap entity);

	int baseUpdate(ClassifyIndictorMap entity);

	int baseDelete(String id);

	/**
	 * 根据分类id删除图表分类与指标关系表
	 * 
	 * @param classifyId
	 * @return
	 */
	int deleteByClassifyId(String classifyId);

	/**
	 * 根据分类id查询图表分类与指标关系集
	 * 
	 * @param classifyId
	 * @return
	 */
	ClassifyIndictorMapVo selectByClassifyId(String classifyId);
}
