package dev.ukhalid.portfolio_api.repositories;

import dev.ukhalid.portfolio_api.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    Iterable<Project> findByIsFeatured(boolean isFeatured);

    Iterable<Project> findByIsKodonProject(boolean isKodonProject);
}
