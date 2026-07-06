package com.cognizant.skill_spring.service;

import com.cognizant.skill_spring.dao.EmployeeDao;
import com.cognizant.skill_spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service 
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional 
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}