package com.cognizant.skill_spring.dao;

import com.cognizant.skill_spring.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import java.util.List;

@Repository
public class EmployeeDao {
    
    private static List<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(@Qualifier("employeeList") List<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}