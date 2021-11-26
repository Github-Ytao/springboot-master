package com.tao.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author YangTao
 * @date 2021-11-14 21:25
 */
@EnableAsync
@SpringBootApplication
public class AsyncPoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncPoolApplication.class, args);
    }
}
