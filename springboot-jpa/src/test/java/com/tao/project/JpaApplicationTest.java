package com.tao.project;

import com.tao.project.entity.User;
import com.tao.project.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 17:41
 */
@SpringBootTest
class JpaApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        userRepository.save(new User("AAA", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("BBB", "BBB", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("CCC", "CCC", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("DDD", "DDD", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("EEE", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("FFF", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("GGG", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("HHH", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("III", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("JJJ", "AAA", 1, 31, LocalDateTime.now()));
        userRepository.save(new User("KKK", "AAA", 1, 31, LocalDateTime.now()));
    }
}