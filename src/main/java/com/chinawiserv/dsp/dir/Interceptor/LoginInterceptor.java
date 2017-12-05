package com.chinawiserv.dsp.dir.Interceptor;

import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 用于在登录前验证 xss 攻击
	 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		HttpSession session = request.getSession();
		String return_url = request.getParameter("return_url");  //表单中的值
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");		
		
//		String _csrfBySession = String.valueOf(session.getAttribute("_csrf"));  //session中的值
//		session.removeAttribute("_csrf");  //使用之后从session中删掉
		
		String regEx =  ".*[`~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*";
		Pattern p = Pattern.compile(regEx);
		Matcher m1 = p.matcher(return_url);
		Matcher m2 = p.matcher(userName);
		Matcher m3 = p.matcher(password);
		Matcher m4 = p.matcher(captcha);

		boolean s1 = m1.find();
		boolean s2 = m2.find();
		boolean s3 = m3.find();
		boolean s4 = m4.find();


		
		if(s1|| s2 || s3 || s4 ) {
			
			 m1.replaceAll("_").trim();
			 m2.replaceAll("_").trim(); 
			 m3.replaceAll("_").trim(); 
			 m4.replaceAll("_").trim(); 
			 
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(403);

			//页面友好提示信息
			OutputStream oStream = response.getOutputStream();
			oStream.write("请不要提交危险字符，返回原始页面刷新后再次尝试！！！".getBytes("UTF-8"));
			
			return false;
			 
		}else{
			
			return true;
		}		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}