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

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public String updateCourse(long courseId, Course newCourseInfo) {
        for(Course c : list){
            if(c.getId() == courseId){
                c.setId(newCourseInfo.getId());
                c.setTitle(newCourseInfo.getTitle());
                c.setDescription(newCourseInfo.getDescription());
                break;
            }
        }
        return "Course Updated Successfully";
    }

    @Override
    public Course deleteCourse(long courseId) {
        Course deleteInfo= null;
        for(Course c: list){
            if(c.getId() == courseId){
                deleteInfo= c;
                list.remove(c);
                break;
            }
        }
        return deleteInfo;
    }

}
