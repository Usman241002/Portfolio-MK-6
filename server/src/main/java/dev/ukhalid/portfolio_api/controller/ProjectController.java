package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Project;
import dev.ukhalid.portfolio_api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;


    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Iterable<Project> getProjects() {
        return this.projectService.getProjects();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return this.projectService.createProject(project);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable(name = "id") Integer id) {
        return this.projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable(name = "id") Integer id, @RequestBody Project project) {
        return this.projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public Project deleteProject(@PathVariable(name = "id") Integer id) {
        return this.projectService.deleteProject(id);
    }

    @GetMapping("/featured")
    public Iterable<Project> getFeaturedProjects() {
        return this.projectService.getFeaturedProjects();
    }

    @GetMapping("/kodon")
    public Iterable<Project> getKodonProjects() {
        return this.projectService.getKodonProjects();
    }
}
