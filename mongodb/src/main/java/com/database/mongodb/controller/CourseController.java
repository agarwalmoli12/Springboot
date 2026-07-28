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
import com.database.mongodb.service.CourseService;
import org.springframework.http.HttpStatus;

@RestController
public class CourseController {

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

    @GetMapping("/course/{courseID}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseID){
        Optional<Course> course= course.findById(courseID);
        if(course.isPresent()){
            return ResponseEntity.ok(course.get());
        }else{
            return (ResponseEntity<Course>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course){
        return this.courseservice.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseservice.updateCourse(course);
    }

    @DeleteMapping("/course/{courseID}")
    public Course deleteCourse(@PathVariable Long courseID){
        return this.courseservice.deleteCourse(courseID);
    }

}




    

