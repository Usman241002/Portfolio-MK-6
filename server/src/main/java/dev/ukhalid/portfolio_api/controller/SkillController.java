package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Skill;
import dev.ukhalid.portfolio_api.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController (final SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public Iterable<Skill> getSkills() {
        return this.skillService.getSkills();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return this.skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable(name = "id") Integer id, @RequestBody Skill skill) {
                return this.skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public Skill deleteSkill(@PathVariable(name="id") Integer id) {
        return this.skillService.deleteSkill(id);
    }
}
