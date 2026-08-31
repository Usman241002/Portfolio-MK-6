package dev.ukhalid.portfolio_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROJECT_SKILLS")
public class ProjectSkill {
    @Column(name = "PROJECT_ID")
    private Integer projectId;

    @Column(name = "SKILL_ID")
    private Integer skillId;

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}
