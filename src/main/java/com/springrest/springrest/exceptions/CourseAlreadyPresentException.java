package com.springrest.springrest.exceptions;

public class CourseAlreadyPresentException extends RuntimeException{
    public CourseAlreadyPresentException(String message) {
        super(message);
    }
}
