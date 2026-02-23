package com.employee.employee.management.system.controller;

import com.employee.employee.management.system.DTO.CreateEmployeeDTO;
import com.employee.employee.management.system.DTO.EmployeeDTo;
import com.employee.employee.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public List<EmployeeDTo> getEmpStatus(@RequestParam(name="status",required = false,defaultValue = "ACTIVE")String status){
       return employeeService.getEmpStatus(status);
    }

}
