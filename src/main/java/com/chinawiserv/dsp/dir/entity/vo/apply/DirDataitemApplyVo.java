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
    private String appilicatinDept;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAppilicatinDept() {
        return appilicatinDept;
    }

    public void setAppilicatinDept(String appilicatinDept) {
        this.appilicatinDept = appilicatinDept;
    }
}
