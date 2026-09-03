package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Experience;
import dev.ukhalid.portfolio_api.service.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(final ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping()
    public Iterable<Experience> getAllExperiences() {
        return this.experienceService.getAllExperiences();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Experience createExperience(@RequestBody Experience experience) {
        return this.experienceService.createExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable(name = "id") Integer id, @RequestBody Experience experience) {
        return this.experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public Experience deleteExperience(@PathVariable(name = "id") Integer id) {
        return this.experienceService.deleteExperience(id);

    }
}
