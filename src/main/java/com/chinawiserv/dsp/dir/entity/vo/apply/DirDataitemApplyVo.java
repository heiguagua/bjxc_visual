package com.chinawiserv.dsp.dir.entity.vo.apply;

import com.chinawiserv.dsp.dir.entity.po.apply.DirDataitemApply;

/**
 * <p>
 * 数据项权限申请表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirDataitemApplyVo extends DirDataitemApply{
    private String stateName;

    private String dataItemStateName;

    private String deptName;

    private String realName;

    private String datasetId;

    private String datasetName;

    private String classifyName;

    private String classifyStructureName;

    private String sourceType;

    private String sourceTypeName;

    private Boolean opration;

    public String getDataItemStateName() {
        return dataItemStateName;
    }

    public void setDataItemStateName(String dataItemStateName) {
        this.dataItemStateName = dataItemStateName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Boolean getOpration() {
        return opration;
    }

    public void setOpration(Boolean opration) {
        this.opration = opration;
    }

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
