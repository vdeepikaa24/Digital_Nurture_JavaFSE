package com.cognizant.EmployeeManagementSystem.repository;

import com.cognizant.EmployeeManagementSystem.dto.EmployeeNameProjection;
import com.cognizant.EmployeeManagementSystem.dto.EmployeeSummary;
import com.cognizant.EmployeeManagementSystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Page<Employee> findByName(String name, Pageable pageable);
    Page<Employee> findByEmailContaining(String email, Pageable pageable);
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    // 1. Fetch only names by department
    List<EmployeeNameProjection> findByDepartmentName(String departmentName);

    // 2. Fetch summary info (Name + Email)
    @Query("SELECT e FROM Employee e")
    List<EmployeeSummary> findAllSummaries();

    // --- Custom Queries ---
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findEmployeeByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM employee WHERE name = ?1", nativeQuery = true)
    List<Employee> findByNameNative(String name);

    // --- Named Queries ---
    List<Employee> findAllEmployees();
    Employee findByEmail(String email);
}