package com.database.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.database.mongodb.entity.Course;
import com.database.mongodb.repository.courserepository;
@Service
public class CourseServiceimpl implements CourseService{

    @Autowired
    private courserepository repository;
    public CourseServiceimpl(courserepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }

    
    public Course addCourse(Course course){
        repository.save(course);


        return course;
    }
}

