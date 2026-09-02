package dev.ukhalid.portfolio_api.service;

import dev.ukhalid.portfolio_api.model.Skill;
import dev.ukhalid.portfolio_api.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(final SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Iterable<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    public Skill createSkill(Skill skill) {
        return this.skillRepository.save(skill);
    }

    public Skill updateSkill(Integer id, Skill skill) {
        Optional<Skill> skillToUpdateOptional = this.skillRepository.findById(id);

        if (skillToUpdateOptional.isEmpty()) {
            return null;
        }

        Skill skillToUpdate = skillToUpdateOptional.get();

        skillToUpdate.setName(skill.getName());
        skillToUpdate.setStartDate(skill.getStartDate());

        return this.skillRepository.save(skillToUpdate);
    }

    public Skill deleteSkill(Integer id) {
        Optional<Skill> skillToDeleteOptional = this.skillRepository.findById(id);

        if (skillToDeleteOptional.isEmpty()) {
            return null;
        }

        Skill skillToDelete = skillToDeleteOptional.get();
        this.skillRepository.delete(skillToDelete);

        return skillToDelete;
    }
}
