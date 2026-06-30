package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "co_code")
    private String coCode;
    
    @Column(name = "co_name")
    private String coName;

    // 1. No-argument constructor (Required by JPA)
    public Country() {
        super();
    }

    // 2. Parameterized constructor (Fixes the "undefined" error in your main class)
    public Country(String coCode, String coName) {
        super();
        this.coCode = coCode;
        this.coName = coName;
    }

    // Getters and Setters
    public String getCoCode() { return coCode; }
    public void setCoCode(String coCode) { this.coCode = coCode; }
    public String getCoName() { return coName; }
    public void setCoName(String coName) { this.coName = coName; }

    @Override
    public String toString() {
        return "Country [coCode=" + coCode + ", coName=" + coName + "]";
    }
}