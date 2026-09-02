package dev.ukhalid.portfolio_api.model;

import dev.ukhalid.portfolio_api.model.enums.ImagePosition;
import jakarta.persistence.*;

@Entity
@Table(name = "PROJECT_SECTIONS")
public class ProjectSection {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
    @Column(name = "DISPLAY_INDEX")
    private Integer displayIndex;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "IMAGE_POSITION")
    private ImagePosition imagePosition = ImagePosition.NONE;
    @Column(name = "CONTENT")
    private String content;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project fetchProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getDisplayIndex() {
        return this.displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImagePosition getImagePosition() {
        return this.imagePosition;
    }

    public void setImagePosition(ImagePosition imagePosition) {
        this.imagePosition = imagePosition;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
