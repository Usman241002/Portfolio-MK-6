package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Project;
import dev.ukhalid.portfolio_api.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;


    public ProjectController(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public Iterable<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return this.projectRepository.save(project);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable(name = "id") Integer id) {
        Optional<Project> projectOptional = this.projectRepository.findById(id);

        return projectOptional.orElse(null);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable(name = "id") Integer id, @RequestBody Project project) {
        Optional<Project> projectToUpdateOptional = this.projectRepository.findById(id);

        if (projectToUpdateOptional.isEmpty()) {
            return null;
        }

        Project projectToUpdate = projectToUpdateOptional.get();

        projectToUpdate.setSlug(project.getSlug());
        projectToUpdate.setTitle(project.getTitle());
        projectToUpdate.setSubtitle(project.getSubtitle());
        projectToUpdate.setClient(project.getClient());
        projectToUpdate.setRole(project.getRole());
        projectToUpdate.setStartDate(project.getStartDate());
        projectToUpdate.setEndDate(project.getEndDate());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setStatus(project.getStatus());
        projectToUpdate.setRepositoryUrl(project.getRepositoryUrl());
        projectToUpdate.setDemoUrl(project.getDemoUrl());
        projectToUpdate.setIsFeatured(project.getIsFeatured());
        projectToUpdate.setIsKodonProject(project.getIsKodonProject());

        return this.projectRepository.save(projectToUpdate);
    }

    @DeleteMapping("/{id}")
    public Project deleteProject(@PathVariable(name = "id") Integer id) {
        Optional<Project> projectToDeleteOptional = this.projectRepository.findById(id);

        if (projectToDeleteOptional.isEmpty()) {
            return null;
        }

        Project projectToDelete = projectToDeleteOptional.get();

        this.projectRepository.delete(projectToDelete);
        return projectToDelete;
    }

    @GetMapping("/featured")
    public Iterable<Project> getFeaturedProjects() {
        return this.projectRepository.findByIsFeatured(true);
    }

    @GetMapping("/kodon")
    public Iterable<Project> getKodonProjects() {
        return this.projectRepository.findByIsKodonProject(true);
    }

//    @PutMapping("/{id}/thumbnail")
//    public Project updateThumbnail(@PathVariable(name = "id") Project project, @RequestParam MultipartFile image) {
//        Optional<Project> projectToUpdateOptional =
//                this.projectRepository.findById(id);
//
//        if (projectToUpdateOptional.isEmpty()) {
//            return null;
//        }
//
//        Project projectToUpdate = projectToUpdateOptional.get();
//
//        // Save the image somewhere
//        String fileName = image.getOriginalFilename();
//
//        // For now, just example logic
//        projectToUpdate.setThumbnailUrl(fileName);
//
//        return this.projectRepository.save(projectToUpdate);
//    }
}
