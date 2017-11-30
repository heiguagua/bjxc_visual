package com.chinawiserv.dsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ImportResource(locations = { "${config.location:classpath:}spring/spring-mvc.xml" })
public class DirStart extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(DirStart.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DirStart.class, args);
    }
}
