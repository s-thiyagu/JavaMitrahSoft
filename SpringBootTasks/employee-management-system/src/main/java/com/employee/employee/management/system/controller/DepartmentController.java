package com.employee.employee.management.system.controller;

import com.employee.employee.management.system.DTO.CreateDepartmentDTO;
import com.employee.employee.management.system.DTO.DepartmentCountDTO;
import com.employee.employee.management.system.DTO.GetTotalExpense;
import com.employee.employee.management.system.DTO.TopSalaryEmpDTO;
import com.employee.employee.management.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createDepartments")
    public String createDepartments(@RequestBody CreateDepartmentDTO department){
        return departmentService.createDepartments(department);
    }

    @GetMapping("/empCountPerDept")
    public List<DepartmentCountDTO> getEmpCountPerDept(){
        return departmentService.getEmpCountPerDept();
    }

    @GetMapping("/getTotalExpPerDept")
    public List<GetTotalExpense> getTotalExpPerDept(){
        return departmentService.getTotalExpPerDept();
    }

    @GetMapping("/getTopEmpSalary")
    public List<TopSalaryEmpDTO> getTopEmpSalary(){
        return departmentService.getTopEmpSalary();
    }


}
