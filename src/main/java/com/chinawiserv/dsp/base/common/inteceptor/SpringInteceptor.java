package com.chinawiserv.dsp.base.common.inteceptor;

import com.chinawiserv.dsp.base.common.filter.LicFilter;
import com.qwserv.wiservlic.bean.LicInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yangd
 * Date: 2017/11/2
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class SpringInteceptor implements HandlerInterceptor {
    /**
     * 拦截器
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 方法执行前的预处理
     *
     * @param request  http请求
     * @param response response响应
     * @param handler  操作对象
     * @return 是否拦截
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        try{
            Object licInfoObj = LicFilter.licHashMap.get(df.format(new Date()));
            if(licInfoObj == null){
                turnToLicUploadPage(request, response);
                return false;
            }else{
                LicInfo licInfo = (LicInfo)licInfoObj;
                if(licInfo.getIsValidity() == 0){
                    turnToLicUploadPage(request, response);
                    return false;
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            turnToLicUploadPage(request, response);
            return false;
        }
        return true;
    }



    /**
     * 方法内容执行完后的处理
     *
     * @param request      request请求
     * @param response     response响应
     * @param handler      操作对象
     * @param modelAndView 返回的视图
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法完成后的处理
     *
     * @param request  request请求
     * @param response response响应
     * @param handler  操作对象
     * @param e        异常
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {

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

}