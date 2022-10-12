package com.open.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:40
 * @Description
 */
// @NacosPropertySource(dataId = "example", type = ConfigType.YAML)
@SpringBootApplication
public class ApolloInductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloInductionApplication.class, args);
    }
}
