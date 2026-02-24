package com.employee.employee.management.system.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpProDetailsDTO {
    private Long empId;
    private String empName;
    private Long departmentId;
    private Long projectId;
    private String project_name;
}
