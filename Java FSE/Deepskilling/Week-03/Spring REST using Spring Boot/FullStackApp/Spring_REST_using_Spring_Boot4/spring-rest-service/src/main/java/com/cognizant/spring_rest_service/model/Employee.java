package com.cognizant.spring_rest_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class Employee {

    private Integer id;

    @NotNull(message = "Employee name must not be null")
    @NotBlank(message = "Employee name must not be blank")
    @Size(min = 1, max = 30, message = "Employee name must be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Employee date of birth must not be null")
    @Past(message = "Employee date of birth must be in the past")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull(message = "Employee salary must not be null")
    private Double salary;

    @Valid
    @NotNull(message = "Employee department must not be null")
    private Department department;

    @Valid
    @NotNull(message = "Employee skills must not be null")
    private List<Skill> skills;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
