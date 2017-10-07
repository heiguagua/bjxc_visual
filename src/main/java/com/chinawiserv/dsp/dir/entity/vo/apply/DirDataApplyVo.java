package com.chinawiserv.dsp.dir.entity.vo.apply;

import com.chinawiserv.dsp.dir.entity.po.apply.DirDataApply;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataItemApply;

import java.util.List;
import java.util.Map;

public class DirDataApplyVo extends DirDataApply {

    private String classifyStructureName;

    private String datasetName;

    private String userName;

    private String realName;

    private String deptName;

    private List<DirDataItemApply> dirDataItemApplyList;

    public String getClassifyStructureName() {
        return classifyStructureName;
    }

    public void setClassifyStructureName(String classifyStructureName) {
        this.classifyStructureName = classifyStructureName;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<DirDataItemApply> getDirDataItemApplyList() {
        return dirDataItemApplyList;
    }

    public void setDirDataItemApplyList(List<DirDataItemApply> dirDataItemApplyList) {
        this.dirDataItemApplyList = dirDataItemApplyList;
    }
}
