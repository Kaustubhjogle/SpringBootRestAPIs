package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.exceptions.CourseAlreadyPresentException;
import com.springrest.springrest.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Boolean entity = courseDao.existsById(course.getId());
        if(entity){
            throw new CourseAlreadyPresentException("Course Already present with ID: " + course.getId());
        }else {
            return courseDao.save(course);
        }
    }

    @Override
    public String updateCourse(Course newCourseInfo) {
        courseDao.save(newCourseInfo);
        return "Course Updated Successfully";
    }

    @Override
    public Course deleteCourse(long courseId) {
        Optional<Course> entity = courseDao.findById(courseId);
        if(entity.isPresent()){
            courseDao.delete(entity.get());
            return entity.get();
        }else{
            throw new CourseNotFoundException("No Course Found with ID: "+ courseId);
        }

    }

}
