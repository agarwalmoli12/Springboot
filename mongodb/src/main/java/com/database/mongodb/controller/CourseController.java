package com.database.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.entity.Course;
import com.database.mongodb.entity.User;
import com.database.mongodb.service.CourseService;
import com.database.mongodb.service.userService;

import org.springframework.http.HttpStatus;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseservice;
    @Autowired
    private userService userservice;

    @GetMapping("/home")
    public String home(){
        return "Welcome to home page";
    }

    @GetMapping("/course")
    public List<Course> getCourses(){
        return this.courseservice.getCourses();
    }

    @GetMapping("/course/{username}")
    public ResponseEntity<List<Course>> getCourse(@PathVariable String username){
        User user = userservice.findByUsername(username);
        List<Course> course = user.getCourse();
        if(course != null){
            return ResponseEntity.ok(course);
        }else{
            return (ResponseEntity<List<Course>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    

    @PostMapping("/course/{username}")
    public Course addCourse(@RequestBody Course course, @PathVariable String username){
        User user = userservice.findByUsername(username);
        user.getCourse().add(course);
        userservice.addUser(user);
        return this.courseservice.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseservice.updateCourse(course);
    }

    @DeleteMapping("/course/{courseID}")
    public Course deleteCourse(@PathVariable String courseID, @PathVariable String username){

        User user = userservice.findByUsername(username);
        user.getCourse().removeIf(c -> c.getId().equals(courseID));
        userservice.addUser(user);
        return courseservice.deleteCourse(courseID);
    }

}




    

