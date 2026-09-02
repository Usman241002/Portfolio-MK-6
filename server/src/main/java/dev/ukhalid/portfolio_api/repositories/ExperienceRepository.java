package dev.ukhalid.portfolio_api.repositories;

import dev.ukhalid.portfolio_api.models.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Integer> {
}
