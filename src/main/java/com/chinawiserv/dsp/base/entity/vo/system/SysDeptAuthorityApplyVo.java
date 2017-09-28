package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;

/**
 * <p>
 * 数据权限申请表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public class SysDeptAuthorityApplyVo extends SysDeptAuthorityApply{

    private String applicantName;

    private String auditorName;

    private String regionCode;

    private String treeCode;

    private String toDeptIds;

    private String deptName;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getToDeptIds() {
        return toDeptIds;
    }

    public void setToDeptIds(String toDeptIds) {
        this.toDeptIds = toDeptIds;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
