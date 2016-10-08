package net.chandol.study.oop.task.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean archive;

    public Project() {}

    public Project(String name) {
        this.name = name;
        this.archive = false;
    }

    public void setName(String name) {
        this.name = name;
    }
}
