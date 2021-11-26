package com.tao.project;

import com.tao.project.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProfileApplication.class, args);
    }

    @RestController("/hello")
    static class HelloController {

        @Autowired
        private MyConfig myConfig;

        @Value("${name:}")
        private String name;

        @GetMapping("/")
        public String index() {
            return name + " " + myConfig.getUsername();
        }
    }
}
