package com.cognizant.EmployeeManagementSystem.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeSummary {
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getEmployeeInfo(); 
}