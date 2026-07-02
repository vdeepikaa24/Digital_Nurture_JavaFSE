package com.cognizant.orm_learn_2.service;

import com.cognizant.orm_learn_2.model.Employee;
import com.cognizant.orm_learn_2.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
public Employee get(int id) {
    LOGGER.info("Start");
    return employeeRepository.findById(id).orElse(null); 
}

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }
}