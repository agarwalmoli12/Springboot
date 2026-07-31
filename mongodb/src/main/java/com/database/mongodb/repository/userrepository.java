package com.database.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.database.mongodb.entity.User;

public interface userrepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    
}
