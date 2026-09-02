package dev.ukhalid.portfolio_api.repositories;

import dev.ukhalid.portfolio_api.models.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
