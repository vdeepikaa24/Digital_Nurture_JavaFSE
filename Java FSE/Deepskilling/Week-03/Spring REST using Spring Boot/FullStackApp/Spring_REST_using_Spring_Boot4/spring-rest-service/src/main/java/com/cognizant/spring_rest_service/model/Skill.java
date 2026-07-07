package com.cognizant.spring_rest_service.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Skill {

    @NotNull(message = "Skill id must not be null")
    @Digits(integer = 10, fraction = 0, message = "Skill id must be a number")
    private Integer id;

    @NotNull(message = "Skill name must not be null")
    @NotBlank(message = "Skill name must not be blank")
    @Size(min = 1, max = 30, message = "Skill name must be between 1 and 30 characters")
    private String name;

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
}
