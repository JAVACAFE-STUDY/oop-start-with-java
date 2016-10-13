package net.chandol.study.oop.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

import static java.util.Objects.nonNull;

@Entity
@Getter
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Status status;
    private String name;
    private String description;
    private Boolean archive;
    private Integer sortValue;

    protected Task() {}

    public Task(Status status, String name, String description, Integer sortValue) {
        this.name = name;
        this.description = description;
        this.archive = false;
        this.setStatus(status);
        this.setSortValue(sortValue);
    }

    public void setSortValue(int sortValue) {
        this.sortValue = sortValue;
    }

    private void setStatus(Status status){
        if(nonNull(this.status))
            this.status.removeTask(this);

        this.status = status;
        status.addTask(this);
    }
}
