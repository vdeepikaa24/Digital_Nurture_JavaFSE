package com.cognizant.orm_learn3.service;

import com.cognizant.orm_learn3.model.Employee;
import com.cognizant.orm_learn3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}