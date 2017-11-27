package com.chinawiserv.dsp.base.common.util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/11/21
 * Time:11:17
 * Chinawiserv Technologies Co., Ltd.
 */
public class RandomPasswordUtil {

    //获取验证过的随机密码
    public static String getRandomPassword(int len) {
        String result;
        while(len>=6){
            result = makeRandomPassword(len);
            if (result.matches(".*[a-z]{1,}.*") && result.matches(".*[A-Z]{1,}.*") && result.matches(".*\\d{1,}.*")) {
                return result;
            }
        }
        return null;
    }
    //随机密码生成
    private static String makeRandomPassword(int len){
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}
