package com.chinawiserv.dsp.base.common.util;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yangd
 * Date: 2017/6/7
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
public class CustomEncrypt {

    //每隔？位插入一个随机字符
    private static final int SPLIT_INDEX = 3;
    private static String charSet = "UTF-8";

    /**
     * 获取length个随机的a-z A-Z 的字符
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(52);// [0,51)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    /**
     * 插入字符
     * @param str
     * @return
     */
    private static String inEncode(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if((i+1) % SPLIT_INDEX == 0){
                sb.append(CustomEncrypt.getRandomString(1));
            }
        }
        return sb.toString();
    }

    /**
     * 去除偶数位插入的字符
     * @param str
     * @return
     */
    private static String outDecode(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if((i+1) % (SPLIT_INDEX+1) != 0){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 自定义加密
     * @param str
     * @return
     */
    public static String customerEncode(String str){
        if(str != null){
            //base64
            try {
                str = Base64Utils.encodeToString(Base64Utils.encode(str.getBytes(charSet)));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            str = inEncode(str);
        }
        return str;
    }

    /**
     * 自定义解密
     * @param str
     * @return
     */
    public static String customerDecode(String str){
        if(str != null){
            str = outDecode(str);
            //base64
            try {
                str = new String(Base64Utils.decode(Base64Utils.decodeFromString(str)), charSet );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        return str;
    }
    /**
     * 自定义加密(范围： 页面加密保存密码时调用)
     * @param str
     * @return
     */
    public static String customerEncodeForJsp(String str){
        if(str != null){
            //base64
            try {
                str = Base64Utils.encodeToString(str.getBytes(charSet));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            str = inEncode(str);
        }
        return str;
    }

    /**
     * 自定义解密 (范围： 解密返回给页面时调用)
     * @param str
     * @return
     */
    public static String customerDecodeForJsp(String str){
        if(str != null){
            str = outDecode(str);
            //base64
            try {
                str = new String(Base64Utils.decodeFromString(str), charSet);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 测试main方法
     * @param args
     */
    public static void main(String[] args) {
        String str = "[-poster_start-]";
        String ss = CustomEncrypt.customerEncode(str);
        System.out.println(ss);

        String st = CustomEncrypt.customerDecode(ss);
        System.out.println(st);

    }
}
