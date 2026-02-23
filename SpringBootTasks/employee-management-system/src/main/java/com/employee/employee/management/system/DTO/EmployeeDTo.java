package com.employee.employee.management.system.DTO;
import com.employee.employee.management.system.entity.Departments;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @NotBlank
    @Column(name = "Employee_name")
    private String name;

    @Column(name = "salary")
    private Long salary;

    @Column(name="date_of_joining")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date joinDate;

    @NotBlank
    @Column(name = "status")
    private String status = "Active";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Departments departments;
}
