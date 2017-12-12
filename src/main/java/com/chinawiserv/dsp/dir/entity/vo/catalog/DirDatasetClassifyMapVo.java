package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;

import java.util.Date;

/**
 * <p>
 * 数据集目录类别关系表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirDatasetClassifyMapVo extends DirDatasetClassifyMap{

    private String datasetName;
    private String classifyName;
    private String classifyStructureName;
    private String deptName;
    private String publishType;
    private String optUser;
    private Date optTime;
    private String optOpinion;


    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyStructureName() {
        return classifyStructureName;
    }

    public void setClassifyStructureName(String classifyStructureName) {
        this.classifyStructureName = classifyStructureName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getOptOpinion() {
        return optOpinion;
    }

    public void setOptOpinion(String optOpinion) {
        this.optOpinion = optOpinion;
    }
}
