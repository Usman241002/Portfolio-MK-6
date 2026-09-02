package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Skill;
import dev.ukhalid.portfolio_api.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillRepository skillRepository;

    public SkillController (final SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping
    public Iterable<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Skill createSkill(Skill skill) {
        return this.skillRepository.save(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable(name = "id") Integer id, @RequestBody Skill skill) {
        Optional<Skill> skillToUpdateOptional = this.skillRepository.findById(id);

        if (skillToUpdateOptional.isEmpty()) {
            return null;
        }

        Skill skillToUpdate = skillToUpdateOptional.get();

        skillToUpdate.setName(skill.getName());
        skillToUpdate.setStartDate(skill.getStartDate());

        return this.skillRepository.save(skillToUpdate);
    }

    @DeleteMapping("/{id}")
    public Skill deleteSkill(@PathVariable(name="id") Integer id) {
        Optional<Skill> skillToDeleteOptional = this.skillRepository.findById(id);

        if (skillToDeleteOptional.isEmpty()) {
            return null;
        }

        Skill skillToDelete = skillToDeleteOptional.get();
        this.skillRepository.delete(skillToDelete);

        return skillToDelete;
    }
}
