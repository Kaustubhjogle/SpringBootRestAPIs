package com.springrest.springrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(CourseAlreadyPresentException.class)
    public ResponseEntity<ErrorDetails> handleCourseAlreadyPresentException(CourseAlreadyPresentException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleCourseNotFoundException(CourseNotFoundException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),request.getDescription(false), new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
