package com.employee.employee.management.system.repository;

import com.employee.employee.management.system.DTO.CreateProjectsDTO;
import com.employee.employee.management.system.DTO.EmpProDetailsDTO;
import com.employee.employee.management.system.DTO.EmpProjectCountDTO;
import com.employee.employee.management.system.DTO.EmployeeDTo;
import com.employee.employee.management.system.entity.Projects;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects,Long>{

    @Transactional
    @Query(value ="SELECT  e.employee_id,e.employee_name,e.department_id, p.pro_id,p.project_name FROM employees_details e INNER JOIN employee_projects ep ON e.employee_id = ep.employee_id INNER JOIN project_details AS p ON ep.project_id = p.pro_id",nativeQuery = true)
    List<EmpProDetailsDTO> empProDetails();

    @Transactional
    @Query(value ="SELECT employee_id,employee_name,join_date,status,department_id FROM employees_details where employee_id NOT IN(SELECT e.employee_id FROM employees_details e INNER JOIN employee_projects ep ON e.employee_id = ep.employee_id)",nativeQuery = true)
    List<EmployeeDTo> empNoPro();

    @Transactional
    @Query(value ="SELECT  e.employee_id,e.employee_name,e.department_id, p.pro_id,p.project_name FROM employees_details e INNER JOIN employee_projects ep ON e.employee_id = ep.employee_id INNER JOIN project_details AS p ON ep.project_id = p.pro_id Order By pro_id",nativeQuery = true)
    List<EmpProDetailsDTO> projectWiseDetails();

    @Transactional
    @Query(value ="SELECT e.employee_id,e.employee_name,e.department_id, COUNT(e.employee_id) as Project_count FROM employees_details e INNER JOIN employee_projects ep ON e.employee_id = ep.employee_id group by e.employee_id  HAVING COUNT(e.employee_id)>=2",nativeQuery = true)
    List<EmpProjectCountDTO> empProjectCount();

    @Transactional
    @Query(value ="SELECT pro_id,project_name from project_details WHERE pro_id NOT IN(SELECT p.pro_id from project_details p inner join employee_projects ep on p.pro_id=ep.project_id)",nativeQuery = true)
    List<CreateProjectsDTO> empWithNoProject();


}
