package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = ?1")
})
// Corrected: Extend Auditable here
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Corrected: Default constructor
    public Employee() {
        super();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}