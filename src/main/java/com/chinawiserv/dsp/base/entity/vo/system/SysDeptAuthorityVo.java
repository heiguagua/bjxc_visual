package com.chinawiserv.dsp.base.entity.vo.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;

/**
 * <p>
 * 部门数据权限分配表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public class SysDeptAuthorityVo extends SysDeptAuthority{

    private String authObjIds;

    private String authType;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthObjIds() {
        return authObjIds;
    }

    public void setAuthObjIds(String authObjIds) {
        this.authObjIds = authObjIds;
    }
}
