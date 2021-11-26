package com.tao.project;

import com.tao.project.entity.User;
import com.tao.project.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YangTao
 * @date 2021-11-13 22:45
 */
@SpringBootTest
class TxApplicationTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Transactional
    @Test
    void contextLoads() {
        userRepository.save(new User("aaa", 20));
        userRepository.save(new User("bbb", 30));
        userRepository.save(new User("ccc", 40));
        userRepository.save(new User("ddd", 50));
        userRepository.save(new User("eee", 60));
        userRepository.save(new User("fff", 70));
        userRepository.save(new User("ggg", 80));
        userRepository.save(new User("hhh", 90));
        userRepository.save(new User("iii", 100));
        userRepository.save(new User("jjj", 110));
        userRepository.save(new User("kkk", 120));
    }
}