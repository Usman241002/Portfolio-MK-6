package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Experience;
import dev.ukhalid.portfolio_api.repository.ExperienceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final ExperienceRepository experienceRepository;

    public ExperienceController(final ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping()
    public Iterable<Experience> getAllExperiences() {
        return this.experienceRepository.findAll();
    }

    @PostMapping()
    public Experience createExperience(@RequestBody Experience experience) {
        return this.experienceRepository.save(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable(name = "id") Integer id, @RequestBody Experience experience) {
        Optional<Experience> experienceToUpdateOptional = this.experienceRepository.findById(id);

        if (experienceToUpdateOptional.isEmpty()) {
            return null;
        }

        Experience experienceToUpdate = experienceToUpdateOptional.get();

        experienceToUpdate.setTitle(experience.getTitle());
        experienceToUpdate.setCompany(experience.getCompany());
        experienceToUpdate.setEmploymentType(experience.getEmploymentType());
        experienceToUpdate.setLocation(experience.getLocation());
        experienceToUpdate.setStartDate(experience.getStartDate());
        experienceToUpdate.setEndDate(experience.getEndDate());
        experienceToUpdate.setDescription(experience.getDescription());

        return this.experienceRepository.save(experienceToUpdate);
    }

    @DeleteMapping("/{id}")
    public Experience deleteExperience(@PathVariable(name = "id") Integer id) {
        Optional<Experience> experienceToDeleteOptional = this.experienceRepository.findById(id);

        if(experienceToDeleteOptional.isEmpty()) {
            return null;
        }

        Experience experienceToDelete = experienceToDeleteOptional.get();
        this.experienceRepository.delete(experienceToDelete);

        return experienceToDelete;
    }


}
