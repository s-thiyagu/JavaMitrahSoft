package com.employee.employee.management.system.repository;

import com.employee.employee.management.system.DTO.*;
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

    @Transactional
    @Query(value ="SELECT * FROM employees_details ",nativeQuery = true)
    List<Employee> getAllElement();

    @Transactional
    @Query(value ="SELECT * FROM employees_details WHERE status='Active'",nativeQuery = true)
    List<Employee> getAllElementStatus();

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees_details SET employee_name =:name, salary =:salary,join_date =:joinDate,status=:status,department_id=:departmentId WHERE employee_id=:id", nativeQuery = true)
    void putById(@Param("id") Long id, @Param("name") String name, @Param("salary") Long salary, @Param("joinDate") Date joinDate,@Param("status") String status,@Param("departmentId") Long departmentId);

    @Query(value ="SELECT e.employee_name,d.department_id,d.department_name FROM employees_details e LEFT JOIN departments_details d ON e.department_id=d.department_id",nativeQuery = true)
    List<EmpJoinDeptDTO> getEmpNameWithDept();

    @Query(value ="SELECT employee_id,employee_name,join_date,status,department_id FROM employees_details WHERE join_date >= DATE_SUB(CURDATE(), INTERVAL :months MONTH)",nativeQuery = true)
    List<EmployeeDTo> lastNMonth(@Param("months") Long months);

    @Query(value ="SELECT employee_id,employee_name,salary,join_date,status,department_id FROM employees_details WHERE (employee_name=:name AND department_id=1 AND(salary>=10000 AND salary<=20000))",nativeQuery = true)
    UpdateEmployeeDTO searchEmployee(@Param("name") String name, @Param("salaryMin") Long salaryMin, @Param("salaryMax") Long salaryMax, @Param("departmentId") Long departmentId);

    @Query(value ="Select d.department_id,d.department_name,e.status,count(e.status) AS Status FROM employees_details e LEFT JOIN departments_details d ON e.department_id=d.department_id group by e.status,e.department_id order by e.department_id",nativeQuery = true)
    List<DepartmentWiseStatus> departmentWiseStatus();

    @Query(value ="SELECT e.employee_id,e.employee_name,e.salary,e.join_date,e.status,e.department_id  FROM employees_details e WHERE e.salary >= ( SELECT AVG(e2.salary) FROM employees_details e2 WHERE e2.department_id = e.department_id)",nativeQuery = true)
    List<UpdateEmployeeDTO> empSalaryMoreThanAvg();

    @Query(value ="select e.employee_id,e.employee_name,e.salary,e.join_date,e.status,e.department_id From employees_details e order by join_date Limit 3",nativeQuery = true)
    List<UpdateEmployeeDTO> longestServingEmployees();

}

