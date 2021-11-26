package com.tao.project.service.impl;

import com.tao.project.entity.User;
import com.tao.project.mapper.UserMapper;
import com.tao.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 18:48
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }
}
