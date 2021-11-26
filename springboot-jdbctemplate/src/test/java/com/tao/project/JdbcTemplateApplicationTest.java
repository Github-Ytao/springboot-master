package com.tao.project;

import com.tao.project.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangTao
 * @date 2021-11-13 16:59
 */
@SpringBootTest
class JdbcTemplateApplicationTest {

    @Autowired
    IUserService userService;

    @BeforeEach
    void setUp() {
        userService.deleteAllUsers();
    }

    @Test
    void contextLoads() {

    }
}
