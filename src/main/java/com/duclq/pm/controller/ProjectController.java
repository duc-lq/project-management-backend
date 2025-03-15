package com.duclq.pm.controller;

import com.duclq.pm.model.Project;
import com.duclq.pm.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        project.setCreatedDate(LocalDate.now());
        return projectRepository.save(project);
    }
}
