package dev.ukhalid.portfolio_api.model;

import dev.ukhalid.portfolio_api.model.enums.ImagePosition;
import jakarta.persistence.*;

@Entity
@Table(name = "PROJECT_SECTION")
public class ProjectSection {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "DISPLAY_INDEX")
    private Integer displayIndex;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "IMAGE_POSITION")
    private ImagePosition imagePosition = ImagePosition.NONE;
    @Column(name = "CONTEXT")
    private String context;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
