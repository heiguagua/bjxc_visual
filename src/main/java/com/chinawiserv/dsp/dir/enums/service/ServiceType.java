package com.chinawiserv.dsp.dir.enums.service;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/11/8
 * Time:17:36
 * Chinawiserv Technologies Co., Ltd.
 */
public enum ServiceType {
    DIR("dir", "数据目录的服务"),
    HACKLE("hackle", "梳理数据表的服务"),
    MONGODB("mongoDb", "MongoDB的服务");

    private String value;
    private String desc;

    ServiceType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
