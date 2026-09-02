package dev.ukhalid.portfolio_api.repository;

import dev.ukhalid.portfolio_api.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
