package com.employee.employee.management.system.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTotalExpense {
    @NotBlank
    private Long department_id;

    @NotBlank
    private String department_name;

    @NotBlank
    private BigDecimal Expense;
}
