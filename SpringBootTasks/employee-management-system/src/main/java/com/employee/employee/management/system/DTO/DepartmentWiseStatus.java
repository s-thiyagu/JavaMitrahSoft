package com.employee.employee.management.system.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentWiseStatus {

    private Long department_id;

    @NotBlank
    private String department_name;

    @NotBlank
    private String status;

    @NotBlank
    private Long status_Count;

}
