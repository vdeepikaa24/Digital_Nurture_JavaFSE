package com.cognizant.orm_learn3;

import com.cognizant.orm_learn3.model.Employee; // Ensure this is imported
import com.cognizant.orm_learn3.service.EmployeeService;
import com.cognizant.orm_learn3.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class OrmLearn3Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn3Application.class);
    
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAttemptDetails();
        testGetAllEmployeesNative(); // Added call for Hands-on 5
    }

    // Hands-on 5: Native Query Test Method
    private void testGetAllEmployeesNative() {
        LOGGER.info("Starting Native Query Test...");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        for (Employee e : employees) {
            LOGGER.info("Employee: {}", e.getName());
        }
        LOGGER.info("End of Native Query Test.");
    }

    private void testGetAverageSalary() {
        int departmentId = 1;
        double averageSalary = employeeService.getAverageSalary(departmentId);
        LOGGER.info("Average salary for department {}: {}", departmentId, averageSalary);
    }

    private void testGetAttemptDetails() {
        int userId = 1;
        int attemptId = 1;
        LOGGER.info("Attempt details fetch Start");

        com.cognizant.orm_learn3.model.Attempt attempt = attemptService.getAttempt(userId, attemptId);
        if (attempt == null) {
            LOGGER.info("No attempt found for userId={}, attemptId={}", userId, attemptId);
            return;
        }

        LOGGER.info("Username: {}", attempt.getUser().getName());
        LOGGER.info("Attempted Date: {}", attempt.getDate());

        if (attempt.getAttemptQuestions() != null) {
            for (com.cognizant.orm_learn3.model.AttemptQuestion aq : attempt.getAttemptQuestions()) {
                com.cognizant.orm_learn3.model.Question q = aq.getQuestion();
                LOGGER.info("Question: {} | Score: {}", q.getText(), q.getScore());

                if (aq.getAttemptOptions() == null) continue;

                for (com.cognizant.orm_learn3.model.AttemptOption ao : aq.getAttemptOptions()) {
                    com.cognizant.orm_learn3.model.Option opt = ao.getOption();
                    LOGGER.info("Option: {} | Score: {} | Selected: {} | Correct: {}",
                            opt != null ? opt.getText() : null,
                            q.getScore(),
                            ao.isSelected(),
                            opt != null && opt.isCorrect());
                }
            }
        }
        LOGGER.info("Attempt details fetch End");
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        employeeService.getAllPermanentEmployees().forEach(e -> {
            LOGGER.info("Employee: {}, Dept: {}, Skills: {}", e.getName(), e.getDepartment().getName(), e.getSkillList());
        });
        LOGGER.info("End");
    }
}