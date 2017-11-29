package com.chinawiserv.dsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ImportResource(locations = { "${config.location:classpath:}spring/spring-mvc.xml" })
public class DirStart {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DirStart.class, args);
    }
}
