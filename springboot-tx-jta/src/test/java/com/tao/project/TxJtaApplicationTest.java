package com.tao.project;

import com.tao.project.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author YangTao
 * @date 2021-11-14 16:26
 */
@SpringBootTest
class TxJtaApplicationTest {

    @Autowired
    JdbcTemplate primaryJdbcTemplate;
    @Autowired
    JdbcTemplate secondaryJdbcTemplate;

    @Autowired
    UserService userService;

    @Test
    public void test() {
        userService.tx();
        Assertions.assertEquals(31, primaryJdbcTemplate.queryForObject("select age from user where username = ?", Integer.class, "aaa"));
        Assertions.assertEquals(31, secondaryJdbcTemplate.queryForObject("select age from user where username = ?", Integer.class, "aaa"));
    }

    @Test
    public void test2() {
        try {
            userService.tx2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assertions.assertEquals(31, primaryJdbcTemplate.queryForObject("select age from user where username = ?", Integer.class, "aaa"));
            Assertions.assertEquals(31, secondaryJdbcTemplate.queryForObject("select age from user where username = ?", Integer.class, "aaa"));
        }
    }
}