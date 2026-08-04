package com.database.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.User;
import com.database.mongodb.service.UserDetailsServiceImpl;
import com.database.mongodb.service.userService;
import com.database.mongodb.utils.Jwtutil;

@RestController

public class PublicController {
    @Autowired
    private userService service;

    @Autowired
    private AuthenticationManager authenticationmanager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private Jwtutil jwtutil;


    @PostMapping("/public")
    public User addUser(@RequestBody User user){     // agar multiple user ek sath add krne ho toh @RequestBody List<User> user
        return service.saveEntry(user);
    }
    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return service.saveEntry(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        try{
        authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
       UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
       String jwt = jwtutil.generateToken(userDetails);
       return ResponseEntity.ok(jwt);
    }
    
    catch(Exception e){
        throw new RuntimeException("Invalid username or password");
    }
        
    }

}
