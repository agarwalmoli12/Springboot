package com.database.mongodb.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
    public User saveNewuser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User"));
        return repository.save(user);
    }

    
}
