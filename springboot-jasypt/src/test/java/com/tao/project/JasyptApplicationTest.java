package com.tao.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangTao
 * @date 2021-11-13 05:06
 */
@Slf4j
@SpringBootTest
public class JasyptApplicationTest {

    @Value("${datasource.password:}")
    private String password;

    @Test
    void contextLoads() {
        log.info("datasource.password : {}", password);

    }
}
