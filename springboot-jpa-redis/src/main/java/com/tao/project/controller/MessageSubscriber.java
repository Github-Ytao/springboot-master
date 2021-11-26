package com.tao.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author YangTao
 * @date 2021-11-14 18:26
 *
 * 订阅消息
 */
@Slf4j
@Service
public class MessageSubscriber {

    private static final String CHANNEL = "tao";

    public MessageSubscriber(RedisTemplate redisTemplate) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                // 收到消息的处理逻辑
                log.info("Receive message : " + message);
            }
        }, CHANNEL.getBytes(StandardCharsets.UTF_8));

    }
}
