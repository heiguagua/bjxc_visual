package com.chinawiserv.dsp.base.common.config;

import java.io.File;

/**
 * 静态配置信息
 *  Created by Gaojun.Zhou 2017年4月8日
 */
public class Config {
    public static final String SSO_ENCODING = "UTF-8";

    /**
     * license名称
     */
    public final static String LIC_NAME = "qinzhi_authorize.lic";
    /**
     * license路径
     */
    public static String getLicPath(){
        String licPath = System.getProperty("project.path")+ File.separator+"lic";
        return licPath;
    }


}