package com.employee.employee.management.system.service;

import com.employee.employee.management.system.DTO.CreateEmployeeDTO;
import com.employee.employee.management.system.DTO.EmployeeDTo;
import com.employee.employee.management.system.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String createEmployee(CreateEmployeeDTO employee);
    EmployeeDTo getElementById(Long empId);
    List<EmployeeDTo> getElements();
    List<EmployeeDTo> getEmpStatus(String status);
    String deleteEmployee(Long empId);
}
