package com.chinawiserv.dsp.dir.enums.catalog;

import org.springframework.util.StringUtils;

/**
 * Created by lianrongfa on 2017/10/25.
 */
public enum ColumnType {

    BIGINT("2", "BIGINT"),

    CHAR("1", "CHAR"),

    DATE("4", "DATE"),

    DATETIME("5", "DATETIME"),

    DECIMAL("2", "DECIMAL"),

    DOUBLE("9", "DOUBLE"),

    ENUM("", "ENUM"),

    FLOAT("11", "FLOAT"),

    INT("10", "INT"),

    INT_UNSIGNED("10", "INT UNSIGNED"),

    LONGTEXT("1", "LONGTEXT"),

    SMALLINT("10", "SMALLINT"),

    TEXT("1", "TEXT"),

    TIMESTAMP("5", "TIMESTAMP"),

    TINYINT("10", "TINYINT"),

    VARCHAR("1", "VARCHAR");

    private String code;
    private String desc;

    ColumnType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getCode(String desc) {
        if(StringUtils.isEmpty(desc)){
            return null;
        }
        for (ColumnType item : ColumnType.values()) {
            if(item.getDesc().equals(desc)){
                return item.getCode();
            }
        }
        return null;
    }
}
