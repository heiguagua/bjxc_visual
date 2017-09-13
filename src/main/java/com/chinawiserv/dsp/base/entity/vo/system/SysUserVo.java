package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jacky on 2017/5/11.
 */
public class SysUserVo extends SysUser {
    private String deptName;
    private String createName;
    private String[] roleIds;
    private List<SysRole> sysRoleList;

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

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public void setRoleIds(String[] roleIds) { this.roleIds = roleIds;}

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }
}
