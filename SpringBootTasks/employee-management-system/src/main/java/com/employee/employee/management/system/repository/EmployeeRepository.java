package com.employee.employee.management.system.repository;

import com.employee.employee.management.system.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employees_details(employee_name, salary, join_date, status, department_id) VALUES (:name, :salary, :joinDate, :status, :departmentId)", nativeQuery = true)
    void insertEmployee(@Param("name") String name, @Param("salary") Long salary, @Param("joinDate") Date joinDate,@Param("status") String status,@Param("departmentId") Long departmentId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employees_details WHERE employee_id= :id", nativeQuery = true)
    void deleteByIdEmp(@Param("id") Long id);

    @Transactional
    @Query(value = "SELECT * FROM employees_details WHERE employee_id = :id", nativeQuery = true)
    Employee getElementByIdEmp(@Param("id") Long id);

}





