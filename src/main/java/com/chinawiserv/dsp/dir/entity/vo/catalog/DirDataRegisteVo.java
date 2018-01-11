package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataRegiste;

/**
 * <p>
 * 数据注册情况表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public class DirDataRegisteVo extends DirDataRegiste{
    private String registerName;

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }
}
