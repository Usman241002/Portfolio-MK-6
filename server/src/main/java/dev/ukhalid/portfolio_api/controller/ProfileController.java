package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Profile;
import dev.ukhalid.portfolio_api.repository.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileRepository profileRepository;

    public ProfileController(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public Optional<Profile> getProfile() {
        if (this.profileRepository.findById(1).isEmpty()) {
            return null;
        }
        return this.profileRepository.findById(1);
    }

    @PutMapping
    public Profile updateProfile(@RequestBody Profile profile) {
        Optional<Profile> profileToUpdateOptional = this.profileRepository.findById(1);

        if (profileToUpdateOptional.isEmpty()) {
            return null;
        }

        Profile profileToUpdate = profileToUpdateOptional.get();

        profileToUpdate.setName(profile.getName());
        profileToUpdate.setRole(profile.getRole());
        profileToUpdate.setLocation(profile.getLocation());
        profileToUpdate.setStatus(profile.getStatus());
        profileToUpdate.setEmail(profile.getEmail());
        profileToUpdate.setProfileUrl(profile.getProfileUrl());
        profileToUpdate.setLinkedinUrl(profile.getLinkedinUrl());
        profileToUpdate.setGithubUrl(profile.getGithubUrl());
        profileToUpdate.setCvUrl(profile.getCvUrl());

        return this.profileRepository.save(profileToUpdate);
    }

}
