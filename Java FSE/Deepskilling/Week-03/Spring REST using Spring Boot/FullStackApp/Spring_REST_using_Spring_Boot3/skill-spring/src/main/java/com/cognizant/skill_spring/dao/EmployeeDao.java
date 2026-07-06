package com.cognizant.skill_spring.dao;

import com.cognizant.skill_spring.model.Employee;
import java.util.ArrayList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml")) {
            @SuppressWarnings("unchecked")
            ArrayList<Employee> list = (ArrayList<Employee>) context.getBean("employeeList");
            EMPLOYEE_LIST = list;
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}

