package com.employee.employee.management.system.service;

import com.employee.employee.management.system.DTO.*;

import java.util.List;

public interface DepartmentService {
    String createDepartments(CreateDepartmentDTO department);
    List<DepartmentCountDTO> getEmpCountPerDept();
    List<GetTotalExpense> getTotalExpPerDept();
    List<TopSalaryEmpDTO> getTopEmpSalary();
    List<CreateDepartmentDTO> getDeptWithNoEmp();

}
