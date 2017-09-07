package com.chinawiserv.dsp.base.common.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 通用工具类
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:51:21
 */
public class CommonUtil {
	/**
	 * 获取32位UUID（去掉"-" ）
	 * 
	 * @return
	 */
	public static String get32UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 格式化异常
	 */
	public static String formatException(Exception e) {
		String message = e.getMessage();
		if (StringUtils.isBlank(message)) {
			return "系统繁忙,请稍后重试";
		}

		String runtimeStr = "java.lang.RuntimeException: ";
		message = message.replaceAll(runtimeStr, "");
		return message;
	}

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr){
		return MD5.encode(inStr , "UTF-8");
	}

	/**
	 * 文件重命名
	 * @param fileName
	 * @return
	 */
	public static String renameFile(String fileName) {
		String now = DateTimeUtils.dateTimeToString(LocalDateTime.now() , DateTimeUtils.YYYYMMDD);
		String ext = fileName.substring(fileName.lastIndexOf("."));
		return now + File.separator+ RandomStringUtils.randomAlphanumeric(32) + ext;
	}

	/**
	 * 过滤非法字符
	 */
	public static String filterValidateChar(String str) {  
		
		if(StringUtils.isBlank(str)){
			return "";
		}
		str = str.toLowerCase().trim();//统一转为小写  
        
		String badStr = "'|exec|execute|insert|select|delete|update|drop|*|%|master|truncate|" +  
                "declare|sitename|net user|xp_cmdshell" ;
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.contains(badStrs[i])) {  
                str = str.replaceAll(badStrs[i], "");
            }  
        }  
        return str;  
    }
	/**
	 * 转换逻辑符号
	 * @param where
	 * @return
	 */
	public static String formatWhereSQL(String where) {
		if(StringUtils.isBlank(where)){
			return "";
		}
		where = where.replaceAll("eq", " = ");
		where = where.replaceAll("nq", " != ");
		where = where.replaceAll("lt", " < ");
		where = where.replaceAll("lq", " <= ");
		where = where.replaceAll("gt", " > ");
		where = where.replaceAll("gq", " >= ");
		
		return where;
	}

	/**
	 * 在StringBuffer末尾追加逗号，然后再追加另一个字符串
	 * @param stringBuffer
	 * @param appendStr
	 * @return
	 */
	public static StringBuffer appendWithComma(StringBuffer stringBuffer , String appendStr){
		if (stringBuffer == null || stringBuffer.length() == 0) {
			stringBuffer = new StringBuffer(appendStr);
		} else {
			stringBuffer.append(",").append(appendStr) ;
		}

		return stringBuffer;
	}

	/**
	 * 在StringBuffer末尾追加逗号，然后再追加另一个字符串
	 * @param string
	 * @param appendStr
	 * @return
	 */
	public static StringBuffer appendWithComma(String string , String appendStr){
		if(string == null){
			string = "";
		}
		return appendWithComma(new StringBuffer(string), appendStr);
	}
	/**
	 * 在StringBuffer末尾追加逗号，然后再追加另一个字符串
	 * @param str
	 * @return
	 */
	public static int stringToInt(String str) throws Exception{
		str = org.apache.commons.lang.StringUtils.isNotBlank(str) ? str : "0";
		try {
			return Integer.parseInt(str);
		}catch (Exception e){
			throw new Exception("字符串转为数字失败！");
		}
	}

	/**
	 * 使map中以逗号分隔的字符串转换成数组形式
	 * @param map
	 * @param key
	 * */
	public static void handleMultiParams(Map map, String key) {
		if (map != null && map.get(key) != null) {
			String ids = (String) map.get(key);
			if (ids != null && !ids.trim().isEmpty()) {
				String[] idArray = ids.split(",");
				map.put(key, idArray);
			}
		}
	}

	/** 合并同类对象的两个实例的非null属性
	 * @param origin
	 * @param destination
	 * @param <T>
	 */
	public static <T> void mergeCommonObject(T origin, T destination) {
		if (origin == null || destination == null)
			return;
		if (!origin.getClass().equals(destination.getClass()))
			return;

		Field[] fields = origin.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object value = fields[i].get(origin);
				if (null != value) {
					fields[i].set(destination, value);
				}
				fields[i].setAccessible(false);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 合并子类对象的非null属性到父类对象中
	 * @param origin
	 * @param destination
	 * @param <T>
	 */
	public static <T, V extends T> void mergeObject(V origin, T destination) {
		if (origin == null || destination == null)
			return;

		if (!origin.getClass().getSuperclass().equals(destination.getClass()))
			return;

		Field[] fields = origin.getClass().getSuperclass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object value = fields[i].get(origin);
				if (null != value) {
					fields[i].set(destination, value);
				}
				fields[i].setAccessible(false);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 根据列类型解析默认的生成字段长度
	 * @param columnType
	 * @return
     */
	public static String parseDefalutTargetColumnLength(String columnType) {
		String result = "";
		switch(columnType.toUpperCase()){
			case "INT":
				result = "9";
				break;
			case "CHAR":
				result = "3";
				break;
			case "VARCHAR":
				result = "512";
				break;
			case "VARCHAR2":
				result = "512";
				break;
			case "TEXT":
				result = "10000";
				break;
			case "FLOAT":
				result = "9,2";
				break;
			case "DOUBLE":
				result = "12,2";
				break;
			case "NUMERIC":
				result = "12,2";
				break;
			case "DECIMAL":
				result = "12,2";
				break;
			case "STRING":
				result = "512";
				break;
			case "OBJECT_ID":
				result = "32";
				break;
			default:
				result = "";
				break;
		}
		return result;
	}

	/**
	 * 根据列类型解析默认的生成字段长度(todo 待补充更多的适应 亦可根据源数据库类型判断)
	 * @param columnType
	 * @return
     */
	public static String parseDefalutTargetColumnType(String columnType) {

		switch(columnType.toUpperCase()){
			case "STRING":
				columnType = "12";//todo jdbc码
				break;
			case "OBJECT_ID":
				columnType = "12";
				break;
			case "NULL":
				columnType = "12";
				break;
			case "INT32":
				columnType = "4";
				break;
			case "DOUBLE":
				columnType = "2";
				break;
			default:
				break;
		}
//		switch(columnType.toUpperCase()){
//			case "STRING":
//				columnType = "VARCHAR";
//				break;
//			case "OBJECT_ID":
//				columnType = "VARCHAR";
//				break;
//			case "NUMBER":
//				columnType = "NUMERIC";
//				break;
//			case "VARCHAR2":
//				columnType = "VARCHAR";
//				break;
//			case "NCHAR":
//				columnType = "CHAR";
//				break;
//			case "NVARCHAR":
//				columnType = "VARCHAR";
//				break;
//			case "NTEXT":
//				columnType = "TEXT";
//				break;
////			case "NTEXT":
////				columnType = "TEXT";
////				break;
//			default:
//				break;
//		}
		return columnType;
	}

	/**
	 * string转string数组
	 * @param string
	 * @param divisionChar
	 * @return
	 */
	public static String[] stringToStringArray(String string, String divisionChar)
	{
		int i = 0;
		StringTokenizer tokenizer = new StringTokenizer(string, divisionChar);
		String[] str = new String[tokenizer.countTokens()];
		while (tokenizer.hasMoreTokens())
		{
			str[i] = new String();
			str[i] = tokenizer.nextToken();
			i++;
		}
		return str;
	}

	/**
	 * 字符串数组转List
	 * @param strings
	 * @return
	 */
	public static List<String> stringArrayToList(String[] strings){
		List<String> list = new ArrayList<>();
		for (String s:strings){
			list.add(s);
		}
		return list;
	}

}
