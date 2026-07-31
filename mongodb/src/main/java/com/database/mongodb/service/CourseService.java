package com.database.mongodb.service;

import java.util.List;

import com.database.mongodb.entity.Course;

public interface CourseService {
    List<Course> getCourses();
    Course getCourse(String courseID);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course deleteCourse(String courseID);
    
    
} 
