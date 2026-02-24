package com.employee.employee.management.system.repository;

import com.employee.employee.management.system.DTO.CreateDepartmentDTO;
import com.employee.employee.management.system.DTO.DepartmentCountDTO;
import com.employee.employee.management.system.DTO.GetTotalExpense;
import com.employee.employee.management.system.DTO.TopSalaryEmpDTO;
import com.employee.employee.management.system.entity.Departments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO departments_details(department_id,department_name,location) VALUES (:id,:name,:location)", nativeQuery = true)
    void insertDepartment(@Param("id") Long id,@Param("name") String name,@Param("location") String location);

    @Query(value ="SELECT d.department_id,d.department_name,COUNT(e.department_id) AS Employee_Count FROM employees_details e LEFT JOIN departments_details d ON e.department_id=d.department_id group by department_id",nativeQuery = true)
    List<DepartmentCountDTO> getEmpCountPerDept();

    @Query(value ="SELECT d.department_id,d.department_name,sum(e.salary) As Expense FROM employees_details e LEFT JOIN departments_details d ON e.department_id=d.department_id group by department_id",nativeQuery = true)
    List<GetTotalExpense> getTotalExpPerDept();

    @Query(value ="SELECT e.employee_id,e.employee_name,e.salary,d.department_id,department_name FROM employees_details e LEFT JOIN departments_details d ON e.department_id=d.department_id ORDER BY e.salary DESC LIMIT 5",nativeQuery = true)
    List<TopSalaryEmpDTO> topEmpSalary();

    @Query(value ="SELECT * FROM departments_details where department_id NOT IN(SELECT d.department_id FROM employees_details e INNER JOIN departments_details d ON e.department_id = d.department_id Group by d.department_id)",nativeQuery = true)
    List<CreateDepartmentDTO> deptWithNoEmp();


}
