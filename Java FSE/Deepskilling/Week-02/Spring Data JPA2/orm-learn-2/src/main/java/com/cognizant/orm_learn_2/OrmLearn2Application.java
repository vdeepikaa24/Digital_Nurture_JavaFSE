package com.cognizant.orm_learn_2;

import com.cognizant.orm_learn_2.repository.CountryRepository;
import com.cognizant.orm_learn_2.repository.StockRepository;
import com.cognizant.orm_learn_2.repository.EmployeeRepository;
import com.cognizant.orm_learn_2.repository.DepartmentRepository;
import com.cognizant.orm_learn_2.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class OrmLearn2Application implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- All matching 'ou' ---");
        countryRepository.findByNameContaining("ou").forEach(System.out::println);

        System.out.println("--- Sorted 'ou' ---");
        countryRepository.findByNameContainingOrderByNameAsc("ou").forEach(System.out::println);

        System.out.println("--- Starts with 'Z' ---");
        countryRepository.findByNameStartingWith("Z").forEach(System.out::println);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2019-09-01");
        Date endDate = sdf.parse("2019-09-30");

        System.out.println("--- Facebook Stocks Sept 2019 ---");
        stockRepository.findByCodeAndDateBetween("FB", startDate, endDate).forEach(System.out::println);

        System.out.println("--- Google Stocks > 1250 ---");
        stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250.0).forEach(System.out::println);

        System.out.println("--- Top 3 Highest Volume ---");
        stockRepository.findTop3ByOrderByVolumeDesc().forEach(System.out::println);

        System.out.println("--- Lowest 3 Netflix Stocks ---");
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX").forEach(System.out::println);

        System.out.println("--- Payroll Module Ready ---");
        System.out.println("Employee count: " + employeeRepository.count());
        System.out.println("Department count: " + departmentRepository.count());
        System.out.println("Skill count: " + skillRepository.count());
    }
}