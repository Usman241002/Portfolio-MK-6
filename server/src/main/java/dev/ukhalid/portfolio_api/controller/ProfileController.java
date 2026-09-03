package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.model.Profile;
import dev.ukhalid.portfolio_api.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(final ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public Optional<Profile> getProfile() {
        return this.profileService.getProfile();
    }

    @PutMapping
    public Profile updateProfile(@RequestBody Profile profile) {
        return this.profileService.updateProfile(profile);
    }
}
