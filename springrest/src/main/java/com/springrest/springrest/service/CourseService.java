package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {

    List<Course> getCourses();
    Course getcourse(Long courseID);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course deleteCourse(Long courseID);


}
