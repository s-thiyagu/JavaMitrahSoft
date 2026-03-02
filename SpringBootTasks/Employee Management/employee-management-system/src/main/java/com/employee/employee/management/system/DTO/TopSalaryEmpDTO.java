package com.employee.employee.management.system.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSalaryEmpDTO {

    @NotBlank
    private Long employee_Id;

    @NotBlank
    private String employee_Name;

    @NotNull(message = "Salary is required")
    private Long salary;

    @NotBlank
    private Long department_Id;

    @NotBlank
    private String department_name;

}
