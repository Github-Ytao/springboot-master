package com.tao.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author YangTao
 * @date 2021-11-13 19:38
 */
@Slf4j
@SpringBootTest
class JdbcDBApplicationTest {

    @Autowired
    JdbcTemplate primaryJdbcTemplate;

    @Autowired
    JdbcTemplate secondaryJdbcTemplate;

    @BeforeEach
    void setUp() {
        primaryJdbcTemplate.update("delete from user");
        secondaryJdbcTemplate.update("delete from user");
    }

    @Test
    void contextLoads() {
        primaryJdbcTemplate.update("insert into user (id, username, age) values (?, ?, ?)", 1, "aaa", 20);
        primaryJdbcTemplate.update("insert into user (id, username, age) values (?, ?, ?)", 2, "bbb", 30);

        secondaryJdbcTemplate.update("insert into user (id, username, age) values (?, ?, ?)", 1, "ccc", 40);

        Assertions.assertEquals("2", primaryJdbcTemplate.queryForObject("select count(1) from user", String.class));

        Assertions.assertEquals("1", secondaryJdbcTemplate.queryForObject("select count(1) from user", String.class));
    }
}