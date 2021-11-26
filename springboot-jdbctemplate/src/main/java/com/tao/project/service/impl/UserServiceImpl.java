package com.tao.project.service.impl;

import com.tao.project.entity.User;
import com.tao.project.service.IUserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 16:37
 */
@Service
public class UserServiceImpl implements IUserService {

    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String username, Integer age) {
        return jdbcTemplate.update("insert into user (username, age) values (?, ?)", username, age);
    }

    @Override
    public List<User> getByName(String username) {
        List<User> users = jdbcTemplate.query("select username, age from user where username = ?", (resultSet, i) -> {
            User user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }, username);
        return users;
    }

    @Override
    public int deleteByName(String username) {
        return jdbcTemplate.update("delete from user where username = ?", username);
    }

    @Override
    public int getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from user");
    }
}
