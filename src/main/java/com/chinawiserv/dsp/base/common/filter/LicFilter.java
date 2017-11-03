package com.chinawiserv.dsp.base.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.base.common.config.Config;
import com.qwserv.wiservlic.LicAuthorize;
import com.qwserv.wiservlic.bean.LicInfo;
import com.qwserv.wiservlic.common.StringUtils;
import com.qwserv.wiservlic.impl.LicAuthorizeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yangd
 * Date: 2017/11/3
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class LicFilter extends OncePerRequestFilter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Map licHashMap = new ConcurrentHashMap();
    //lic系统名称
    public static String licSysName;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //检查今天是否验证过lic
        String customDate = getCustomDate();
        if(licHashMap.get(customDate) == null){
            if (request != null) {
                String url = request.getServletPath();
                //过滤关于lic上传的所有请求
                if ( checkUrlExclude(url) ) {
                    //获取项目标识简称 此简称与lic中的要一致才能通过
                    licSysName = getFilterConfig().getInitParameter("licSysName");

                    //lic验证
                    LicAuthorize licAuthorize = new LicAuthorizeImpl();
                    String licInfoStr = licAuthorize.doLicAuthorize(licSysName, Config.LIC_PATH);
                    LicInfo licInfo = JSONObject.parseObject(licInfoStr, LicInfo.class);
                    if(licInfo.getIsValidity() == 0){
                        //重定向到license上传页面
                        turnToLicUploadPage(request, response);
                    }else{
                        //存放校验lic信息
                        licHashMap.put(customDate, licInfo);
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     *
     * @param url
     * @return
     */
    private boolean checkUrlExclude(String url){
        boolean flag = true;
        if(StringUtils.isEmpty(url)){
            flag = true;
        }if(url.contains("/lic/licErrorPage") || url.contains("/lic/uploadLic")){
            flag = false;
        }else if(url.contains("/fonts/") || url.startsWith("/plugins")  || url.endsWith(".css")  || url.endsWith(".js") || url.endsWith(".png") || url.endsWith(".gif") || url.endsWith(".jpg") || url.endsWith(".jpeg")){
            flag = false;
        }
        return flag;
    }
    /**
     * 跳转至lic上传页
     *
     * @param request
     * @param response
     */
    private void turnToLicUploadPage(HttpServletRequest request, HttpServletResponse response) {
        if (request != null) {
            try {
                RequestDispatcher rd = request.getRequestDispatcher("/lic/licErrorPage");
                rd.forward(request, response);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * 当前年月日
     * @return
     */
    private String getCustomDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date()); // new Date()为获取当前系统时间
    }
}
