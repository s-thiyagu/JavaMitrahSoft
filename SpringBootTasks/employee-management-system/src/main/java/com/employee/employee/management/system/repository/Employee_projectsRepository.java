package com.employee.employee.management.system.repository;

import com.employee.employee.management.system.entity.Employee_projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_projectsRepository extends JpaRepository<Employee_projects,Long> {
}
