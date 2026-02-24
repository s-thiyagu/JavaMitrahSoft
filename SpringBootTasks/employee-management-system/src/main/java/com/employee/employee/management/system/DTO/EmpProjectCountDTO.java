package com.employee.employee.management.system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpProjectCountDTO {

    private Long empId;
    private String empName;
    private Long departmentId;
    private Long Project_count;
}
