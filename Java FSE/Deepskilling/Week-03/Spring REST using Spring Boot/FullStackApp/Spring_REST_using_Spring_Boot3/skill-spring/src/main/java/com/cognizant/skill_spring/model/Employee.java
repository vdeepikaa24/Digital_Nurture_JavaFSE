package com.cognizant.skill_spring.model;

public class Employee {
    private int id;
    private String name;
    private Department department; 

    public Employee() {
        super();
    }

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }

    public Department getDepartment() { 
        return department; 
    }
    
    public void setDepartment(Department department) { 
        this.department = department; 
    }
}