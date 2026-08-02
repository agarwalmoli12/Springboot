package com.database.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.database.mongodb.entity.User;
import com.database.mongodb.service.userService;

public class AdminController {
    @Autowired
    private userService service;

    @GetMapping("/admin")
    public void getAllUsers(){
        List<User> all= service.getUsers();
        if(all.isEmpty()){
            System.out.println("No users found");
        } else {
            System.out.println(all);
        }
    }
}
    
    

