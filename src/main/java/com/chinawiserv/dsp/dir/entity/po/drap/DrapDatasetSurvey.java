package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 梳理信息资源大普查信息表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-07
 */
@TableName("drap_dataset_survey")
public class DrapDatasetSurvey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 数据集ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 数据存储总量
     */
	@TableField("total_storage")
	private Integer totalStorage;
    /**
     * 结构化信息记录总数
     */
	@TableField("structure_count")
	private Integer structureCount;
    /**
     * 已共享的数据存储量
     */
	@TableField("shared_storage")
	private Integer sharedStorage;
    /**
     * 已共享的结构化记录数
     */
	@TableField("shared_structure_count")
	private Integer sharedStructureCount;
    /**
     * 已开放的数据存储量
     */
	@TableField("opened_storage")
	private Integer openedStorage;
    /**
     * 已开放的结构化记录数
     */
	@TableField("opened_structure_count")
	private Integer openedStructureCount;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public Integer getTotalStorage() {
		return totalStorage;
	}

	public void setTotalStorage(Integer totalStorage) {
		this.totalStorage = totalStorage;
	}

	public Integer getStructureCount() {
		return structureCount;
	}

	public void setStructureCount(Integer structureCount) {
		this.structureCount = structureCount;
	}

	public Integer getSharedStorage() {
		return sharedStorage;
	}

	public void setSharedStorage(Integer sharedStorage) {
		this.sharedStorage = sharedStorage;
	}

	public Integer getSharedStructureCount() {
		return sharedStructureCount;
	}

	public void setSharedStructureCount(Integer sharedStructureCount) {
		this.sharedStructureCount = sharedStructureCount;
	}

	public Integer getOpenedStorage() {
		return openedStorage;
	}

	public void setOpenedStorage(Integer openedStorage) {
		this.openedStorage = openedStorage;
	}

	public Integer getOpenedStructureCount() {
		return openedStructureCount;
	}

	public void setOpenedStructureCount(Integer openedStructureCount) {
		this.openedStructureCount = openedStructureCount;
	}

}
