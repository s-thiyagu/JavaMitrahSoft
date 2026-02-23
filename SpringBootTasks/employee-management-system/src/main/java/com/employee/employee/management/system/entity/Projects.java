package com.employee.employee.management.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project_details")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proId;

    @Column(name="project_name")
    private String name;

    @Column(name="start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @Column(name="end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
