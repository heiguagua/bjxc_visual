package com.chinawiserv.dsp.base.common.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;

public class XssHttpServletRequestWrapperForUeditor extends HttpServletRequestWrapper {
	HttpServletRequest orgRequest = null;

	public XssHttpServletRequestWrapperForUeditor(HttpServletRequest request) {
		super(request);
		orgRequest = request;
	}

	/**
	 * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
	 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			try {
				encodedValues[i] = cleanSafeHtml(values[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("过滤器出现错误");
				e.printStackTrace();
			}

		}
		return encodedValues;

	}

	/**
	 * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
	 * getHeaderNames 也可能需要覆盖
	 */
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	/**
	 * 将容易引起xss漏洞的半角字符直接替换成全角字符
	 *
	 * @param s
	 * @return
	 */
	private static String xssEncode(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
			case '\'':
				sb.append('\'');// 全角单引号
				break;
			case '\"':
				sb.append('\"');// 全角双引号
				break;
			case '&':
				sb.append('＆');// 全角
				break;
			// case '\\':
			// sb.append('＼');// 全角斜线
			// break;
			case '#':
				sb.append('＃');// 全角井号
				break;
			case '%': // < 字符的 URL 编码形式表示的 ASCII 字符（十六进制格式） 是: %3c
				processUrlEncoder(sb, s, i);
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	public static void processUrlEncoder(StringBuilder sb, String s, int index) {
		if (s.length() >= index + 2) {
			if (s.charAt(index + 1) == '3' && (s.charAt(index + 2) == 'c' || s.charAt(index + 2) == 'C')) { // %3c,
																											// %3C
				sb.append('＜');
				return;
			}
			if (s.charAt(index + 1) == '6' && s.charAt(index + 2) == '0') { // %3c
																			// (0x3c=60)
				sb.append('＜');
				return;
			}
			if (s.charAt(index + 1) == '3' && (s.charAt(index + 2) == 'e' || s.charAt(index + 2) == 'E')) { // %3e,
																											// %3E
				sb.append('＞');
				return;
			}
			if (s.charAt(index + 1) == '6' && s.charAt(index + 2) == '2') { // %3e
																			// (0x3e=62)
				sb.append('＞');
				return;
			}
		}
		sb.append(s.charAt(index));
	}

	/**
	 * 采用jsoup白名单方式过滤非法的html字符。 原理： 1.首先通过白名单过滤掉非法的html标签，即只允许输出白名单内的标签
	 * 2.对特殊的属性（主要是style）用正则过滤，只允许安全的属性值存在
	 * 
	 * @param htmlStr
	 *            原始的html片段（用户通过富文本编辑器提交的html代码）
	 * @return 过滤后的安全的html片段
	 * @throws IOException
	 */
	public String cleanSafeHtml(String htmlStr) throws IOException {
		Document doc = Jsoup.parseBodyFragment(htmlStr);
		OutputSettings outSet = new OutputSettings();
		outSet.prettyPrint(false);
		outSet.outline(false);
		doc.outputSettings(outSet);
//		initWhiteList();
		// Map<String, String> regexMap = initRegexMap();
		// if (regexMap != null) {
		// for (Map.Entry<String,String> entiy:regexMap.entrySet()){
		// String key = entiy.getKey();
		// Elements els = doc.select(key);
		// for (Element el:els) {
		// System.out.println("old el:"+el.toString());
		// String attribute = key.substring(key.indexOf("[")+1,
		// key.indexOf("]"));
		// String attributeValue = el.attr(attribute);
		// Matcher valueMatcher =
		// Pattern.compile(entiy.getValue()).matcher(attributeValue);
		// if (valueMatcher.find()) {
		// String safeValue = valueMatcher.group();
		// System.out.println("safeValue:"+safeValue);
		// el.attr(attribute, safeValue);
		// }
		// System.out.println("new el:"+el.toString());
		// }
		// }
		// }
//		Whitelist whitelist = initWhiteList();
		String safeString = Jsoup.clean(doc.html(), "", whitelist);
		System.out.println("safestring:" + safeString);
		return safeString;

	}

	public static Whitelist whitelist = null;
	

	// private static Map<String, String> regexMap = null;
	// private static Map<String, String> initRegexMap() throws IOException {
	// if (regexMap == null) {
	// synchronized (new Object()) {
	// regexMap = new HashMap<String, String>();
	// String jsonString = null;
	// StringBuffer jString = null;
	// Resource resource = new ClassPathResource("/conf/checklist.properties");
	// File file = null;
	// InputStream input = null;
	// Writer output = null;
	// try {
	// file = resource.getFile();
	// input = new FileInputStream(file);
	// InputStreamReader reader = new InputStreamReader(input,"GBK");
	// BufferedReader br = new BufferedReader(reader);
	// String line;
	//
	// while ((line = br.readLine()) != null) {
	// jString.append(line);
	// }
	//// output = new StringWriter();
	// jsonString = new String(jString);
	// br.close();
	// reader.close();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }finally {
	// if (input != null) {
	// IOUtils.closeQuietly(input);
	//
	//// input.close();
	// }
	// if (output != null) {
	// IOUtils.closeQuietly(output);
	//// output.close();
	// }
	// }
	// JSONObject jsonObject = JSONObject.fromObject(jsonString);
	// JSONObject whitelistjson = jsonObject.getJSONObject("whiteList");
	// JsonMapper newMapper = new JsonMapper();
	// Map<String, Map<String, String>> whitelistmap =
	// newMapper.fromJson(whitelistjson.toString(), HashMap.class);
	// for (Map.Entry<String, Map<String, String>>
	// entiy:whitelistmap.entrySet()){
	// String tag = entiy.getKey();
	// for (Map.Entry<String,String> entiy2:entiy.getValue().entrySet()){
	// String attribute = entiy2.getKey();
	// String attributeValue = entiy2.getValue();
	// if (attributeValue != null && attributeValue.trim().length() > 0) {
	// regexMap.put(tag+"["+ attribute +"]", attributeValue);
	// }
	// }
	// }
	// }
	// }
	// return regexMap;
	// }

	/**
	 * 获取最原始的request
	 *
	 * @return
	 */
	public HttpServletRequest getOrgRequest() {
		return orgRequest;
	}

	/**
	 * 获取最原始的request的静态方法
	 *
	 * @return
	 */
	public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
		if (req instanceof XssHttpServletRequestWrapperForUeditor) {
			return ((XssHttpServletRequestWrapperForUeditor) req).getOrgRequest();
		}
		return req;
	}
}