package com.chinawiserv.dsp.base.common.util;

import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.base.common.config.Config;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;


public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static String proxyHost = "127.0.0.1";

    private static int proxyPort = 8088;
	
	/**
	 * 
	 * 允许 JS 跨域设置
	 * 
	 * <p>
	 * <!-- 使用 nginx 注意在 nginx.conf 中配置 -->
	 * 
	 * http {
  	 * 	......
     * 	 add_header Access-Control-Allow-Origin *;
     *  ......
  	 * } 
	 * </p>
	 * 
	 * <p>
	 * 非 ngnix 下，如果该方法设置不管用、可以尝试增加下行代码。 
	 * 
	 * response.setHeader("Access-Control-Allow-Origin", "*");
	 * </p>
	 * 
	 * @param response
	 * 				响应请求
	 */
	public static void allowJsCrossDomain( HttpServletResponse response ) {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader("Access-Control-Max-Age", "3600");
	}

	/**
	 * 
	 * <p>
	 * 判断请求是否为 AJAX
	 * </p>
	 * 
	 * @param request
	 * 				当前请求
	 * @return
	 */
	public static boolean isAjax( HttpServletRequest request ) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ? true : false;
	}
	
	/**
	 * 
	 * <p>
	 * AJAX 设置 response 返回状态
	 * </p>
	 * 
	 * @param response
	 * @param status
	 * 				HTTP 状态码
	 * @param tip
	 */
	public static void ajaxStatus( HttpServletResponse response, int status, String tip ) {
		try {
			response.setContentType("text/html;charset=" + Config.SSO_ENCODING);
			response.setStatus(status);
			PrintWriter out = response.getWriter();
			out.print(tip);
			out.flush();
		} catch ( IOException e ) {
            logger.error(e.toString());
		}
	}

	/**
	 * 
	 * <p>
	 * 获取当前 URL 包含查询条件
	 * </p>
	 * 
	 * @param request
	 * @param encode
	 *            URLEncoder编码格式
	 * @return
	 * @throws java.io.IOException
	 */
	public static String getQueryString(HttpServletRequest request, String encode) throws IOException {
		StringBuffer sb = new StringBuffer(request.getRequestURL());
		String query = request.getQueryString();
		if (query != null && query.length() > 0) {
			sb.append("?").append(query);
		}
		return URLEncoder.encode(sb.toString(), encode);
	}

	/**
	 * 
	 * <p>
	 * getRequestURL是否包含在URL之内
	 * </p>
	 * 
	 * @param request
	 * @param url
	 *            参数为以';'分割的URL字符串
	 * @return
	 */
	public static boolean inContainURL(HttpServletRequest request, String url) {
		boolean result = false;
		if (url != null && !"".equals(url.trim())) {
			String[] urlArr = url.split(";");
			StringBuffer reqUrl = new StringBuffer(request.getRequestURL());
			for (int i = 0; i < urlArr.length; i++) {
				if (reqUrl.indexOf(urlArr[i]) > 1) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * <p>
	 * URLEncoder 返回地址
	 * </p>
	 * 
	 * @param url
	 *            跳转地址
	 * @param retParam
	 *            返回地址参数名
	 * @param retUrl
	 *            返回地址
	 * @return
	 */
	public static String encodeRetURL(String url, String retParam, String retUrl) {
		return encodeRetURL(url, retParam, retUrl, null);
	}

	/**
	 * <p>
	 * URLEncoder 返回地址
	 * </p>
	 * 
	 * @param url
	 *            跳转地址
	 * @param retParam
	 *            返回地址参数名
	 * @param retUrl
	 *            返回地址
	 * @param data
	 *            携带参数
	 * @return
	 */
	public static String encodeRetURL(String url, String retParam, String retUrl, Map<String, String> data) {
		if (url == null) {
			return null;
		}

		StringBuffer retStr = new StringBuffer(url);
		retStr.append("?");
		retStr.append(retParam);
		retStr.append("=");
		try {
			retStr.append(URLEncoder.encode(retUrl, Config.SSO_ENCODING));
		} catch (UnsupportedEncodingException e) {
			logger.error("encodeRetURL error." + url);
			e.printStackTrace();
		}
		
		if (data != null) {
			for (Map.Entry<String, String> entry : data.entrySet()) {
				retStr.append("&").append(entry.getKey()).append("=").append(entry.getValue());
			}
		}

		return retStr.toString();
	}
	
	/**
	 * <p>
	 * URLDecoder 解码地址
	 * </p>
	 * 
	 * @param url
	 *            解码地址
	 * @return
	 */
	public static String decodeURL(String url) {
		if (url == null) {
			return null;
		}
		String retUrl = "";
		
		try {
			retUrl = URLDecoder.decode(url, Config.SSO_ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("encodeRetURL error." + url);
			e.printStackTrace();
		}

		return retUrl;
	}

	/**
	 * <p>
	 * GET 请求
	 * </p>
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isGet(HttpServletRequest request) {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * POST 请求
	 * </p>
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isPost(HttpServletRequest request) {
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * <p>
	 * 请求重定向至地址 location
	 * </p>
	 * 
	 * @param response
	 * 				请求响应
	 * @param location
	 * 				重定向至地址
	 */
	public static void sendRedirect(HttpServletResponse response, String location) {
		try {
			response.sendRedirect(location);
		} catch (IOException e) {
			logger.error("sendRedirect location:" + location);
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 获取Request Playload 内容
	 * </p>
	 * 
	 * @param request
	 * @return Request Playload 内容
	 */
	public static String requestPlayload(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * <p>
	 * 获取当前完整请求地址
	 * </p>
	 * 
	 * @param request
	 * @return 请求地址
	 */
	public static String getRequestUrl(HttpServletRequest request) {
		StringBuffer url = new StringBuffer(request.getScheme());
		// 请求协议 http,https
		url.append("://");
		url.append(request.getHeader("host"));// 请求服务器
		url.append(request.getRequestURI());// 工程名
		if (request.getQueryString() != null) {
			// 请求参数
			url.append("?").append(request.getQueryString());
		}
		return url.toString();
	}

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) throws Exception {
        String result = "";
        BufferedReader in = null;
        HttpURLConnection connection = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
        // 使用finally块来关闭输入流
        finally {
            if (in != null) in.close();
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url     发送请求的 URL
     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param isproxy 是否使用代理模式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, boolean isproxy) throws Exception {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            if (isproxy) {//使用代理模式
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 打开和URL之间的连接

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // POST方法

            // 设置通用的请求属性

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.connect();

            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            if (out != null) out.close();
            if (in != null) in.close();
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result;
    }

    /**
	 * 向指定 URL 发送POST方法的请求JSON数据
	 * */
    public static String sendPostJson(String url,String Json){
    	HttpPost httpPost = new HttpPost(url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
		httpPost.setHeader("Accept","application/json");
		try {
			StringEntity se = new StringEntity(Json, Charset.forName("UTF-8"));
			httpPost.setEntity(se);
			HttpResponse response=httpClient.execute(httpPost);

			if(response != null && response.getStatusLine().getStatusCode() == 200) {
				String result= EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}