package com.database.mongodb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.database.mongodb.entity.Course;

public interface courserepository extends MongoRepository <Course, String>{



}
