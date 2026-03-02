package com.employee.employee.management.system.service;

import com.employee.employee.management.system.DTO.*;

import java.util.List;

public interface EmployeeService {
    String createEmployee(CreateEmployeeDTO employee);
    EmployeeDTo getElementById(Long empId);
    List<EmployeeDTo> getElements();
    List<EmployeeDTo> getEmpStatus(String status);
    String deleteEmployee(Long empId);
    String putById(UpdateEmployeeDTO employee);
    List<EmpJoinDeptDTO> getEmpNameWithDept();
    List<EmployeeDTo> getLastNMonth(Long months);
    UpdateEmployeeDTO getSearchEmployee(SearchEmployeeDTO employee);
    List<DepartmentWiseStatus> getDepartmentWiseStatus();
    List<UpdateEmployeeDTO> getEmpSalaryMoreThanAve();
    List<UpdateEmployeeDTO> getLongestServingEmployees();
}
