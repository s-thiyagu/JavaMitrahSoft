package com.employee.employee.management.system.service;

import com.employee.employee.management.system.DTO.*;

import java.util.List;

public interface EmpProjectService {
    List<EmpProDetailsDTO> getEmpProDetails();
    List<EmployeeDTo> getEmpNoPro();
    List<EmpProDetailsDTO> getProjectWiseDetails();
    List<EmpProjectCountDTO> getEmpProjectCount();
    List<CreateProjectsDTO> getEmpWithNoProject();

}
