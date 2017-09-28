package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;

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
}
