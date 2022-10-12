package com.open.apollo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:42
 * @Description
 * OrderPropertiesCommandLineRunner 类中，测试使用 @ConfigurationProperties 注解的 OrderProperties 配置类，读取 order 配置项
 */
@Slf4j
@Component
public class OrderPropertiesCommandLineRunner implements CommandLineRunner {

    @Autowired
    private OrderProperties orderProperties;

    @Override
    public void run(String... args) throws Exception {
        log.info("payTimeoutSeconds:" + orderProperties.getPayTimeoutSeconds());
        log.info("createFrequencySeconds:" + orderProperties.getCreateFrequencySeconds());
    }
}
