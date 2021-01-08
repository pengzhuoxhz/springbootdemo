package com.ecloud.mapper;

import com.ecloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getUser(int id);
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
