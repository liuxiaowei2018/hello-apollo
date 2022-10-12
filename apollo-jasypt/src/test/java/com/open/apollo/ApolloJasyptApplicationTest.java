package com.open.apollo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 15:12
 * @Description
 * issues: 集成Jasypt,Apollo自动配置刷新失效
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApolloJasyptApplicationTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void encode() {
        String applicationName = "demo-application";
        // MjSpP2aUOMe/W/OxoVh0IwcfkhBOfPEAG6DaVftfAGf0aWkHwDueHw==
        // 以 ENC(xxx) 格式在 apollo配置中心发布
        System.out.println(encryptor.encrypt(applicationName));
    }

    @Value("${spring.application.name}")
    private String applicationName;

    @Test
    public void print() {
        // demo-application 成功正确解密，符合预期
        System.out.println(applicationName);
    }

}