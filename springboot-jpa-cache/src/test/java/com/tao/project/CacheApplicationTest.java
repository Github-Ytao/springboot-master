package com.tao.project;

import com.tao.project.entity.User;
import com.tao.project.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

/**
 * @author YangTao
 * @date 2021-11-14 17:22
 */
@SpringBootTest
class CacheApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CacheManager cacheManager;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        System.out.println("CacheManager Type: " + cacheManager);

        userRepository.save(new User("AAA",30));

        System.out.println("第一次查询：" + userRepository.findByUsername("AAA").getAge());
        System.out.println("第二次查询：" + userRepository.findByUsername("AAA").getAge());
    }
}