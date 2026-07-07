package com.cognizant.spring_rest_service.controller;

import com.cognizant.spring_rest_service.exception.EmployeeNotFoundException;
import com.cognizant.spring_rest_service.model.Employee;
import com.cognizant.spring_rest_service.service.EmployeeService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends ResponseEntityExceptionHandler {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        employeeService.updateEmployee(employee);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                 HttpHeaders headers,
                                                                 HttpStatusCode status,
                                                                 WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", "Bad Request");

        if (ex.getCause() instanceof InvalidFormatException) {
            Throwable cause = ex.getCause() == null ? ex : ex.getCause();
            for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
                body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
            }
        } else {
            body.put("message", "Malformed JSON request");
        }

        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", 404);
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpHeaders.EMPTY, HttpStatusCode.valueOf(404));
    }
}
