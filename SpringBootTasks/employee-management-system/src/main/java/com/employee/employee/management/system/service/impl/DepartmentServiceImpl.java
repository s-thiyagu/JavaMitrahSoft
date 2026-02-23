package com.employee.employee.management.system.service.impl;

import com.employee.employee.management.system.DTO.CreateDepartmentDTO;
import com.employee.employee.management.system.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public String createDepartments(CreateDepartmentDTO department){
        return "Department Details Entered Successfully";
    }
}
