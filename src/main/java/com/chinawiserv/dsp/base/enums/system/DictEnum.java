package com.chinawiserv.dsp.base.enums.system;

/**
 * Created by Zhangm on 2017/10/10.
 */
public enum DictEnum {
    DATA_0("0", "失效"),

    DATA_1("1", "生效");


    private String dbValue;

    private String chValue;

    private DictEnum(String dbValue, String chValue) {
        this.dbValue = dbValue;
        this.chValue = chValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public String getChValue() {
        return chValue;
    }
}
