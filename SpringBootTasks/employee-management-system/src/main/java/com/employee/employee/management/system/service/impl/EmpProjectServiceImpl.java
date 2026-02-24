package com.employee.employee.management.system.service.impl;

import com.employee.employee.management.system.DTO.*;
import com.employee.employee.management.system.repository.ProjectsRepository;
import com.employee.employee.management.system.service.EmpProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpProjectServiceImpl implements EmpProjectService {
    @Autowired
    ProjectsRepository projectsRepository;

    @Override
    public List<EmpProDetailsDTO> getEmpProDetails(){
        return projectsRepository.empProDetails();
    }

    @Override
    public List<EmployeeDTo> getEmpNoPro(){
        return projectsRepository.empNoPro();
    }

    @Override
    public List<EmpProDetailsDTO> getProjectWiseDetails(){
        return projectsRepository.projectWiseDetails();
    }

    @Override
    public List<EmpProjectCountDTO> getEmpProjectCount(){
        return projectsRepository.empProjectCount();
    }

    @Override
    public List<CreateProjectsDTO> getEmpWithNoProject(){
        return projectsRepository.empWithNoProject();
    }


}
