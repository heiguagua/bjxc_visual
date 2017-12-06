package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jacky on 2017/5/11.1
 */
public class SysUserVo extends SysUser {

    private String deptName;
    private String deptTreeCode;
    private String createName;
    private String regionName;
    private int regionLevel;
    private String[] roleIds;
    private List<SysRole> sysRoleList;
    private List<String> permissionDeptTreeCodes = new ArrayList();

    public String getDeptName() {
        return deptName;
    }

    public String getCreateName() {
        return createName;
    }

    public String[] getRoleIds() {
        if(roleIds == null && sysRoleList != null && !sysRoleList.isEmpty()){
            roleIds = sysRoleList.stream().map(SysRole::getId).collect(Collectors.toList()).toArray(new String[]{});
        }
        return roleIds;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptTreeCode() {
        return deptTreeCode;
    }

    public void setDeptTreeCode(String deptTreeCode) {
        this.deptTreeCode = deptTreeCode;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setRoleIds(String[] roleIds) { this.roleIds = roleIds;}

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public List<String> getPermissionDeptTreeCodes() {
        return permissionDeptTreeCodes;
    }

    public void setPermissionDeptTreeCodes(List<String> permissionDeptTreeCodes) {
        this.permissionDeptTreeCodes = permissionDeptTreeCodes;
    }

    public int getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(int regionLevel) {
        this.regionLevel = regionLevel;
    }

    public int getMinRoleLevel(){
        if(sysRoleList != null && !sysRoleList.isEmpty()){
            return sysRoleList.stream().min((a, b) -> a.getRoleLevel().compareTo(b.getRoleLevel())).get().getRoleLevel();
        }
        return -1;
    }
}
