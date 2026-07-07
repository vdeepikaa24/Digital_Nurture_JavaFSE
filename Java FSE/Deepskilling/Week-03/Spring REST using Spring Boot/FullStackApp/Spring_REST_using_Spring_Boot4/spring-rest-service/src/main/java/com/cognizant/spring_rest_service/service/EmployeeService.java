package com.cognizant.spring_rest_service.service;

import com.cognizant.spring_rest_service.exception.EmployeeNotFoundException;
import com.cognizant.spring_rest_service.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John");
        employee.setSalary(50000.0);
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> existingEmployee = employees.stream()
                .filter(e -> e.getId() != null && e.getId().equals(employee.getId()))
                .findFirst();

        if (existingEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
        }

        Employee current = existingEmployee.get();
        current.setName(employee.getName());
        current.setDateOfBirth(employee.getDateOfBirth());
        current.setSalary(employee.getSalary());
        current.setDepartment(employee.getDepartment());
        current.setSkills(employee.getSkills());
    }
}
