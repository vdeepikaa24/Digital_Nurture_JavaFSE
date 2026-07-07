package com.cognizant.spring_rest_service.service;

import com.cognizant.spring_rest_service.dao.EmployeeDao;
import com.cognizant.spring_rest_service.exception.EmployeeNotFoundException;
import com.cognizant.spring_rest_service.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }
}
