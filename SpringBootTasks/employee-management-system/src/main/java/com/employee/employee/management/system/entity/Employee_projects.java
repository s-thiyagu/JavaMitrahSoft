package com.employee.employee.management.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee_projects")
public class Employee_projects {
    @Id
    @Column(name="project_id")
    private Long project_id;

    @Column(name="employee_id")
    private Long employee_id;

}
