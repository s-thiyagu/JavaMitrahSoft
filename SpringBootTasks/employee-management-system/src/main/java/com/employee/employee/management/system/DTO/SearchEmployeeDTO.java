package com.employee.employee.management.system.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SearchEmployeeDTO {
    @NotBlank(message = "Employee name is required")
    private String name;

    @NotNull(message = "Salary is required")
    @Min(value = 0)
    @Max(value= 1000000)
    private Long salaryMin;

    @NotNull(message = "Salary is required")
    @Min(value = 0)
    @Max(value= 1000000)
    private Long salaryMax;

    @NotNull(message = "Department ID is required")
    private Long departmentId;
}
