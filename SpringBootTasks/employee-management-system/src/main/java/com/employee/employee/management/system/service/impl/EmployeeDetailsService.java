package com.employee.employee.management.system.service.impl;
import com.employee.employee.management.system.DTO.CreateEmployeeDTO;
import com.employee.employee.management.system.DTO.EmployeeDTo;
import com.employee.employee.management.system.entity.Employee;
import com.employee.employee.management.system.repository.EmployeeRepository;
import com.employee.employee.management.system.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public  class EmployeeDetailsService implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public String createEmployee(CreateEmployeeDTO employee) {
        Employee emp=new Employee();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setJoinDate(employee.getJoinDate());
        emp.setStatus(employee.getStatus());
        emp.setDepartmentId(employee.getDepartmentId());
        employeeRepository.insertEmployee(emp.getName(),emp.getSalary(),emp.getJoinDate(),emp.getStatus(),emp.getDepartmentId());
        return "Inserted Successfully";
    }

    @Override
    public EmployeeDTo getElementById(Long empId) {
        EmployeeDTo empDto=new EmployeeDTo();
        Employee emp=employeeRepository.getElementByIdEmp(empId);
        empDto.setEmpId(emp.getEmpId());
        empDto.setName(emp.getName());
        empDto.setStatus(emp.getStatus());
        return empDto;
    }

    @Override
    public String deleteEmployee(Long empId){
        employeeRepository.deleteByIdEmp(empId);
        return "deleted  successfully";
    }

    @Override
    public List<EmployeeDTo> getElements() {
        List<Employee> emp= this.employeeRepository.findAll();
        return transfer(emp);
    }

    @Override
    public List<EmployeeDTo> getEmpStatus(String status) {
        List<Employee> emp= this.employeeRepository.findByStatus(status);
        return transfer(emp);
    }

    private List<EmployeeDTo> transfer(List<Employee> emp){
        List<EmployeeDTo> listEmpDto= new ArrayList<>();
        for(Employee employee:emp){
            EmployeeDTo empDto=new EmployeeDTo();
            empDto.setEmpId(employee.getEmpId());
            empDto.setName(employee.getName());
            empDto.setStatus(employee.getStatus());
            listEmpDto.add(empDto);
        }
        return listEmpDto;
    }
}
