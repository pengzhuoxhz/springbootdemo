package com.ecloud.service;

import com.ecloud.entity.User;

public interface IUserService {
    User getUser(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
