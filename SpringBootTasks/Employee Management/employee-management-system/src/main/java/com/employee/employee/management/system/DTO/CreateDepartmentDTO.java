package com.employee.employee.management.system.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentDTO {

    private Long department_id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

}
