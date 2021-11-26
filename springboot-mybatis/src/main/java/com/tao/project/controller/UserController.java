package com.tao.project.controller;

import com.tao.project.entity.User;
import com.tao.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 18:45
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
