package com.chinawiserv.dsp.base.common.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.common.config.Config;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.qwserv.wiservlic.LicAuthorize;
import com.qwserv.wiservlic.bean.LicInfo;
import com.qwserv.wiservlic.impl.LicAuthorizeImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    public static Map licHashMap = new ConcurrentHashMap();
    @Autowired
    private ISysSettingService sysSettingService;
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
        boolean allowinvoke = false;
        //检查今天是否验证过lic
        String customDate = getCustomDate();
        if(licHashMap.get(customDate) == null){
            if (request != null) {
                String url = request.getServletPath();
                //过滤关于lic上传的所有请求
                if (("" + url).contains("/lic/licErrorPage") || ("" + url).contains("/lic/uploadLic") ) {
                    return true;
                }else{
                    //获取项目标识简称 此简称与lic中的要一致才能通过
                    EntityWrapper<SysSetting> wrapper = new EntityWrapper<>();
                    SysSetting sysSetting = new SysSetting();
                    sysSetting.setSettingCode("integrateCurNo");
                    wrapper.setEntity(sysSetting);
                    sysSetting = sysSettingService.selectOne(wrapper);
                    String settingValue = sysSetting.getSettingValue();
                    //lic验证
                    LicAuthorize licAuthorize = new LicAuthorizeImpl();
                    String licInfoStr = licAuthorize.doLicAuthorize(settingValue, Config.LIC_PATH);
                    LicInfo licInfo = JSONObject.parseObject(licInfoStr, LicInfo.class);
                    if(licInfo.getIsValidity() == 0){
                        //重定向到license上传页面
                        turnToLicUploadPage(request, response);
                    }else{
                        //存放校验lic信息
                        licHashMap.put(customDate, licInfo);
                        allowinvoke = true;
                    }
                }
            }
        }else{
            allowinvoke = true;
        }
        return allowinvoke;
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

    /**
     * 当前年月日
     * @return
     */
    private String getCustomDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date()); // new Date()为获取当前系统时间
    }

}