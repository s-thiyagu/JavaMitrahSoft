package com.employee.employee.management.system.controller;

import com.employee.employee.management.system.DTO.CreateDepartmentDTO;
import com.employee.employee.management.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createDepartments")
    public String createDepartments(@RequestBody CreateDepartmentDTO department){
        return departmentService.createDepartments(department);
    }
}
