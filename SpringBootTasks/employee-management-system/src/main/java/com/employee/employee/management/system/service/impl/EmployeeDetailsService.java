package com.employee.employee.management.system.service.impl;
import com.employee.employee.management.system.DTO.*;
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
        return "Employee Details Inserted Successfully";
    }

    @Override
    public String putById(UpdateEmployeeDTO emp){
        employeeRepository.putById(emp.getEmpId(),emp.getName(),emp.getSalary(),emp.getJoinDate(),emp.getStatus(),emp.getDepartmentId());
        return "Employee Details Updated Successfully";
    }

    @Override
    public String deleteEmployee(Long empId){
        employeeRepository.deleteByIdEmp(empId);
        return "Employee Details deleted  successfully";
    }

    @Override
    public EmployeeDTo getElementById(Long empId) {
        Employee emp=employeeRepository.getElementByIdEmp(empId);
        return transferData(emp);
    }

    @Override
    public List<EmployeeDTo> getElements() {
        EmployeeDTo empDto=new EmployeeDTo();
        List<Employee> emp= this.employeeRepository.getAllElement();
        return transfer(emp);
    }

    @Override
    public List<EmployeeDTo> getEmpStatus(String status) {
        List<Employee> emp= this.employeeRepository.getAllElementStatus();
        return transfer(emp);
    }
    @Override
    public List<EmpJoinDeptDTO> getEmpNameWithDept(){
        return employeeRepository.getEmpNameWithDept();
    }

    @Override
    public List<EmployeeDTo> getLastNMonth(Long months){
        return employeeRepository.lastNMonth(months);
    }

    @Override
    public UpdateEmployeeDTO getSearchEmployee(SearchEmployeeDTO employee){
        return employeeRepository.searchEmployee(employee.getName(),employee.getSalaryMin(),employee.getSalaryMax(),employee.getDepartmentId());
    }

    @Override
    public List<DepartmentWiseStatus> getDepartmentWiseStatus(){
        return employeeRepository.departmentWiseStatus();
    }

    private List<EmployeeDTo> transfer(List<Employee> emp){
        List<EmployeeDTo> listEmpDto= new ArrayList<>();
        for(Employee employee:emp){
            listEmpDto.add(transferData(employee));
        }
        return listEmpDto;
    }
    private EmployeeDTo transferData(Employee emp){
        EmployeeDTo empDto=new EmployeeDTo();
        empDto.setEmpId(emp.getEmpId());
        empDto.setName(emp.getName());
        empDto.setStatus(emp.getStatus());
        empDto.setJoinDate(emp.getJoinDate());
        empDto.setDepartmentId(emp.getDepartmentId());
        return empDto;
    }
}
