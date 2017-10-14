package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.*;

import java.util.List;

/**
 * <p>
 * 数据集（信息资源） Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirDatasetVo extends DirDataset{

    private List<DirDataitemVo> items;

    private DirDataTransfer transfer;
    private String classifyIds;

    private String classifyName;

    private String relClassifyName;

    private String classifyStatus;

    private String deptName;

    private String datasetSourceTypeName;

    private int itemNums;

    private String regionDeptCode;

    private String regionDeptName;

    //主目录类别编码
    private String infoResourceCode;

    //梳理系统数据集id
    private String drapDatasetId;

    //
    private String transferId;
    //数据集扩展属性
    private DirDatasetExtFormat ext;

    //表间关系
    private List<DirDatasetSourceRelation> relations;

    //数据项来源
    private List<DirDataitemSourceInfo> sourceInfos;

    //大普查
    private DirDatasetSurvey survey;

    private Integer serviceNum;
    public DirDatasetSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(DirDatasetSurvey survey) {
        this.survey = survey;
    }

    public List<DirDatasetSourceRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<DirDatasetSourceRelation> relations) {
        this.relations = relations;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getRelClassifyName() {
        return relClassifyName;
    }

    public void setRelClassifyName(String relClassifyName) {
        this.relClassifyName = relClassifyName;
    }

    public String getClassifyStatus() {
        return classifyStatus;
    }

    public void setClassifyStatus(String classifyStatus) {
        this.classifyStatus = classifyStatus;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRegionDeptCode() {
        return regionDeptCode;
    }

    public void setRegionDeptCode(String regionDeptCode) {
        this.regionDeptCode = regionDeptCode;
    }

    public String getRegionDeptName() {
        return regionDeptName;
    }

    public void setRegionDeptName(String regionDeptName) {
        this.regionDeptName = regionDeptName;
    }

    public String getInfoResourceCode() {
        return infoResourceCode;
    }

    public void setInfoResourceCode(String infoResourceCode) {
        this.infoResourceCode = infoResourceCode;
    }

    public DirDatasetExtFormat getExt() {
        return ext;
    }

    public void setExt(DirDatasetExtFormat ext) {
        this.ext = ext;
    }

    public List<DirDataitemVo> getItems() {
        return items;
    }

    public void setItems(List<DirDataitemVo> items) {
        this.items = items;
    }

    public String getClassifyIds() {
        return classifyIds;
    }

    public void setClassifyIds(String classifyIds) {
        this.classifyIds = classifyIds;
    }

    public String getDatasetSourceTypeName() {
        return datasetSourceTypeName;
    }

    public void setDatasetSourceTypeName(String datasetSourceTypeName) {
        this.datasetSourceTypeName = datasetSourceTypeName;
    }

    public int getItemNums() {
        return itemNums;
    }

    public void setItemNums(int itemNums) {
        this.itemNums = itemNums;
    }

    public String getDrapDatasetId() {
        return drapDatasetId;
    }

    public void setDrapDatasetId(String drapDatasetId) {
        this.drapDatasetId = drapDatasetId;
    }

	public DirDataTransfer getTransfer() {
		return transfer;
	}

	public void setTransfer(DirDataTransfer transfer) {
		this.transfer = transfer;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public Integer getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
	}

    public List<DirDataitemSourceInfo> getSourceInfos() {
        return sourceInfos;
    }

    public void setSourceInfos(List<DirDataitemSourceInfo> sourceInfos) {
        this.sourceInfos = sourceInfos;
    }
}
