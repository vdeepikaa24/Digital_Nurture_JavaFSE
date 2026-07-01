package com.cognizant.EmployeeManagementSystem.controller;

import com.cognizant.EmployeeManagementSystem.dto.EmployeeSummary;
import com.cognizant.EmployeeManagementSystem.dto.EmployeeNameProjection;
import com.cognizant.EmployeeManagementSystem.model.Employee;
import com.cognizant.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cognizant.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sort) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return employeeService.getAllEmployees(pageable);
    }

    
    @GetMapping("/projections/department")
    public List<EmployeeNameProjection> getEmployeeNamesByDept(@RequestParam String name) {
        return employeeRepository.findByDepartmentName(name);
    }
    @GetMapping("/projections/summary")
    public List<EmployeeSummary> getEmployeeSummaries() {
        return employeeRepository.findAllSummaries();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}