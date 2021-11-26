package com.tao.project.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YangTao
 * @date 2021-11-14 16:16
 */
@Service
public class UserService {

    private JdbcTemplate primaryJdbcTemplate;
    private JdbcTemplate secondaryJdbcTemplate;

    public UserService(JdbcTemplate primaryJdbcTemplate, JdbcTemplate secondaryJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
        this.secondaryJdbcTemplate = secondaryJdbcTemplate;
    }

    @Transactional
    public void tx() {
        primaryJdbcTemplate.update("update user set age = ? where username = ?", 31, "aaa");
        secondaryJdbcTemplate.update("update user set age = ? where username = ?", 31, "aaa");
    }

    @Transactional
    public void tx2() {
        primaryJdbcTemplate.update("update user set age = ? where username = ?", 40, "aaa");
        throw new RuntimeException();
    }
}
