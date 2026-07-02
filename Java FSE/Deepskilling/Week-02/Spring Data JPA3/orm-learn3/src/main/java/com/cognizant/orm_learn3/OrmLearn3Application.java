package com.cognizant.orm_learn3;

import com.cognizant.orm_learn3.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearn3Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn3Application.class);
    
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        employeeService.getAllPermanentEmployees().forEach(e -> {
            LOGGER.debug("Employee: {}, Dept: {}, Skills: {}", e.getName(), e.getDepartment().getName(), e.getSkillList());
        });
        LOGGER.info("End");
    }
}