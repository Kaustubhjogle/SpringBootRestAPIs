package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    //Constructor
    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1,"Java","Java SpringBoot Course"));
        list.add(new Course(2,"React","React Typescript Course"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course courseValue = null;
        for(Course c: list){
            if(courseId == c.getId()){
                courseValue =c ;
                break;
            }
        }
        return courseValue;
    }
}
