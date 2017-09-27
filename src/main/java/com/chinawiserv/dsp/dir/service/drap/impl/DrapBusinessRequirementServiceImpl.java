package com.chinawiserv.dsp.dir.service.drap.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.Helper;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessRequirement;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementDatasetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessRequirementVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementResourcesVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapBusinessRequirementMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapBusinessRequirementService;

/**
 * <p>
 * 业务资源需求表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapBusinessRequirementServiceImpl extends CommonServiceImpl<DrapBusinessRequirementMapper, DrapBusinessRequirement , DrapBusinessRequirementVo> implements IDrapBusinessRequirementService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DrapBusinessRequirementMapper mapper;


    @Override
    public boolean insertVO(DrapBusinessRequirementVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapBusinessRequirementVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapBusinessRequirementVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapBusinessRequirementVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
    @Override
    public HandleResult insertBusinessRequirement(
    		List<DrapBusinessRequirementVo> voLst) {

		
		List<DrapRequirementResourcesVo> resourceVoLst = null;
		List<DrapRequirementDatasetMap> datasetMapLst = null;
		HandleResult result = new HandleResult();

		try {
			for (DrapBusinessRequirementVo vo:voLst)
			{
				if (vo == null)
				{
					logger.warn("BusinessRequirementVo对象为空，跳过当前循环。");
					continue;
				}
				resourceVoLst = vo.getRequireSourceVoLst();
				if (resourceVoLst == null || resourceVoLst.isEmpty())
				{
					logger.warn("RequireSourceVo集合对象为空，跳过当前循环。");
					continue;
				}

				for (DrapRequirementResourcesVo resourceVo : resourceVoLst)
				{
					if (resourceVo == null || !Helper.checkParam(resourceVo.getRequireId()))
					{
						logger.warn("RequireSourceVo对象为空，跳过当前循环。");
						continue;
					}
					datasetMapLst = resourceVo.getRequirementDatasetMapLst();
					if (datasetMapLst == null || datasetMapLst.isEmpty())
					{
						logger.warn("datasetMapLst对象为空，跳过当前循环。");
						continue;
					}else{
						mapper.addBusinessRequirementDataset(datasetMapLst);
					}
				}
				mapper.addRequirementResource(resourceVoLst);
				mapper.addBusinessRequirement(vo);
				
			}
			result.success("同步需求成功。");
		} catch (Exception e) {
			logger.error("同步需求失败。",e.toString());
			result.error("同步需求失败。错误原因："+e.getCause());
		}
		return result;
	
    }
}
