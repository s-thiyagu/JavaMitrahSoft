package com.employee.employee.management.system.controller;


import com.employee.employee.management.system.DTO.CreateProjectsDTO;
import com.employee.employee.management.system.DTO.EmpProDetailsDTO;
import com.employee.employee.management.system.DTO.EmpProjectCountDTO;
import com.employee.employee.management.system.DTO.EmployeeDTo;
import com.employee.employee.management.system.service.EmpProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectsController {
    @Autowired
    EmpProjectService empProjectService;

    @GetMapping("/empProDetails")
    public List<EmpProDetailsDTO> getEmpProDetails() {
        return empProjectService.getEmpProDetails();
    }

    @GetMapping("/empNoPro")
    public List<EmployeeDTo> getEmpNoPro() {
        return empProjectService.getEmpNoPro();
    }

    @GetMapping("/projectWiseDetails")
    public List<EmpProDetailsDTO> getProjectWiseDetails() {
        return empProjectService.getProjectWiseDetails();
    }

    @GetMapping("/empProjectCount")
    public List<EmpProjectCountDTO> getEmpProjectCount() {
        return empProjectService.getEmpProjectCount();
    }

    @GetMapping("/empWithNoProject")
    public List<CreateProjectsDTO> getEmpWithNoProject() {
        return empProjectService.getEmpWithNoProject();
    }
}
