package com.open.apollo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:44
 * @Description
 * ValueCommandLineRunner 类中，测试使用 @Value 注解，读取 order 配置项的效果
 */
@Slf4j
@Component
public class ValueCommandLineRunner implements CommandLineRunner {

    @Value(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;

    @Value(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    @Override
    public void run(String... args) throws Exception {
        log.info("payTimeoutSeconds:" + payTimeoutSeconds);
        log.info("createFrequencySeconds:" + createFrequencySeconds);
    }
}
