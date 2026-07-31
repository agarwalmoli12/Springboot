package com.database.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongodb.entity.User;
import com.database.mongodb.repository.userrepository;
@Service
public class userServiceImpl implements userService {
    @Autowired
    private userrepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    public User addUser(User user){
        return repository.save(user);
    }

    public void deleteuser(String id){
        repository.deleteById(id);
    }
    
    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    
}
