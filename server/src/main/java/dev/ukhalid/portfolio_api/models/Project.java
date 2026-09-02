package dev.ukhalid.portfolio_api.models;

import dev.ukhalid.portfolio_api.models.enums.ProjectStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "SLUG")
    private String slug;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "SUBTITLE")
    private String subtitle;
    @Column(name = "CLIENT")
    private String client;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "START_DATE")
    private LocalDate startDate;
    @Column(name = "END_DATE")
    private LocalDate endDate;
    @Column(name = "DESCRIPTION")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProjectStatus status = ProjectStatus.ONGOING;
    @Column(name = "REPOSITORY_URL")
    private String repositoryUrl = null;
    @Column(name = "DEMO_URL")
    private String demoUrl = null;
    @Column(name = "THUMBNAIL_URL")
    private String thumbnailUrl = null;
    @Column(name = "IS_FEATURED")
    private boolean isFeatured = false;
    @Column(name = "IS_KODON_PROJECT")
    private boolean isKodonProject = false;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectSection> sections = new ArrayList<ProjectSection>();

    @ManyToMany
    @JoinTable(name = "PROJECT_SKILLS", joinColumns = @JoinColumn(name = "PROJECT_ID"), inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    private List<Skill> skills = new ArrayList<Skill>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return this.status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getRepositoryUrl() {
        return this.repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDemoUrl() {
        return this.demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean getIsFeatured() {
        return this.isFeatured;
    }

    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public boolean getIsKodonProject() {
        return this.isKodonProject;
    }

    public void setIsKodonProject(boolean isKodonProject) {
        this.isKodonProject = isKodonProject;
    }

    public List<ProjectSection> getSections() {
        return this.sections;
    }

    public void setSections(List<ProjectSection> sections) {
        this.sections.clear();

        for (ProjectSection section : sections) {
            this.addSection(section);
        }
    }

    public void addSection(ProjectSection section) {
        this.sections.add(section);
        section.setProject(this);
    }

    public void removeSection(ProjectSection section) {
        this.sections.remove(section);
        section.setProject(null);
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills.clear();

        for (Skill skill : skills) {
            this.addSkill(skill);
        }
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }
}
