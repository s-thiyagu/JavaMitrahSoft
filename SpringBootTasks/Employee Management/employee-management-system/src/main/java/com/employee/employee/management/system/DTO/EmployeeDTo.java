package com.employee.employee.management.system.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTo {

    private Long empId;

    @NotBlank
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date joinDate;

    @NotBlank
    private String status = "Active";

    private Long departmentId;
}
