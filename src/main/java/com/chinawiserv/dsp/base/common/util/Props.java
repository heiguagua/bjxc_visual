package com.chinawiserv.dsp.base.common.util;

import com.google.common.base.Strings;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/22
 * Time:10:23
 * Chinawiserv Technologies Co., Ltd.
 */
public class Props {
    private Properties prop;

    private Props() {
    }

    private Props(Properties properties) {
        this.prop = properties;
    }

    private Props(String uri) {
        if(!Strings.isNullOrEmpty(uri)) {
            this.load(uri);
        }
    }

    public Props load(String uri) {
        try {
            this.prop = null;
            Properties pro = new Properties();
            pro.load(this.getClass().getClassLoader().getResource(uri).openStream());
            this.prop = pro;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return this;
    }

    public static Props of() {
        return new Props();
    }

    public boolean success() {
        return this.prop != null;
    }

    public static Props of(String uri) {
        return new Props(uri);
    }

    public static Props of(Properties properties) {
        return new Props(properties);
    }

    public String get(String key) {
        String type = new String("");
        if(this.prop != null) {
            type = new String(this.prop.getProperty(key, ""));
        }
        return type;
    }
}
