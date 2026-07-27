package com.database.mongodb.service;

import java.util.List;

import com.database.mongodb.entity.Course;

public interface CourseService {
    List<Course> getCourses();
    Course addCourse(Course course);
    
    
} 
