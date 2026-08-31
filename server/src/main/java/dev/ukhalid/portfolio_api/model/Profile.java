package dev.ukhalid.portfolio_api.model;

import jakarta.persistence.*;

import dev.ukhalid.portfolio_api.model.enums.ProfileStatus;

@Entity
@Table(name = "PROFILE")
public class Profile {
    @Id
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "LOCATION")
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProfileStatus status = ProfileStatus.OPEN_TO_WORK;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PROFILE_URL")
    private String profileUrl;
    @Column(name = "LINKEDIN_URL")
    private String linkedinUrl;
    @Column(name = "GITHUB_URL")
    private String githubUrl;
    @Column(name = "CV_URL")
    private String cvUrl;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProfileStatus getStatus() {
        return this.status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getLinkedinUrl() {
        return this.linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return this.githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getCvUrl() {
        return this.cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }
}
