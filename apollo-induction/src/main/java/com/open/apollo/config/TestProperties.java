package com.open.apollo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:51
 * @Description
 */
@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    /**
     * 测试属性
     */
    private String test;

}
