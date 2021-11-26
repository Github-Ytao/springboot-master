package com.tao.project.controller;

import com.tao.project.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YangTao
 * @date 2021-11-13 13:25
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private static Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/list")
    public List<User> list() {
        List<User> users = new ArrayList<>(userMap.values());
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userMap.get(id);
    }

    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "用户编号", required = true, example = "1")
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody User user) {
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @PutMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userMap.remove(id);
        return "success";
    }
}
