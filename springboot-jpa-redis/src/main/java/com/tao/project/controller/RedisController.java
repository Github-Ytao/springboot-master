package com.tao.project.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangTao
 * @date 2021-11-14 18:22
 */
@RestController
public class RedisController {

    private static final String CHANNEL = "tao";

    private RedisTemplate<String, String> redisTemplate;

    RedisController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/publish")
    public void publish(@RequestParam String message) {
        // 发布消息
        redisTemplate.convertAndSend(CHANNEL, message);
    }
}
