package com.cognizant.skill_spring.controller;

import com.cognizant.skill_spring.model.Employee;
import com.cognizant.skill_spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; 

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); 
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .map(existingEmployee -> {
                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setDepartment(updatedEmployee.getDepartment());
                    return existingEmployee;
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}