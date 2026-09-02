package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Education;
import dev.ukhalid.portfolio_api.repository.EducationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationRepository educationRepository;

    public EducationController(final EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping()
    public Iterable<Education> getAllEducation() {
        return this.educationRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Education createEducation(@RequestBody Education education) {
        return this.educationRepository.save(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable(name = "id") Integer id, @RequestBody Education education) {
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

    @DeleteMapping("/{id}")
    public Education deleteEducation(@PathVariable(name = "id") Integer id) {
        Optional<Education> educationToDeleteOptional = this.educationRepository.findById(id);

        if(educationToDeleteOptional.isEmpty()) {
            return null;
        }

        Education educationToDelete = educationToDeleteOptional.get();
        this.educationRepository.delete(educationToDelete);

        return educationToDelete;
    }


}
