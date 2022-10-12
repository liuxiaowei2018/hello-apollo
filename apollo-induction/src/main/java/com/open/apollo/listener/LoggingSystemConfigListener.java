package com.open.apollo.listener;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 14:59
 * @Description 自定义 Apollo 配置监听器
 * 监听 logging.level 配置项的变更，修改 Logger 的日志级别
 */
@Component
public class LoggingSystemConfigListener {

    /**
     * 日志配置项的前缀
     */
    private static final String LOGGER_TAG = "logging.level.";

    /**
     * loggingSystem 属性，是 Spring Boot Logger 日志系统，通过 LoggingSystem 可以进行日志级别的修改
     */
    @Resource
    private LoggingSystem loggingSystem;

    /**
     * config 属性，是 Apollo Config 对象，通过它获取本地缓存的 Apollo 配置
     */
    @ApolloConfig
    private Config config;

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) throws Exception {
        // <X> 获得 Apollo 所有配置项
        Set<String> keys = config.getPropertyNames();
        // <Y> 遍历配置集的每个配置项，判断是否是 logging.level 配置项
        for (String key : keys) {
            // 如果是 logging.level 配置项，则设置其对应的日志级别
            if (key.startsWith(LOGGER_TAG)) {
                // 获得日志级别
                String strLevel = config.getProperty(key, "info");
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                // 设置日志级别到 LoggingSystem 中
                loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
            }
        }
    }
}
