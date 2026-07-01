package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Many Employees belong to one Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}