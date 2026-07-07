package com.cognizant.spring_rest_service.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
