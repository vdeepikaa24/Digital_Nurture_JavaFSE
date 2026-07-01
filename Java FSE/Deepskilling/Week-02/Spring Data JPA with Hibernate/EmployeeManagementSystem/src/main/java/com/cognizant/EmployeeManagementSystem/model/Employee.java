package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email") 
})
@Data 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) 
@DynamicUpdate 
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}