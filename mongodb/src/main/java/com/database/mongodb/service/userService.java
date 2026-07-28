package com.database.mongodb.service;

import java.util.List;

import com.database.mongodb.entity.User;

public interface userService {
    List<User> getUsers();
    User addUser(User user);
    void deleteuser(String id);
    User findbyusername(String username);
}
