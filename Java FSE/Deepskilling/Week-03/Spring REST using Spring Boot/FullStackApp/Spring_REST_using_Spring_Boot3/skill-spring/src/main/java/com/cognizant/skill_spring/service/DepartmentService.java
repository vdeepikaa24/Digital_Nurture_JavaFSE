package com.cognizant.skill_spring.service;

import com.cognizant.skill_spring.dao.DepartmentDao;
import com.cognizant.skill_spring.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}