package com.employee.employee.management.system.service.impl;

import com.employee.employee.management.system.DTO.CreateDepartmentDTO;
import com.employee.employee.management.system.DTO.DepartmentCountDTO;
import com.employee.employee.management.system.DTO.GetTotalExpense;
import com.employee.employee.management.system.DTO.TopSalaryEmpDTO;
import com.employee.employee.management.system.entity.Departments;
import com.employee.employee.management.system.repository.DepartmentsRepository;
import com.employee.employee.management.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentsRepository departmentsRepository;

    @Override
    public String createDepartments(CreateDepartmentDTO deptDetails){
        Departments department= new Departments();
        department.setDepartment_id(deptDetails.getDepartment_id());
        department.setName(deptDetails.getName());
        department.setLocation(deptDetails.getLocation());
        departmentsRepository.insertDepartment(department.getDepartment_id(),department.getName(),department.getLocation());
        return "Department Details Created Successfully";
    }

    @Override
    public List<DepartmentCountDTO> getEmpCountPerDept(){
        return departmentsRepository.getEmpCountPerDept();
    }

    @Override
    public List<GetTotalExpense> getTotalExpPerDept(){
        return departmentsRepository.getTotalExpPerDept();
    }

    @Override
    public List<TopSalaryEmpDTO> getTopEmpSalary(){
        return departmentsRepository.topEmpSalary();
    }

    @Override
    public List<CreateDepartmentDTO> getDeptWithNoEmp(){
        return departmentsRepository.deptWithNoEmp();
    }

}
