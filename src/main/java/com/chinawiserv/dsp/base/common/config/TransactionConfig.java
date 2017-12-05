package com.chinawiserv.dsp.base.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
@Configuration
@ConditionalOnProperty(prefix = "transaction", value = {"open"}, havingValue = "true", matchIfMissing = false)
@ConditionalOnResource(resources = "${config.location:classpath:}spring/spring-transaction.xml")
@ImportResource(locations = {"${config.location:classpath:}spring/spring-transaction.xml"})
public class TransactionConfig {

}
