package com.tao.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YangTao
 * @date 2021-11-13 04:45
 */
@Data
@Component
@ConfigurationProperties(prefix = "com.tao")
public class MyConfig {
    private String username;
}
