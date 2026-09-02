package dev.ukhalid.portfolio_api.repositories;

import dev.ukhalid.portfolio_api.models.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Integer> {
}
