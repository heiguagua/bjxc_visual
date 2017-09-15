package com.chinawiserv.dsp.dir.enums.apply;

/**
 * Created by Zhangm on 2017/9/15.
 */
public enum SourceTypeEnum {
    DATA_0("0", "快速添加"),

    DATA_1("1", "自定义添加");


    private String dbValue;

    private String chValue;

    private SourceTypeEnum(String dbValue, String chValue) {
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
