package net.chandol.study.oop.task.model;

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
    private Status status;
    private String name;
    private String description;
    private Boolean archive;
    @Column(name = "ORDER_NUMBER")
    private Integer order;

    protected Task() {}

    public Task(Status status, String name, String description, Integer order) {
        this.name = name;
        this.description = description;
        this.archive = false;
        this.setStatus(status);
        this.setOrder(order);
    }

    public void setOrder(int order) {
        this.order = order;
    }

    private void setStatus(Status status){
        if(nonNull(this.status))
            this.status.removeTask(this);

        this.status = status;
        status.addTask(this);
    }
}
