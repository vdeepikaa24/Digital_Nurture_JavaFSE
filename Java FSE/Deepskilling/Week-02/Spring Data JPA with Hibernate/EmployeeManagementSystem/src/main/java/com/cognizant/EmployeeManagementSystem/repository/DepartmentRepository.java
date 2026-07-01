package com.cognizant.EmployeeManagementSystem.repository;
import com.cognizant.EmployeeManagementSystem.model.Department;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // You can add derived query methods here if needed
    // Example: List<Department> findByName(String name);
}