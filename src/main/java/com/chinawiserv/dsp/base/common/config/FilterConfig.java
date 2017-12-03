package com.chinawiserv.dsp.base.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tangxiong on 2017/12/3.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterProxy(){

        org.springframework.web.filter.DelegatingFilterProxy proxy = new org.springframework.web.filter.DelegatingFilterProxy();
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(proxy);
        bean.addInitParameter("targetFilterLifecycle", "true");
        bean.addInitParameter("targetBeanName", "shiroFilter");
        bean.addUrlPatterns("/*");


        return bean;
    }
}
