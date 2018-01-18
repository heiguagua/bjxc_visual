package com.chinawiserv.dsp.base.common.filter;

import java.io.IOException;    

import javax.servlet.Filter;    
import javax.servlet.FilterChain;    
import javax.servlet.FilterConfig;    
import javax.servlet.ServletException;    
import javax.servlet.ServletRequest;    
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;    

@Component
public class XssFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
//    	System.out.println(request.getContentType());
//    	System.out.println(request.getServletContext().getContextPath());
    	HttpServletRequest request1 = (HttpServletRequest)request;
//    	System.out.println(request1.getRequestURL());
    	StringBuffer url = request1.getRequestURL();
    	String url1 = url.toString().substring(url.lastIndexOf("/") + 1, url.length());
    	if(url.toString().contains("/dirPolicy/doEdit") || url.toString().contains("/dirPolicy/doAdd")
    			|| url.toString().contains("/dirNews/doEdit") || url.toString().contains("/dirNews/doAdd")
    			|| url.toString().contains("/dirIntrude/doEdit") || url.toString().contains("/dirIntrude/doAdd"))
    	{
    		chain.doFilter(request, response);
    	}else{
    		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest)request);
            chain.doFilter(xssRequest, response);
    	}
//    	if(request.get)
        
    }

    public void destroy() {}
}