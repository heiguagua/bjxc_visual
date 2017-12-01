package com.chinawiserv.dsp.dir.druid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

    @Bean
    public FilterRegistrationBean driudFilter() {

        final WebStatFilter webStatFilter = new WebStatFilter();
        final FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(webStatFilter);
        bean.addInitParameter("exclusions", "/druid*");

        return bean;
    }

    @Bean
    public ServletRegistrationBean druidServlet(@Value("${druid.username:admin}") String username, @Value("${druid.password:111111}") String password) {

        final StatViewServlet servlet = new StatViewServlet();
        final ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(servlet);
        bean.addUrlMappings("/druid/*");
        bean.addInitParameter("loginUsername", username);
        bean.addInitParameter("loginPassword", password);
        return bean;
    }

    // @Bean
    // public DruidStatInterceptor druidStatInterceptor() {
    // return new DruidStatInterceptor();
    // }
    //
    // @Bean
    // public JdkRegexpMethodPointcut pointcut() {
    //
    // final JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
    // pointcut.setPatterns("com.chinawiserv.govdata.service.*");
    // pointcut.setPatterns("com.chinawiserv.govdata.mapper.*");
    //
    // return pointcut;
    // }

    // @Bean
    // public BeanNameAutoProxyCreator proxyCreator() {
    //
    // final BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
    //
    // proxyCreator.setBeanNames(beanNames);
    //
    // return proxyCreator;
    // }
}
