package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementDatasetMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapRequirementResources;

/**
 * <p>
 * 需求资源信息表 Vo对象
 * </p>
 *
 * @author Marke
 * @since 2017-09-20
 */
public class DrapRequirementResourcesVo extends DrapRequirementResources {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4208799474817031614L;
	private String datasetIdString;
	
	private List<Map<String, String>> requireDatasetLst;
	
	private Map<String, String> businessActivityMap;
	
	private Map<String, String> isGetMap;
	
	private Map<String, String> requireTypeMap;
	
	private Map<String, String> expectGetTypeMap;
	
	private Map<String, String> expectUpdateFrequenceMap;
	
	private List<DrapRequirementDatasetMap> requirementDatasetMapLst;
	public String getDatasetIdString() {
		return datasetIdString;
	}
	
	public void setDatasetIdString(String datasetIdString) {
		this.datasetIdString = datasetIdString;
	}
	
	public List<Map<String, String>> getRequireDatasetLst() {
		return requireDatasetLst;
	}
	
	public void setRequireDatasetLst(List<Map<String, String>> requireDatasetLst) {
		this.requireDatasetLst = requireDatasetLst;
	}
	
	public Map<String, String> getBusinessActivityMap() {
		return businessActivityMap;
	}
	
	public void setBusinessActivityMap(Map<String, String> businessActivityMap) {
		this.businessActivityMap = businessActivityMap;
	}
	
	public Map<String, String> getIsGetMap() {
		return isGetMap;
	}
	
	public void setIsGetMap(Map<String, String> isGetMap) {
		this.isGetMap = isGetMap;
	}
	
	public Map<String, String> getRequireTypeMap() {
		return requireTypeMap;
	}
	
	public void setRequireTypeMap(Map<String, String> requireTypeMap) {
		this.requireTypeMap = requireTypeMap;
	}
	
	public Map<String, String> getExpectGetTypeMap() {
		return expectGetTypeMap;
	}
	
	public void setExpectGetTypeMap(Map<String, String> expectGetTypeMap) {
		this.expectGetTypeMap = expectGetTypeMap;
	}
	
	public Map<String, String> getExpectUpdateFrequenceMap() {
		return expectUpdateFrequenceMap;
	}
	
	public void setExpectUpdateFrequenceMap(
			Map<String, String> expectUpdateFrequenceMap) {
		this.expectUpdateFrequenceMap = expectUpdateFrequenceMap;
	}

	public List<DrapRequirementDatasetMap> getRequirementDatasetMapLst() {
		return requirementDatasetMapLst;
	}

	public void setRequirementDatasetMapLst(
			List<DrapRequirementDatasetMap> requirementDatasetMapLst) {
		this.requirementDatasetMapLst = requirementDatasetMapLst;
	}


	
}
