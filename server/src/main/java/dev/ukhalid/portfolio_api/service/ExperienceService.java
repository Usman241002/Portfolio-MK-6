package dev.ukhalid.portfolio_api.service;

import dev.ukhalid.portfolio_api.model.Experience;
import dev.ukhalid.portfolio_api.repository.ExperienceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(final ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Iterable<Experience> getAllExperiences() {
        return this.experienceRepository.findAll();
    }


    public Experience createExperience(Experience experience) {
        return this.experienceRepository.save(experience);
    }

    public Experience updateExperience(Integer id, Experience experience) {
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

    public Experience deleteExperience(Integer id) {
        Optional<Experience> experienceToDeleteOptional = this.experienceRepository.findById(id);

        if (experienceToDeleteOptional.isEmpty()) {
            return null;
        }

        Experience experienceToDelete = experienceToDeleteOptional.get();
        this.experienceRepository.delete(experienceToDelete);

        return experienceToDelete;
    }
}
