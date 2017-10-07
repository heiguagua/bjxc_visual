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

    private String classifyIds;

    private String classifyName;

    private String classifyStatus;

    private String deptName;

    private String formatCategory;

    private String formatType;

    private String formatInfo;

    private String datasetSourceTypeName;

    //数据集扩展属性
    private DirDatasetExtFormat ext;

    //表间关系
    private List<DirDatasetSourceRelation> relations;

    //大普查
    private DirDatasetSurvey survey;

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

    public String getFormatCategory() {
        return formatCategory;
    }

    public void setFormatCategory(String formatCategory) {
        this.formatCategory = formatCategory;
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getFormatInfo() {
        return formatInfo;
    }

    public void setFormatInfo(String formatInfo) {
        this.formatInfo = formatInfo;
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
}
