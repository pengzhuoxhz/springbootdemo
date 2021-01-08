package com.ecloud.service.impl;

import com.ecloud.entity.User;
import com.ecloud.mapper.UserMapper;
import com.ecloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
        int id = user.getId();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
