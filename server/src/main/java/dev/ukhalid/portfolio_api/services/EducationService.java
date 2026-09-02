package dev.ukhalid.portfolio_api.services;

import dev.ukhalid.portfolio_api.models.Education;
import dev.ukhalid.portfolio_api.repositories.EducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationService(final EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Iterable<Education> getAllEducation() {
        return this.educationRepository.findAll();
    }

    public Education createEducation(Education education) {
        return this.educationRepository.save(education);
    }

    public Education updateEducation(Integer id, Education education) {
        Optional<Education> educationToUpdateOptional = this.educationRepository.findById(id);

        if (educationToUpdateOptional.isEmpty()) {
            return null;
        }

        Education educationToUpdate = educationToUpdateOptional.get();

        educationToUpdate.setTitle(education.getTitle());
        educationToUpdate.setInstitution(education.getInstitution());
        educationToUpdate.setLocation(education.getLocation());
        educationToUpdate.setStartDate(education.getStartDate());
        educationToUpdate.setEndDate(education.getEndDate());
        educationToUpdate.setGrade(education.getGrade());
        educationToUpdate.setDescription(education.getDescription());

        return this.educationRepository.save(educationToUpdate);
    }

    public Education deleteEducation(Integer id) {
        Optional<Education> educationToDeleteOptional = this.educationRepository.findById(id);

        if (educationToDeleteOptional.isEmpty()) {
            return null;
        }

        Education educationToDelete = educationToDeleteOptional.get();
        this.educationRepository.delete(educationToDelete);

        return educationToDelete;
    }
}
