package dev.ukhalid.portfolio_api.repositories;

import dev.ukhalid.portfolio_api.models.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
