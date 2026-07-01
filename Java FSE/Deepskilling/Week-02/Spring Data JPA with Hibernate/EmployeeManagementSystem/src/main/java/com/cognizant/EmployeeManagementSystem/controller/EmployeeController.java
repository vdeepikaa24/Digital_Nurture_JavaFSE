package com.cognizant.EmployeeManagementSystem.controller;

import com.cognizant.EmployeeManagementSystem.model.Employee;
import com.cognizant.EmployeeManagementSystem.service.EmployeeService;
import com.cognizant.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository; // Directly accessing for demonstration

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/search/department")
    public List<Employee> getEmployeesByDepartment(@RequestParam String name) {
        return employeeRepository.findByDepartmentName(name);
    }

    @GetMapping("/search/email")
    public Employee getEmployeeByEmail(@RequestParam String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @GetMapping("/named/all")
    public List<Employee> getAllNamed() {
        return employeeRepository.findAllEmployees();
    }
}