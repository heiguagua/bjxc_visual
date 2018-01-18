package com.chinawiserv.dsp.base.common.inteceptor;

import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 用于在登录前验证 xss 攻击
     * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        final List<String> params = request.getParameterMap().values().stream().map(arr -> arr[0]).collect(Collectors.toList());

        String regEx =  ".*[`~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*";
        final Pattern p = Pattern.compile(regEx);
        final Optional<String> optional =  params.stream().filter(str -> p.matcher(str).find()).findFirst();

        if(optional.isPresent()){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(403);
            OutputStream oStream = response.getOutputStream();
            oStream.write("请不要提交危险字符，返回原始页面刷新后再次尝试！！！".getBytes("UTF-8"));
            return false;
        }
        return true;
    }
    //页面友好提示信息

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}