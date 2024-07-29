package com.springrest.springrest.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String errorDescription;
    private String errorMessage;

    public ErrorDetails(String errorMessage, String errorDescription, Date timestamp) {
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
        this.timestamp = timestamp;
    }
}
