package com.tao.project.service;

import com.tao.project.entity.User;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 16:37
 */
public interface IUserService {
    /**
     * 新增一个用户
     *
     * @param username
     * @param age
     */
    int create(String username, Integer age);

    /**
     * 根据name查询用户
     *
     * @param username
     * @return
     */
    List<User> getByName(String username);

    /**
     * 根据name删除用户
     *
     * @param username
     */
    int deleteByName(String username);

    /**
     * 获取用户总量
     */
    int getAllUsers();

    /**
     * 删除所有用户
     */
    int deleteAllUsers();
}
