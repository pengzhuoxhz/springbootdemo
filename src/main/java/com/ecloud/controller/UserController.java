package com.ecloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecloud.entity.User;
import com.ecloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "getUser")
    @ResponseBody
    public User GetUser(@RequestParam int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "updateUser")
    @ResponseBody
    public void updateUser(@RequestBody String param){
        JSONObject json = JSON.parseObject(param);
        User user = new User();
        user.setId(json.getIntValue("id"));
        user.setName(json.getString("name"));
        user.setAge(json.getIntValue("age"));
        userService.updateUser(user);
    }

    @RequestMapping(value = "addUser")
    @ResponseBody
    public void addUser(@RequestBody String param){
        JSONObject json = JSON.parseObject(param);
        User user = new User();
        user.setName(json.getString("name"));
        user.setAge(json.getIntValue("age"));
        userService.addUser(user);
    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/test")
    public String deleteUser(){
        return "user/user";
    }

}