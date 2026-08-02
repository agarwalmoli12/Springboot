package com.database.mongodb.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.User;
import com.database.mongodb.repository.userrepository;
import com.database.mongodb.service.userService;


@RestController
public class UserController {
    @Autowired
    private userService service;
    @Autowired
    private userrepository repository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }
    @GetMapping("/users/{username}")
    public User saveEntry(@PathVariable String username){
        return service.findByUsername(username);
    }


    

    @DeleteMapping("/users/{id}")
    public void deleteuser(@PathVariable String id){
        service.deleteuser(id);
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteById(){
    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    repository.deleteByUsername(authentication.getName());
    return ResponseEntity.ok().build();
    }

    @PutMapping("/users")
    public ResponseEntity<User> findByUsername(@RequestBody User user , @PathVariable String username){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); 
        User userindb = service.findByUsername(username);
        userindb.setUsername(user.getUsername());
        userindb.setPassword(user.getPassword());
        service.saveEntry(userindb);
        return ResponseEntity.ok(userindb);
        }
        }

        
    




