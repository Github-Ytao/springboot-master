package com.tao.project.controller;

import com.tao.project.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YangTao
 * @date 2021-11-13 13:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    @GetMapping("/list")
    public List<User> list() {
        List<User> users = new ArrayList<>(userMap.values());
        return users;
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userMap.get(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody User user) {
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id, u);
        return "success";
    }

    @PutMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userMap.remove(id);
        return "success";
    }
}
