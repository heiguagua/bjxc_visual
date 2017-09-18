package com.chinawiserv.dsp.dir.entity.vo.apply;

import com.chinawiserv.dsp.dir.entity.po.apply.DirRegistUser;

/**
 * <p>
 * 用户注册表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirRegistUserVo extends DirRegistUser{
    private String stateName;
    private Boolean opration;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Boolean getOpration() {
        return opration;
    }

    public void setOpration(Boolean opration) {
        this.opration = opration;
    }
}
