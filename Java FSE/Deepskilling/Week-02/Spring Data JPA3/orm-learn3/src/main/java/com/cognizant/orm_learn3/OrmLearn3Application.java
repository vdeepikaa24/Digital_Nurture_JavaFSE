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

    @Autowired
    private com.cognizant.orm_learn3.service.AttemptService attemptService;

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAttemptDetails();
    }

    private void testGetAverageSalary() {
        int departmentId = 1;
        double averageSalary = employeeService.getAverageSalary(departmentId);
        LOGGER.info("Average salary for department {}: {}", departmentId, averageSalary);
    }

    private void testGetAttemptDetails() {
        // Replace these with ids that exist in your DB (from generated SQL / insert statements)
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

        if (attempt.getAttemptQuestions() == null) {
            LOGGER.info("No questions found for this attempt");
            return;
        }

        for (com.cognizant.orm_learn3.model.AttemptQuestion aq : attempt.getAttemptQuestions()) {
            com.cognizant.orm_learn3.model.Question q = aq.getQuestion();
            LOGGER.info("Question: {} | Score: {}", q.getText(), q.getScore());

            if (aq.getAttemptOptions() == null) continue;

            for (com.cognizant.orm_learn3.model.AttemptOption ao : aq.getAttemptOptions()) {
                com.cognizant.orm_learn3.model.Option opt = ao.getOption();
                double qScore = (q != null) ? q.getScore() : 0.0;

                // Requirement: second column in each option denotes score from question table
                // and last column denotes answer selected by user
                LOGGER.info("Option: {} | Score: {} | Selected: {} | Correct: {}",
                        opt != null ? opt.getText() : null,
                        qScore,
                        ao.isSelected(),
                        opt != null && opt.isCorrect());
            }
        }

        LOGGER.info("Attempt details fetch End");
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        employeeService.getAllPermanentEmployees().forEach(e -> {
            LOGGER.debug("Employee: {}, Dept: {}, Skills: {}", e.getName(), e.getDepartment().getName(), e.getSkillList());
        });
        LOGGER.info("End");
    }

}