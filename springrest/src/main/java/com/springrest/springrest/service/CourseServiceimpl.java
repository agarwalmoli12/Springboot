package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceimpl implements CourseService {
    List<Course> list;

    public CourseServiceimpl() {

        list = new ArrayList<>();
        list.add(new Course(145,"Java Course","This course contains basic of java"));
        list.add(new Course(146,"Spring Boot Course","This course contains basic of Spring Boot"));

        
    }

    @Override
    public List<Course> getCourses(){
        return list;
    }
    public Course getcourse(Long courseID){
        Course c = null;
        for(Course course:list){
            if(course.getId()==courseID){
                c=course;
                break;
            }
        }
        return c;
    }

}
