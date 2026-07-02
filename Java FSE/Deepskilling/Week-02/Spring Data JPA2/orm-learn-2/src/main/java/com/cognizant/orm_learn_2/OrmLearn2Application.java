package com.cognizant.orm_learn_2;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn_2.model.Department;
import com.cognizant.orm_learn_2.model.Employee;
import com.cognizant.orm_learn_2.service.DepartmentService;
import com.cognizant.orm_learn_2.service.EmployeeService;
import com.cognizant.orm_learn_2.service.SkillService;

@SpringBootApplication
public class OrmLearn2Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn2Application.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearn2Application.class, args);
        
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetDepartment();
    }

    @Override
    public void run(String... args) throws Exception {
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1); 
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }
    
    private static void testAddEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setSalary(50000.0);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        
        employeeService.save(employee);
        LOGGER.debug("Employee:{}", employee);
    }
}