package dev.ukhalid.portfolio_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EDUCATION")
public class Education {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "INSTITUTION")
    private String institution;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "START_DATE")
    private LocalDate startDate;
    @Column(name = "END_DATE")
    private LocalDate endDate;
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "DESCRIPTION")
    private String description;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
