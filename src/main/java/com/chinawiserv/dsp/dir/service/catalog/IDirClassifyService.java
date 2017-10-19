package com.chinawiserv.dsp.dir.service.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 目录分类表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public interface IDirClassifyService extends ICommonService<DirClassify, DirClassifyVo> {

	
	DirClassifyVo prepareClassifyVo(DirClassifyVo vo);
	
	void insertbatchNational(DirClassifyVo vo);

	List<DirClassifyVo> selectVoList(Map<String,Object> paramMap) throws Exception;

    List<DirClassifyVo> selectSubVoList(Map<String,Object> paramMap) throws Exception;

    String generateDatasetCode(String classifyId);
	void DeleteByFlag(String classifyCode);
}
