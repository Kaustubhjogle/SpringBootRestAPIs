package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    @Autowired
    private CourseDao courseDao;


    //Constructor
    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1,"Java","Java SpringBoot Course"));
        list.add(new Course(2,"React","React Typescript Course"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.getById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public String updateCourse(Course newCourseInfo) {
        courseDao.save(newCourseInfo);
        return "Course Updated Successfully";
    }

    @Override
    public Course deleteCourse(long courseId) {
        Course entity = courseDao.getOne(courseId);
        courseDao.delete(entity);
        return entity;
    }

}
