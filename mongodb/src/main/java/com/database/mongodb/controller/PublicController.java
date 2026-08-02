package com.database.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.User;
import com.database.mongodb.service.userService;

@RestController

public class PublicController {
    @Autowired
    private userService service;

    @PostMapping("/public")
    public User addUser(@RequestBody User user){     // agar multiple user ek sath add krne ho toh @RequestBody List<User> user
        return service.saveEntry(user);
    }

}
