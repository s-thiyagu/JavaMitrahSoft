package com.employee.employee.management.system.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_map_id")
    private Long project_map_id;

    @Column(name="project_id")
    private Long project_id;

    @Column(name="employee_id")
    private Long employee_id;

}
