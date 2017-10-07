package com.chinawiserv.dsp.dir.entity.po.catalog;
public class DirDatasetSurvey {
    private String id;//id
    private String datasetId;//数据集ID
    private Integer totalStorage;//数据存储总量
    private Integer structureCount;//结构化信息记录总数
    private Integer sharedStorage;//已共享的数据存储量
    private Integer sharedStructureCount;//已共享的结构化记录数
    private Integer openedStorage;//已开放的数据存储量
    private Integer openedStructureCount;//已开放的结构化记录数
    public DirDatasetSurvey() {
        super();
    }
    public DirDatasetSurvey(String id,String datasetId,Integer totalStorage,Integer structureCount,Integer sharedStorage,Integer sharedStructureCount,Integer openedStorage,Integer openedStructureCount) {
        super();
        this.id = id;
        this.datasetId = datasetId;
        this.totalStorage = totalStorage;
        this.structureCount = structureCount;
        this.sharedStorage = sharedStorage;
        this.sharedStructureCount = sharedStructureCount;
        this.openedStorage = openedStorage;
        this.openedStructureCount = openedStructureCount;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatasetId() {
        return this.datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public Integer getTotalStorage() {
        return this.totalStorage;
    }

    public void setTotalStorage(Integer totalStorage) {
        this.totalStorage = totalStorage;
    }

    public Integer getStructureCount() {
        return this.structureCount;
    }

    public void setStructureCount(Integer structureCount) {
        this.structureCount = structureCount;
    }

    public Integer getSharedStorage() {
        return this.sharedStorage;
    }

    public void setSharedStorage(Integer sharedStorage) {
        this.sharedStorage = sharedStorage;
    }

    public Integer getSharedStructureCount() {
        return this.sharedStructureCount;
    }

    public void setSharedStructureCount(Integer sharedStructureCount) {
        this.sharedStructureCount = sharedStructureCount;
    }

    public Integer getOpenedStorage() {
        return this.openedStorage;
    }

    public void setOpenedStorage(Integer openedStorage) {
        this.openedStorage = openedStorage;
    }

    public Integer getOpenedStructureCount() {
        return this.openedStructureCount;
    }

    public void setOpenedStructureCount(Integer openedStructureCount) {
        this.openedStructureCount = openedStructureCount;
    }

}
