package com.chinawiserv.dsp.base.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONException;

/**
 * 参数检查工具类
 * 
 * @author Marke
 *
 */
public abstract class Helper {
	
	/**
	 * 字符串参数检查
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean checkParam(String... strings) {
		for (String s : strings) {
			if (s == null || "".equals(s.trim())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 字符串参数检查
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean checkParam(Object... strings) {
		for (Object s : strings) {
			if (s == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 时间转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		if (!Helper.checkParam(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
			
		}
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat formate = new SimpleDateFormat(format);
		return formate.format(date);
	}
	
	/**
	 * sql时间转Date时间
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date sqlDateToUtilDate(java.sql.Date date, String format) {
		if (!Helper.checkParam(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
			
		}
		if (date == null) {
			date = new java.sql.Date(new Date().getTime());
		}
		java.util.Date utilDate = new Date(date.getTime());
		return utilDate;
	}
	
	/**
	 * utilDate转SQLdate
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static java.sql.Date utilDateToSqlDate(Date date, String format) {
		if (date == null) {
			return new java.sql.Date(new java.util.Date().getTime());
			
		} else {
			return new java.sql.Date(date.getTime());
		}
	}
	
	/**
	 * 根据value查找key值
	 * 
	 * @param <T>
	 * @param objMap
	 * @param value
	 * @return
	 */
	public static <T> Object findKeyByValue(Map<T, T> objMap, T value) {
		if (objMap == null || objMap.isEmpty() || !Helper.checkParam(value)) {
			return null;
		}
		Set<Entry<T, T>> set = objMap.entrySet();
		for (Entry<T, T> en : set) {
			if (en.getValue() == null) {
				continue;
			}
			
			if (value.equals(en.getValue())) {
				return en.getKey();
			} else {
				continue;
			}
		}
		return null;
	}
	
	/**
	 * 根据key值查找value
	 * 
	 * @param objMap
	 * @param key
	 * @return
	 */
	public static <T> T findMapValueByKey(Map<T, T> objMap, T key) {
		if (objMap == null || key == null) {
			return null;
		}
		return objMap.get(key);
	}
	
	/**
	 * JSON对象数组转List
	 * 
	 * @param <T>
	 * @param arr
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonArrayChangeToList(JSONArray arr, T t) {
		if (arr == null || arr.isEmpty()) {
			return null;
		}
		JSONObject obj = null;
		List<T> list = new ArrayList<T>(1);
		try {
			T bean = null;
			for (int i = 0; i < arr.size(); i++) {
				
				obj = arr.getJSONObject(i);
				if (obj == null) {
					continue;
				}
				bean = (T) JSONObject.toBean(obj, t.getClass());
				list.add(bean);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	/**
	 * 获取页面对象
	 * 
	 * @param paramMap
	 * @return
	 */
	public static Map<String, String> getPageParamObject(
			Map<String, String> paramMap) {
		int pageNumber = Integer
				.parseInt(paramMap.get("pageNumber").toString());
		int pageSize = Integer.parseInt(paramMap.get("pageSize").toString());
		pageNumber = (pageNumber-1) * pageSize ;
		paramMap.put("pageNumber", String.valueOf(pageNumber));
		return paramMap;
	}

	public static Map<String, Object> setPageNumber(Map<String, Object> paramMap) {
		int pageNumber = Integer.parseInt(paramMap.get("pageNumber").toString());
		int pageSize = Integer.parseInt(paramMap.get("pageSize").toString());
		pageNumber = (pageNumber-1) * pageSize ;
		paramMap.put("pageNumber", String.valueOf(pageNumber));
		return paramMap;
	}

	/**
	 * 把map中指定key值的value从String变为String[]
	 */
	public static void handleMultiParams(Map map, String key) {
		if (map != null && map.get(key) != null) {
			String ids = (String) map.get(key);
			if (ids != null && !ids.trim().isEmpty()) {
				String[] idArray = ids.split(",");
				map.put(key, idArray);
			}
		}
	}
	
	public static <T> Map<String, Object> getPageResult(
			Map<String, String> paramMap, int count, List<T> recordLst) {
		Map<String, Object> resultMap = new HashMap<String, Object>(1);
		
		int pageSize = Integer.parseInt(paramMap.get("pageSize").toString());
		int pageNum = 0;
		if (count > 0) {
			pageNum = count % pageSize == 0 ? 0 : (count / pageSize + 1);
		}
		resultMap.put("total", count);
		resultMap.put("rows", recordLst);
		resultMap.put("pageNumber", pageNum);
		resultMap.put("pageSize", paramMap.get("pageSize"));
		return resultMap;
	}
	
	/**
	 * 转义正则特殊字符 （$()*+.[]?\^{},|）
	 * 
	 * @param keyword
	 * @return
	 */
	public static String escapeExprSpecialWord(String keyword) {
		if (StringUtils.isNotBlank(keyword)) {
			String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]",
					"?", "^", "{", "}", "|" };
			for (String key : fbsArr) {
				if (keyword.contains(key)) {
					keyword = keyword.replace(key, "\\" + key);
				}
			}
		}
		return keyword;
	}
}
