package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataColumnMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetTableRelation;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetTableRelationVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDatasetTableRelationMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDatasetTableRelationService;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息资源梳理表关系记录表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDatasetTableRelationServiceImpl extends CommonServiceImpl<DrapDatasetTableRelationMapper, DrapDatasetTableRelation , DrapDatasetTableRelationVo> implements IDrapDatasetTableRelationService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DrapDatasetTableRelationMapper mapper;


    @Override
    public boolean insertVO(DrapDatasetTableRelationVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapDatasetTableRelationVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapDatasetTableRelationVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapDatasetTableRelationVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
	@Override
    public HandleResult insertTableRelation(
    		List<Map<String, Object>> datasetRelationLst) {
    	HandleResult result = new HandleResult();
    	if (datasetRelationLst == null || datasetRelationLst.isEmpty())
    	{
    		result.error("同步关系失败。参数为空");
    		return result;
    	}
    	
    	try {
    		List<DrapDataColumnMap> dataColumnMapLst = null;
    		List<DrapDatasetTableRelation> datasetTableRelationMapLst = null;
    		Object obj = null;
			for (Map<String,Object> map : datasetRelationLst)
			{
				if (!map.containsKey("dataColumnMap"))
				{
					logger.warn("dataColumnMap属性不存在。");
					continue;
				}
				obj = map.get("dataColumnMap");
				if (obj instanceof List)
				{
					dataColumnMapLst = (List<DrapDataColumnMap>)obj;
					mapper.addItemRelation(dataColumnMapLst);
				}
				if (map.containsKey("datasetTableRelationMap"))
				{
					obj = map.get("datasetTableRelationMap");
					if (obj instanceof List)
					{
						datasetTableRelationMapLst = (List<DrapDatasetTableRelation>)obj;
					    mapper.addTableFieldRelation(datasetTableRelationMapLst);
					}
				}
			}
			result.success("同步关系成功。");
		} catch (Exception e) {
			logger.error("同步关系失败，原因："+e.getCause(),e);
			result.error("同步关系失败，原因："+e.getCause());
		}
    	return result;
    }
}
