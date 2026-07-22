package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;


@RestController
public class Mycontroller {
    @Autowired
    private CourseService courseservice;
    


    
    

    @GetMapping("/home")
    public String home() {
        return "This is home page";
    }


    @GetMapping("/courses")
    public List<Course> getcourses(){
        return this.courseservice.getCourses();
        
    }


    @GetMapping("/couses/{courseID}")
    public Course getcourse(@PathVariable String courseID){
        return this.courseservice.getcourse(Long.parseLong(courseID));
    }

    @PostMapping("/courses")
    public Course addcourse(@RequestBody Course course){
        return this.courseservice.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseservice.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public void deleteCourse(@PathVariable String courseID){
        this.courseservice.deleteCourse(Long.parseLong(courseID));
    }
        
}