package com.cognizant.EmployeeManagementSystem.service;

import com.cognizant.EmployeeManagementSystem.model.Employee;
import com.cognizant.EmployeeManagementSystem.model.Department;
import com.cognizant.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cognizant.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> getEmployeesByDepartment(String deptName, Pageable pageable) {
        return employeeRepository.findByDepartmentName(deptName, pageable);
    }

    public Employee saveEmployee(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                .orElse(null); 
            
            if (dept != null) {
                employee.setDepartment(dept);
            }
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}