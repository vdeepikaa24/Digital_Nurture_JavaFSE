package com.cognizant.handson2;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    // Hibernate requires a no-argument (default) constructor
    public Employee() {}

    // Constructor to easily create new Employee objects
    public Employee(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }

    // Getters and Setters are required for Hibernate to access the private fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}