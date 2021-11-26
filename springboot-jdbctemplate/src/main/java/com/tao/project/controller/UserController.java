package com.tao.project.controller;

import com.tao.project.entity.User;
import com.tao.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 17:08
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public int create(@RequestBody User user) {
        return userService.create(user.getUsername(), user.getAge());
    }

    @GetMapping("/user/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @DeleteMapping("/user/{name}")
    public int deleteByName(@PathVariable String name) {
        return userService.deleteByName(name);
    }

    @GetMapping("/user/count")
    public int getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/all")
    public int deleteAllUsers() {
        return userService.deleteAllUsers();
    }
}
