package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataColumnMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataset;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDatasetTableRelation;

/**
 * <p>
 * 信息资源（数据集） Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapDatasetVo extends DrapDataset{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 关系梳理数据同步 同步字段
     */
    private List<DrapDataColumnMap> dataColumnMap;
    /**
     * 关系梳理数据同步 同步表间关系
     */
    private List<DrapDatasetTableRelation>datasetTableRelationMap;
	public List<DrapDataColumnMap> getDataColumnMap() {
		return dataColumnMap;
	}
	public void setDataColumnMap(List<DrapDataColumnMap> dataColumnMap) {
		this.dataColumnMap = dataColumnMap;
	}
	public List<DrapDatasetTableRelation> getDatasetTableRelationMap() {
		return datasetTableRelationMap;
	}
	public void setDatasetTableRelationMap(
			List<DrapDatasetTableRelation> datasetTableRelationMap) {
		this.datasetTableRelationMap = datasetTableRelationMap;
	}
    
    
    
}
