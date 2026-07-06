package com.cognizant.skill_spring.controller;

import com.cognizant.skill_spring.model.Department;
import com.cognizant.skill_spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        // Logging as required by the problem statement
        System.out.println("Department REST service called.");
        return departmentService.getAllDepartments();
    }
}