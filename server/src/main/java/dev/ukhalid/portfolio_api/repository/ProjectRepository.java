package dev.ukhalid.portfolio_api.repository;

import dev.ukhalid.portfolio_api.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    Iterable<Project> findByIsFeatured(boolean isFeatured);

    Iterable<Project> findByIsKodonProject(boolean isKodonProject);
}
