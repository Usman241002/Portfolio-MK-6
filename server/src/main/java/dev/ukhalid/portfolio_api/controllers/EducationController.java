package dev.ukhalid.portfolio_api.controllers;

import dev.ukhalid.portfolio_api.models.Education;
import dev.ukhalid.portfolio_api.services.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;

    public EducationController(final EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping()
    public Iterable<Education> getAllEducation() {
        return this.educationService.getAllEducation();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Education createEducation(@RequestBody Education education) {
        return this.educationService.createEducation(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable(name = "id") Integer id, @RequestBody Education education) {
        return this.educationService.updateEducation(id, education);
    }

    @DeleteMapping("/{id}")
    public Education deleteEducation(@PathVariable(name = "id") Integer id) {
        return this.educationService.deleteEducation(id);
    }
}
