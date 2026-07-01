package com.cognizant.EmployeeManagementSystem.repository;
import com.cognizant.EmployeeManagementSystem.model.Employee;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Examples of Derived Query Methods
    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);
}