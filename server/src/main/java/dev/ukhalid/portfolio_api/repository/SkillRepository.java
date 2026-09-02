package dev.ukhalid.portfolio_api.repository;

import dev.ukhalid.portfolio_api.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
