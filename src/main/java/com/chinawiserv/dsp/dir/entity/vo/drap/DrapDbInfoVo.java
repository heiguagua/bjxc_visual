package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;

/**
 * <p>
 * 数据库信息 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapDbInfoVo extends DrapDbInfo {

    private String connStatus;

    private String updateType;

    private String updateStatus;

    private String mTime;

    private String deptName;

    private String deptJson;

    private String systems;

    private String sysJson;

    private String statusValue;

    private List<DrapDbTableInfoVo> tableInfoVos;
    
    private List<DrapDictTableInfoVo>dictTableInfoVos;
    
    public String getConnStatus() {
        return connStatus;
    }

    public void setConnStatus(String connStatus) {
        this.connStatus = connStatus;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptJson() {
        return deptJson;
    }

    public void setDeptJson(String deptJson) {
        this.deptJson = deptJson;
    }

    public String getSystems() {
        return systems;
    }

    public void setSystems(String systems) {
        this.systems = systems;
    }

    public String getSysJson() {
        return sysJson;
    }

    public void setSysJson(String sysJson) {
        this.sysJson = sysJson;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public List<DrapDbTableInfoVo> getTableInfoVos() {
        return tableInfoVos;
    }

    public void setTableInfoVos(List<DrapDbTableInfoVo> tableInfoVos) {
        this.tableInfoVos = tableInfoVos;
    }

    public List<DrapDictTableInfoVo> getDictTableInfoVos() {
        return dictTableInfoVos;
    }

    public void setDictTableInfoVos(List<DrapDictTableInfoVo> dictTableInfoVos) {
        this.dictTableInfoVos = dictTableInfoVos;
    }

}
