package dev.ukhalid.portfolio_api.service;

import dev.ukhalid.portfolio_api.model.Project;
import dev.ukhalid.portfolio_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;


    public ProjectService(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return this.projectRepository.save(project);
    }

    public Project getProjectById(Integer id) {
        Optional<Project> projectOptional = this.projectRepository.findById(id);

        return projectOptional.orElse(null);
    }

    public Project updateProject(Integer id, Project project) {
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

    public Project deleteProject(Integer id) {
        Optional<Project> projectToDeleteOptional = this.projectRepository.findById(id);

        if (projectToDeleteOptional.isEmpty()) {
            return null;
        }

        Project projectToDelete = projectToDeleteOptional.get();

        this.projectRepository.delete(projectToDelete);
        return projectToDelete;
    }

    public Iterable<Project> getFeaturedProjects() {
        return this.projectRepository.findByIsFeatured(true);
    }

    public Iterable<Project> getKodonProjects() {
        return this.projectRepository.findByIsKodonProject(true);
    }

//    @PutMapping("/{id}/thumbnail")
//    public Project updateThumbnail(Project project, @RequestParam MultipartFile image) {
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
