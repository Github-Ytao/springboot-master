package com.tao.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author YangTao
 * @date 2021-11-14 18:37
 */
@SpringBootApplication
public class ThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

    @Controller
    static class ThymeleafController {

        @GetMapping("/")
        public String index(ModelMap modelMap) {
            return "index";
        }
    }
}
