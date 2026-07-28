package com.database.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.User;
import com.database.mongodb.service.userService;


@RestController
public class UserController {
    @Autowired
    private userService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteuser(@PathVariable String id){
        service.deleteuser(id);
    }
    @PutMapping("/users")
    public ResponseEntity<User> findbyusername(@RequestBody User user){
        User userindb = service.findbyusername(user.getUsername());
        if(userindb !=null){
            userindb.setUsername(user.getUsername());
            userindb.setPassword(user.getPassword());
            service.addUser(userindb);
            return ResponseEntity.ok(userindb);
        }else{
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        
    }



}
