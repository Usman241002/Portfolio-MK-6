package dev.ukhalid.portfolio_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SKILLS")
public class Skill {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "START_DATE")
    private LocalDate startDate;

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

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
