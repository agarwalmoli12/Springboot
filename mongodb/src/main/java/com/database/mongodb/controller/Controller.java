package com.database.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.Course;
import com.database.mongodb.service.CourseService;

@RestController
public class Controller {

    @Autowired
    private CourseService courseservice;
    

    @GetMapping("/home")
    public String home(){
        return "Welcome to home page";
    }

    @GetMapping("/course")
    public List<Course> getCourses(){
        return this.courseservice.getCourses();
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course){
        return this.courseservice.addCourse(course);
    }



    
}
