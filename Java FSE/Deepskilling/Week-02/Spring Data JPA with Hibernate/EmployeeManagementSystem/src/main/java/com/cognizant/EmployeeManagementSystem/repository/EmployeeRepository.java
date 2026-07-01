package com.cognizant.EmployeeManagementSystem.repository;

import com.cognizant.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // --- 1. Derived Query Methods ---
    List<Employee> findByName(String name);
    List<Employee> findByEmailContaining(String email);
    List<Employee> findByDepartmentName(String departmentName);

    // --- 2. Custom Query using @Query Annotation ---
    // JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findEmployeeByEmail(@Param("email") String email);

    // Native SQL Query Example
    @Query(value = "SELECT * FROM employee WHERE name = ?1", nativeQuery = true)
    List<Employee> findByNameNative(String name);

    // --- 3. Named Queries (Matches the @NamedQuery in Entity) ---
    List<Employee> findAllEmployees();
    Employee findByEmail(String email);
}