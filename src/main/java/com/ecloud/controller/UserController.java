package com.ecloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecloud.entity.User;
import com.ecloud.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "getUser")
    @ResponseBody
    public User GetUser(@RequestBody String param){
        JSONObject json = JSON.parseObject(param);
        return userService.getUser(Integer.parseInt(json.getString("id")));
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
    public void deleteUser(@RequestBody String param){
        JSONObject json = JSON.parseObject(param);
        userService.deleteUser(Integer.parseInt(json.getString("id")));
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public void test(){
        User user = null;
        user.setId(1);
        logger.info("123");
    }

}