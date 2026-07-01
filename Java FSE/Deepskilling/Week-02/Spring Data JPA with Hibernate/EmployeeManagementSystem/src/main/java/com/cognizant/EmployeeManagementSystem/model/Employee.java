package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    // Use JsonIgnoreProperties to avoid circularity while still keeping the department info
    @JsonIgnoreProperties("employees") 
    private Department department;
}