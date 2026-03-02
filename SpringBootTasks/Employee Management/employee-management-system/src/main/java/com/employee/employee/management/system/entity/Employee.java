package com.employee.employee.management.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees_details")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;

    @NotBlank(message = "Employee name is required")
    @Column(name = "employee_name")
    private String name;

    @NotNull(message = "Salary is required")
    @Column(name = "salary")
    private Long salary;

    @NotNull(message = "Join date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "join_date")
    private Date joinDate;

    @NotBlank
    @Column(name = "status")
    private String status = "Active";

    @NotNull(message = "Department ID is required")
    @Column(name = "department_id")
    private Long departmentId;

}

