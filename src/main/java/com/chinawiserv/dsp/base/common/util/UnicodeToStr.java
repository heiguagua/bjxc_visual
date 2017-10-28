package com.chinawiserv.dsp.base.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/7/13.
 */
public class UnicodeToStr {
    /**
     * 将unicode转码为中文
     * @param dataStr
     * @return
     */
    public static String decodeUnicode(final String dataStr) {
        if(dataStr.indexOf("\\u") == -1){
            return dataStr;
        }
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    /**
     * 转换类似于这样的&#26159;&#30340;
     * 字符串
     * @param temp
     * @return
     */
    public static String transUnicodeToString(String temp){
        String regExp = "&#\\d*;";

        Matcher m = Pattern.compile(regExp).matcher(temp);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String s = m.group(0);
            s = s.replaceAll("(&#)|;", "");
            char c = (char) Integer.parseInt(s);
            m.appendReplacement(sb, Character.toString(c));
        }
        m.appendTail(sb);
        return sb.toString();
    }
    /**
     * 汉字转unicode
     * @param gbString
     * @return
     */
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }

    /**
     * unicode与字符混合转换成String
     * @param theString
     * @return
     */
    public static String decodeUnicodeToString(String theString) {
        char aChar;

        int len = theString.length();

        StringBuffer outBuffer = new StringBuffer(len);

        for (int x = 0; x < len;) {

            aChar = theString.charAt(x++);

            if (aChar == '\\') {

                aChar = theString.charAt(x++);

                if (aChar == 'u') {

                    // Read the xxxx

                    int value = 0;

                    for (int i = 0; i < 4; i++) {

                        aChar = theString.charAt(x++);

                        switch (aChar) {

                            case '0':

                            case '1':

                            case '2':

                            case '3':

                            case '4':

                            case '5':

                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';

                    else if (aChar == 'n')

                        aChar = '\n';

                    else if (aChar == 'f')

                        aChar = '\f';

                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);

        }

        return outBuffer.toString();

    }
    public static void main(String[] args) {
//        String str = "\\u76f8\\u540c\\u7684\\u4e3b\\u9898\\u5e16\\u8bf7\\u4e0d\\u8981\\u91cd\\u590d\\u53d1\\u8868";
//        System.out.println(decodeUnicode(str));
//        String str = "\\u53d1\\u9001\\u8fc7\\u4e8e\\u9891\\u7e41,\\u8bf7\\u7a0d\\u540e\\u518d\\u53d1";
//        String str = "\\u9519\\u8BEF\\u53C2\\u6570userid[null]!";
        String str = "75mm&#65288;&#21547;&#65289;-80mm(&#19981;&#21547;)";

        try {
            System.out.println(transUnicodeToString(str));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(gbEncoding(decodeUnicode(str)));
    }

}
