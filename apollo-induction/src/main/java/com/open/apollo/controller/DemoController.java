package com.open.apollo.controller;

import com.open.apollo.config.TestProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:52
 * @Description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${test.test}")
    private String test;

    /**
     * 测试 @Value 注解的属性的动刷新配置的功能
     * [自动刷新配置成功]
     * @return java.lang.String
     * @date 2022/10/12 14:52
     */
    @GetMapping("/test")
    public String test() {
        return test;
    }

    @Autowired
    private TestProperties testProperties;

    /**
     * 测试 @ConfigurationProperties 注解的 TestProperties 配置类的动刷新配置的功能
     * [自动刷新配置失败]
     * @return com.open.apollo.config.TestProperties
     * @date 2022/10/12 14:52
     */
    @GetMapping("/test_properties")
    public TestProperties testProperties() {
        return testProperties;
        // 目前 Apollo 暂时未提供 @ConfigurationProperties 注解的配置类的自动刷新配置的功能，并且在纯 Spring Boot 项目中，没有太好的实现自动刷新配置的方式，具体可见 issues#1657 讨论。
        // 针对 Spring Cloud 项目，可以参考 issue#2846 讨论，基于 EnvironmentChangeEvent 或 RefreshScope。
        // 相关代码实现，可以参考 apollo-use-cases 项目中的 ZuulPropertiesRefresher.java 和 apollo-demo 项目中的 SampleRedisConfig.java 以及 SpringBootApolloRefreshConfig.java。
    }


    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/logger")
    public void logger() {
        // 如果 DemoController 对应的 Logger 日志级别是 DEBUG 以上，则无法打印出日志
        logger.debug("[logger][测试一下]");
    }

}
