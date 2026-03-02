package com.employee.employee.management.system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectsDTO {
    private Long projectId;
    private String project_name;
}
