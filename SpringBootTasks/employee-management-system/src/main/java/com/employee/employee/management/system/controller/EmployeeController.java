package com.employee.employee.management.system.controller;

import com.employee.employee.management.system.DTO.*;
import com.employee.employee.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody CreateEmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long empId){
        return employeeService.deleteEmployee(empId);
    }

    @GetMapping("/getElements")
    public List<EmployeeDTo> getElements() {
        return employeeService.getElements();
    }

    @GetMapping("/getElementById/{id}")
    public EmployeeDTo getElementById(@PathVariable("id") Long empId) {
        return employeeService.getElementById(empId);
    }

    @GetMapping("/getElementByStatus")
    public List<EmployeeDTo> getEmpStatus(@RequestParam(name="status",required = false,defaultValue = "Active")String status){
       return employeeService.getEmpStatus(status);
    }

    @PutMapping("/putById")
    public String putById(@RequestBody UpdateEmployeeDTO employee){
        return employeeService.putById(employee);
    }

    @GetMapping("/getEmpDept")
    public List<EmpJoinDeptDTO> getEmpNameWithDept() {
        return employeeService.getEmpNameWithDept();
    }

    @GetMapping("/getLastNMonth/{months}")
    public List<EmployeeDTo> getLastNMonth(@PathVariable("months") Long months) {
        return employeeService.getLastNMonth(months);
    }

    @PostMapping("/getSearchEmployee")
    public UpdateEmployeeDTO getSearchEmployee (@RequestBody SearchEmployeeDTO employee) {
        return employeeService.getSearchEmployee(employee);
    }

    @GetMapping("/getDepartmentWiseStatus")
    public List<DepartmentWiseStatus> getDepartmentWiseStatus() {
        return employeeService.getDepartmentWiseStatus();
    }

    @GetMapping("/empSalaryMoreThanAvg")
    public List<UpdateEmployeeDTO> getEmpSalaryMoreThanAve() {
        return employeeService.getEmpSalaryMoreThanAve();
    }

    @GetMapping("/longestServingEmployees")
    public List<UpdateEmployeeDTO> getLongestServingEmployees() {
        return employeeService.getLongestServingEmployees();
    }
}
