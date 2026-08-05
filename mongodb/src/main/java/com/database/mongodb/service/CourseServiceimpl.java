package com.database.mongodb.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.mongodb.entity.Course;
import com.database.mongodb.entity.User;
import com.database.mongodb.repository.courserepository;
@Service
public class CourseServiceimpl implements CourseService{

    @Autowired
    private courserepository repository;

    @Autowired
    private userService userservice;
    public CourseServiceimpl(courserepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }

    
    
    public Course addCourse(Course course){
        return repository.save(course);


        
    }
    @Transactional
    public void saveCourse(Course course, String username) {
        User user= userservice.findByUsername(username);
        if(user!=null){
            course.setUser(user);
            repository.save(course);
        }
        
    }

    @Transactional
    public Course deleteCourse(String courseID) {
    Course course = repository.findById(courseID).orElse(null);
    if (course != null) {
        repository.delete(course);
    }

    return course;
}


    public Course updateCourse(Course newcourse){
        Course oldcourse= repository.findById(newcourse.getCourseID()).orElse(null);
        if(oldcourse!=null){
            oldcourse.setName(newcourse.getName()!=null && !newcourse.getName().equals("")?newcourse.getName():oldcourse.getName());
            oldcourse.setDescription(newcourse.getDescription()!=null && !newcourse.getDescription().equals("")?newcourse.getDescription():oldcourse.getDescription());
            repository.save(oldcourse);
            return oldcourse;
        }
        return oldcourse;
    }


    
    


    @Override
    public Course getCourse(String courseID) {
        return repository.findById(courseID).orElse(null);
    }


   
}

